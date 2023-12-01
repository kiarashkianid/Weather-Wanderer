package interface_adapter.calculate_score;
import entity.City;
import entity.WeatherPref;
import use_case.choosepreferences.ChooseOutputData;

import java.util.ArrayList;
import java.util.List;

public class CalculateScoreState {
    private WeatherPref weatherPref;


    private ArrayList<City> addedCities;

    public ArrayList<City> getAddedCities() {
        return addedCities;
    }

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

    public ArrayList<City> getCities(){return this.addedCities;}
    public WeatherPref getWeatherPref(){return this.weatherPref;}
    public void setFinalScoreError(String error) {

    }
}
