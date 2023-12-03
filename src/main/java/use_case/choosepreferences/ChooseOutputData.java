package use_case.choosepreferences;

import entity.City;
import entity.WeatherPref;

import java.util.ArrayList;
import java.util.List;

public class ChooseOutputData {
    private final WeatherPref weatherPref;

    public WeatherPref getWeatherPref() {
        return weatherPref;
    }

    private final List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    public ChooseOutputData(WeatherPref weatherPref, List<City> cityList){
        this.weatherPref = weatherPref;
        this.cityList = cityList;
    }
}
