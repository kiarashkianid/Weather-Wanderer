package data_access;

import entity.GuestUser;
import entity.User;
import entity.WeatherPref;
import use_case.choosepreferences.ChooseDataAccessInterface;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class FileUserDataAccessObject implements ChooseDataAccessInterface {

    private final File preferencesCsvFile = new File("preferences.csv");

    private final Map<String, Integer> preferencesHeaders = new LinkedHashMap<>();

    private User curr_User;

    public User getCurr_User() {
        return curr_User;
    }

    public void setCurr_User(User curr_User) {
        this.curr_User = curr_User;
    }

    private GuestUser guestUser = null;

    public FileUserDataAccessObject(){
        preferencesHeaders.put("userid", 0);
        preferencesHeaders.put("temperature", 1);
        preferencesHeaders.put("temperatureweight", 2);
        preferencesHeaders.put("humidity", 3);
        preferencesHeaders.put("humidityweight", 4);
        preferencesHeaders.put("windspeed", 5);
        preferencesHeaders.put("windspeedweight", 6);
        preferencesHeaders.put("cities", 7);

    }

    @Override
    public void savePreferences(WeatherPref weatherPref, ArrayList<String> cityList) {
        // If user is a guest:
        if (curr_User.getUserID() == 0){
            guestUser = new GuestUser(weatherPref, cityList);
        }
        else {
            curr_User.setPreferences(weatherPref);
            curr_User.setCityList(cityList);
            // Needs to write to the save file to save the preferences.
            System.out.println("Preferences saved to Save file");

            BufferedWriter writer;
            try {
                writer = new BufferedWriter(new FileWriter(preferencesCsvFile));
                writer.write(String.join(",", preferencesHeaders.keySet()));
                writer.newLine();

                WeatherPref currPreferences = curr_User.getPreferences();

                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s", String.valueOf(curr_User.getUserID()),
                        currPreferences.getUserTempPreference(), currPreferences.getUserTempPreferenceScore(),
                        currPreferences.getUserHumidityPreference(), currPreferences.getUserHumidityPreferenceScore(),
                        currPreferences.getUserWindSpeedPreference(), currPreferences.getUserWindSpeedPreferenceScore(),
                        cityList.toString());
                writer.write(line);
                writer.newLine();

                writer.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        }
    }
