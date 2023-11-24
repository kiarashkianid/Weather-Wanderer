package use_case.choosepreferences;

import entity.WeatherPref;

import java.util.ArrayList;

public class ChooseOutputData {
    private final WeatherPref weatherPref;

    public WeatherPref getWeatherPref() {
        return weatherPref;
    }

    private final ArrayList<String> cityList;

    public ArrayList<String> getCityList() {
        return cityList;
    }

    public ChooseOutputData(WeatherPref weatherPref, ArrayList<String> cityList){
        this.weatherPref = weatherPref;
        this.cityList = cityList;
    }
}
