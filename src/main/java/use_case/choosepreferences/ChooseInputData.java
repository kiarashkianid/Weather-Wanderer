package use_case.choosepreferences;

import java.util.ArrayList;

public class ChooseInputData {

    final private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    final private int humidity;

    public int getWindSpeed() {
        return windSpeed;
    }

    final private int windSpeed;

    public ArrayList<String> getCityList() {
        return cityList;
    }

    final private ArrayList<String> cityList;

    public ChooseInputData(int temperature, int humidity, int windSpeed, ArrayList<String> cityList){
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.cityList = cityList;
    }
}
