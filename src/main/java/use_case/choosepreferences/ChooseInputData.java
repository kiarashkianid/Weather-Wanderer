package use_case.choosepreferences;

import entity.User;

import java.util.ArrayList;

public class ChooseInputData {


    final private int temperature;

    public int getTemperature() {
        return temperature;
    }
    final private int temperatureWeight;

    public int getTemperatureWeight() {
        return temperatureWeight;
    }


    public int getHumidity() {
        return humidity;
    }

    final private int humidity;
    public int getHumidityWeight() {
        return humidityWeight;
    }

    final private int humidityWeight;

    public int getWindSpeed() {
        return windSpeed;
    }

    final private int windSpeed;
    public int getWindSpeedWeight() {
        return windSpeedWeight;
    }

    final private int windSpeedWeight;

    public ArrayList<String> getCityList() {
        return cityList;
    }

    final private ArrayList<String> cityList;

    public ChooseInputData(int temperature, int temperatureWeight, int humidity, int humidityWeight, int windSpeed, int windSpeedWeight, ArrayList<String> cityList){
        this.temperature = temperature;
        this.temperatureWeight = temperatureWeight;
        this.humidity = humidity;
        this.humidityWeight = humidityWeight;
        this.windSpeed = windSpeed;
        this.windSpeedWeight = windSpeedWeight;
        this.cityList = cityList;
    }
}
