package use_case.choosepreferences;

import java.util.ArrayList;

public class ChooseInputData {

    final private int temperature;

    final private int humidity;

    final private int windSpeed;

    final private ArrayList<String> cityList;

    public ChooseInputData(int temperature, int humidity, int windSpeed, ArrayList<String> cityList){
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.cityList = cityList;
    }
}
