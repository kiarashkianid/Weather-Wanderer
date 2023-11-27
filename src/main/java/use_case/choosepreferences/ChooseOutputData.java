package use_case.choosepreferences;

import entity.City;
import entity.WeatherPref;

import java.util.ArrayList;

public class ChooseOutputData {
    private final WeatherPref weatherPref;

    public WeatherPref getWeatherPref() {
        return weatherPref;
    }

    private final ArrayList<City> cityList;

    public ArrayList<City> getCityList() {
        return cityList;
    }

    public ChooseOutputData(WeatherPref weatherPref, ArrayList<City> cityList){
        this.weatherPref = weatherPref;
        this.cityList = cityList;
    }
}
