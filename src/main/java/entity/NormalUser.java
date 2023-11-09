package entity;

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

}
