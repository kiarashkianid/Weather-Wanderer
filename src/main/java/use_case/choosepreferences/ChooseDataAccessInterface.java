package use_case.choosepreferences;

import entity.WeatherPref;

import java.util.ArrayList;

public interface ChooseDataAccessInterface {
    void save(int temp, int Humidity, int windSpeed, ArrayList<String> cityList);
}
