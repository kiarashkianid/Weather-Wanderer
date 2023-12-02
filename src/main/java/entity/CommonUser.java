package entity;

import java.util.List;

public class CommonUser implements User{
    private int userID;
    private WeatherPref weatherPref;
    private List<City> cityList;
    @Override
    public int getUserID() {
        return userID;
    }

    @Override
    public WeatherPref getPreferences() {
        return weatherPref;
    }

    @Override
    public void setPreferences(WeatherPref weatherPref) {
        this.weatherPref = weatherPref;
    }

    @Override
    public List<City> getCityList() {
        return cityList;
    }

    @Override
    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getName() {
        return null;
    }

    public CommonUser(int userID, WeatherPref weatherPref, List<City> cityList) {
        this.userID = userID;
        this.weatherPref = weatherPref;
        this.cityList = cityList;
    }

}
