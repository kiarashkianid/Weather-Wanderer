package entity;

import java.util.List;

public class GuestUser implements User{
    private int userID;
    private String name;
    private String username;
    private String password;
    private WeatherPref weatherPreference;
    private List<City> cityList;

}
