package entity;

import java.util.List;

public class GuestUser implements User {
    private final int userID = 0;

    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public WeatherPref getPreferences() {
        return null;
    }

    @Override
    public void setPreferences(WeatherPref weatherPref) {

    }

    @Override
    public List<City> getCityList() {
        return null;
    }

    @Override
    public void setCityList(List<City> cityList) {

    }

    private WeatherPref weatherPreference;
    private List<City> cityList;

    public GuestUser(WeatherPref weatherPref, List<City> cityList) {
        this.weatherPreference = weatherPreference;
        this.cityList = cityList;
    }
}
