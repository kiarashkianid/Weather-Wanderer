package interface_adapter.choose_preferences;

import java.util.ArrayList;

public class ChooseState {



    // Needs all 3 prefs & cityList so that weatherScore can access them.
    private int temperature;
    private int temperatureWeight;

    private int humidity;
    private int humidityWeight;
    private int windSpeed;
    private int windSpeedWeight;
    private ArrayList<String> cityList;

    public ChooseState(ChooseState copy){
        temperature = copy.temperature;
        temperatureWeight = copy.temperatureWeight;
        humidity = copy.humidity;
        humidityWeight = copy.humidityWeight;
        windSpeed = copy.windSpeed;
        windSpeedWeight = copy.windSpeedWeight;
        cityList = copy.cityList;
    }

    public ChooseState(){

    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getTemperatureWeight() {
        return temperatureWeight;
    }

    public void setTemperatureWeight(int temperatureWeight) {
        this.temperatureWeight = temperatureWeight;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getHumidityWeight() {
        return humidityWeight;
    }

    public void setHumidityWeight(int humidityWeight) {
        this.humidityWeight = humidityWeight;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public int getWindSpeedWeight() {
        return windSpeedWeight;
    }

    public void setWindSpeedWeight(int windSpeedWeight) {
        this.windSpeedWeight = windSpeedWeight;
    }

    public ArrayList<String> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<String> cityList) {
        this.cityList = cityList;
    }

    public void setPreferencesError(String error) {
    }
}
