package data_access;

import app.NormalUserFactory;
import entity.*;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.choosepreferences.ChooseDataAccessInterface;
import entity.City;
import entity.NormalUser;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class FileUserDataAccessObject implements ChooseDataAccessInterface {

 //still needs to be worked on


    private final File preferencesCsvFile = new File("preferences.csv");

    private final Map<String, Integer> preferencesHeaders = new LinkedHashMap<>();

    private User curr_User;

    private final Map<String, CommonUser> accounts = new HashMap<>(); // In the form: {String userID: User user}

    public User getCurr_User() {
        return curr_User;
    }

    public void setCurr_User(User curr_User) {
        this.curr_User = curr_User;
    }

    private boolean isGuestUser = false;

    public FileUserDataAccessObject(UserFactory userFactory){
        preferencesHeaders.put("userid", 0);
        preferencesHeaders.put("temperature", 1);
        preferencesHeaders.put("temperatureweight", 2);
        preferencesHeaders.put("humidity", 3);
        preferencesHeaders.put("humidityweight", 4);
        preferencesHeaders.put("windspeed", 5);
        preferencesHeaders.put("windspeedweight", 6);
        preferencesHeaders.put("cities", 7);

        if (preferencesCsvFile.length() == 0) {
            savePreferences();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(preferencesCsvFile))) {
                String header = reader.readLine();

                assert header.equals("userid,temperature,temperatureweight,humidity,humidityweight,windspeed," +
                        "windspeedweight,cities");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String userid = String.valueOf(col[preferencesHeaders.get("userid")]);
                    String temperature = String.valueOf(col[preferencesHeaders.get("temperature")]);
                    String temperatureweight = String.valueOf(col[preferencesHeaders.get("temperatureweight")]);
                    String humidity = String.valueOf(col[preferencesHeaders.get("humidity")]);
                    String humidityweight = String.valueOf(col[preferencesHeaders.get("humidityweight")]);
                    String windspeed = String.valueOf(col[preferencesHeaders.get("windspeed")]);
                    String windspeedweight = String.valueOf(col[preferencesHeaders.get("windspeedweight")]);
                    String cities = String.valueOf(col[preferencesHeaders.get("cities")]);

                    // Creates a WeatherPref instance for the User to be created
                    WeatherPref weatherPref = new WeatherPref(Integer.parseInt(temperature), Integer.parseInt(humidity),
                            Integer.parseInt(windspeed), Integer.parseInt(temperatureweight),
                            Integer.parseInt(humidityweight), Integer.parseInt(windspeedweight));

                    // Extracts the city,country String pairs from the 'cities' String:

                    List<String> cityList = new ArrayList<>();

                    // Define the pattern for extracting city and country pairs
                    Pattern pattern = Pattern.compile("\\b([^,]+,[^\\]]+)\\b");
                    Matcher matcher = pattern.matcher(cities);

                    // Find matches and add them to the list
                    while (matcher.find()) {
                        cityList.add(matcher.group(1));
                    }
                    // Turns city names into temporary list of type City
                    ArrayList<City> tempCityList = new ArrayList<City>();
                    for (String cityName : cityList){
                        tempCityList.add(new City(cityName));
                    }


                    CommonUser user = CommonUserFactory.create(Integer.parseInt(userid), weatherPref, tempCityList);
                    accounts.put(userid, user);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public void savePreferences(User currentUser, WeatherPref weatherPref, ArrayList<City> cityList){
        curr_User = currentUser;
        int user_id = curr_User.getUserID();
        CommonUser user = CommonUserFactory.create(user_id, weatherPref, cityList);
        accounts.put(String.valueOf(user_id), user);
        this.savePreferences();
    }

    private void savePreferences() {
        // If user is a guest:
        if (curr_User.getUserID() == 0){
            isGuestUser = true;
        }
        else {
            // Needs to write to the save file to save the preferences.
            System.out.println("Preferences saved to Save file");
            BufferedWriter writer;

                try {
                    writer = new BufferedWriter(new FileWriter(preferencesCsvFile));
                    writer.write(String.join(",", preferencesHeaders.keySet()));
                    writer.newLine();


                    for (User user : accounts.values()) {
                        WeatherPref currPreferences = user.getPreferences();

                        String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", String.valueOf(user.getUserID()),
                                currPreferences.getUserTempPreference(), currPreferences.getUserTempPreferenceScore(),
                                currPreferences.getUserHumidityPreference(), currPreferences.getUserHumidityPreferenceScore(),
                                currPreferences.getUserWindSpeedPreference(), currPreferences.getUserWindSpeedPreferenceScore(),
                                user.getCityList().toString());
                        writer.write(line);
                        writer.newLine();

                        writer.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            }
            private void saveUser(){
                { //(hopefully) this creates a txt file which stores every NormalUser's userid, name, and list of cities
                    String txtfile = "savedUsers.txt";
                    try {
                        FileWriter fileWriter = new FileWriter(txtfile);
                        for (NormalUser user: UserListGateway.getUserList())
                        {
                            fileWriter.write(Integer.toString(user.getUserID()) + " " + user.getUsername());
                            for (City city: user.getCityList())
                            {
                                fileWriter.write(city.getName());
                            }
                        }
                        fileWriter.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
           }
        }
