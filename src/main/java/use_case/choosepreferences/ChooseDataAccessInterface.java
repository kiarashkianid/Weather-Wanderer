package use_case.choosepreferences;

import entity.WeatherPref;

import java.util.ArrayList;

public interface ChooseDataAccessInterface {
    void savePreferences(int temp, int Humidity, int windSpeed, ArrayList<String> cityList);
}
