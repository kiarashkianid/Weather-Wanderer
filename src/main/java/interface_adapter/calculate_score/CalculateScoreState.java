package interface_adapter.calculate_score;
//TODO

import entity.City;
import entity.WeatherPref;
import use_case.choosepreferences.ChooseOutputData;

import java.util.ArrayList;

public class CalculateScoreState {
    private WeatherPref weatherPref;
    private ArrayList<City> addedCities;

    public CalculateScoreState(){
    }

    public CalculateScoreState(CalculateScoreState copy) {
        weatherPref=copy.weatherPref;
        addedCities=copy.addedCities;
    }

    public void setPreferences(ChooseOutputData preferences) {
        this.weatherPref=preferences.getWeatherPref();
        this.addedCities=preferences.getCityList();;

    }

    public void setFinalScoreError(String error) {

    }
}
