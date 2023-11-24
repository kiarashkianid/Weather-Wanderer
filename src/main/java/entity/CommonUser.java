package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CommonUser implements User{
    private int userID;
    private WeatherPref weatherPref;
    private List<String> cityList;
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
    public List<String> getCityList() {
        return cityList;
    }

    @Override
    public void setCityList(List<String> cityList) {
        this.cityList = cityList;
    }
    CommonUser(int userID, WeatherPref weatherPref, List<String> cityList) {
        this.userID = userID;
        this.weatherPref = weatherPref;
        this.cityList = cityList;
    }

}
