package data_access;

import entity.*;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.guestuser.GuestDataAccessInterface;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InMemoryUserDataAccessObject implements GuestDataAccessInterface, ChooseDataAccessInterface, CalculateScoreDataAccessInterface {

    private User current_user = null;
    private boolean isGuestUser = false;
    private final File preferencesCsvFile = new File("preferences.csv");
    private final Map<String, CommonUser> accounts = new HashMap<>(); // In the form: {String userID: User user}
    private final Map<String, Integer> preferencesHeaders = new LinkedHashMap<>();
    public User getCurrent_user() {
        return current_user;
    }
    public void setCurrent_user(User current_user) {
        this.current_user = current_user;
    }
    @Override
    public void saveGuest(GuestUser user) {
        current_user = user;
    }

    public InMemoryUserDataAccessObject(){
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

                    // Gives the cities as a single string
                    String cities = "";
                    for ( int i = preferencesHeaders.get("cities"); i < col.length; i++){
                        cities += col[i] + ",";
                    }
                    // Deletes the last comma:
                    cities = cities.substring(0, cities.length() - 1);


                    // Creates a WeatherPref instance for the User to be created
                    WeatherPref weatherPref = new WeatherPref(Integer.parseInt(temperature), Integer.parseInt(humidity),
                            Integer.parseInt(windspeed), Integer.parseInt(temperatureweight),
                            Integer.parseInt(humidityweight), Integer.parseInt(windspeedweight));

                    // Extracts the city,country String pairs from the 'cities' String:

                    List<String> cityList = new ArrayList<>();

                    // Define the pattern for extracting city and country pairs
                    Pattern pattern = Pattern.compile("\\[([^,]+,[^\\]]+)\\]");
                    Matcher matcher = pattern.matcher(cities);
                    // System.out.println(cities);

                    // Find matches and add them to the list
                    while (matcher.find()) {
                        cityList.add(matcher.group(1));
                    }
                    // Turns city names into temporary list of type City
                    ArrayList<City> tempCityList = new ArrayList<City>();
                    for (String cityName : cityList){
                        tempCityList.add(new City(cityName));
                    }

                    System.out.println(cityList);
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
        current_user = currentUser;
        int user_id = current_user.getUserID();
        CommonUser user = CommonUserFactory.create(user_id, weatherPref, cityList);
        accounts.put(String.valueOf(user_id), user);
        this.savePreferences();


    }

    private void savePreferences() {
        // If user is a guest:
        if (current_user.getUserID() == 0) {
            isGuestUser = true;
        } else {
            // Needs to write to the save file to save the preferences.
            System.out.println("Preferences saved to Save file");
            BufferedWriter writer;

            try {
                writer = new BufferedWriter(new FileWriter(preferencesCsvFile));
                writer.write(String.join(",", preferencesHeaders.keySet()));
                writer.newLine();


                for (User user : accounts.values()) {
                    WeatherPref currPreferences = user.getPreferences();

                    // Need to obtain a list of city names from the user's list of cities:
                    ArrayList<String> cityNamesList = new ArrayList<>();
                    for (City city : user.getCityList()){
                        cityNamesList.add(city.getName());
                    }

                    String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", String.valueOf(user.getUserID()),
                            currPreferences.getUserTempPreference(), currPreferences.getUserTempPreferenceScore(),
                            currPreferences.getUserHumidityPreference(), currPreferences.getUserHumidityPreferenceScore(),
                            currPreferences.getUserWindSpeedPreference(), currPreferences.getUserWindSpeedPreferenceScore(),
                            cityNamesList.toString());
                    writer.write(line);
                    writer.newLine();

                }
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


        @Override
    public void setCurr_User(User user) {
        this.current_user = user;
    }

    @Override
    public User getCurr_User() {
        return current_user;
    }
}
