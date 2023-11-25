package entity;

import java.util.ArrayList;
import java.util.List;

public class NormalUser implements User {
    private int userID;
    private String username;
    private String password;
    private WeatherPref weatherPreference;
    private List<City> cityList;

    public NormalUser(int userID, String username, String password, WeatherPref weatherPreference, List<City> cityList)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = weatherPreference;
        this.cityList = cityList;

    }

    public NormalUser(int userID, String username, String password)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = null;
        this.cityList = null;

    }



    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public void setCityList(List<City> cities) {
        this.cityList=cities;

    }
}
