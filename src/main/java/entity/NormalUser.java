package entity;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class NormalUser implements User {
    private int userID;

    public void setUserID(int userID) {
        this.userID = userID;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private WeatherPref weatherPreference;

    public WeatherPref getWeatherPreference() {
        return weatherPreference;
    }

    public void setWeatherPreference(WeatherPref weatherPreference) {
        this.weatherPreference = weatherPreference;
    }

    private List<City> cityList;
    @Override
    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    private static List<NormalUser> savedCities = new ArrayList<>();

    public static List<NormalUser> getSavedCities() {
        return savedCities;
    }

    public static void setSavedCities(List<NormalUser> savedCities) {
        NormalUser.savedCities = savedCities;
    }

    public NormalUser(int userID, String username, String password, WeatherPref weatherPreference, List<City> cityList)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = weatherPreference;
        this.cityList = cityList;

        savedCities.add(this);
    }

    public static void main (String[] args)
    { //(hopefully) this creates a txt file which stores every NormalUser's userid, name, and list of cities
        String txtfile = "savedUsers.txt";
        try {
            FileWriter fileWriter = new FileWriter(txtfile);
            for (NormalUser user: savedCities)
            {
                fileWriter.write(Integer.toString(user.userID) + " " + user.username);
                for (City city: user.cityList)
                {
                    fileWriter.write(city.name);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    public int getUserID() {
        return userID;
    }

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public WeatherPref getPreferences() {
        return weatherPreference;
    }

    @Override
    public void setPreferences(WeatherPref weatherPref) {
        this.weatherPreference = weatherPref;
    }

    @Override
    public List<String> getCityList() {
        return cityList;
    }
}
