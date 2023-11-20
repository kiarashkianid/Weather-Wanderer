package entity;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class NormalUser implements User {
    private int userID;
    private String username;
    private String password;
    private WeatherPref weatherPreference;
    private List<City> cityList;

    private static List<NormalUser> savedCities = new ArrayList<>();

    public NormalUser(int userID, String username, String password, WeatherPref weatherPreference, List<City> cityList)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = weatherPreference;
        this.cityList = cityList;

        savedCities.add(this);
    }

    public NormalUser(int userID, String username, String password)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = null;
        this.cityList = null;

        savedCities.add(this);
    }



    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }
}
