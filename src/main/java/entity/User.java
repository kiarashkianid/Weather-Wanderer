package entity;

import java.util.ArrayList;
import java.util.List;

public interface User {

    public int getUserID();

    public WeatherPref getPreferences();

    public void setPreferences(WeatherPref weatherPref);

    public List<String> getCityList();

    public void setCityList(List<String> cityList);

}
