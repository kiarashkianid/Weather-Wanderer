package entity;

import java.util.ArrayList;
import java.util.List;

public class GuestUser implements User {
    private final int userID = 0;

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

    }

    @Override
    public List<City> getCityList() {
        return cityList;
    }

    @Override
    public void setCityList(List<City> cityList) {

    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    private final WeatherPref weatherPreference;
    private final List<City> cityList;

    public GuestUser(WeatherPref weatherPref, List<City> cityList) {
        this.weatherPreference = weatherPref;
        this.cityList = cityList;
    }
}
