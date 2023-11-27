package entity;

import java.util.List;

public interface User {

    public int getUserID();

    public WeatherPref getPreferences();

    public void setPreferences(WeatherPref weatherPref);

    public List<City> getCityList();

    public void setCityList(List<City> cityList);

}
