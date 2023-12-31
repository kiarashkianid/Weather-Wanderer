package interface_adapter.choose_preferences;

import entity.City;
import entity.User;
import entity.WeatherPref;

import java.util.ArrayList;
import java.util.List;

public class ChooseState {

    private User currentUser;
    private List<City> addedCities;

    // Needs all 3 prefs & cityList so that weatherScore can access them.
    private int temperature;
    private int temperatureWeight;

    private int humidity;
    private int humidityWeight;
    private int windSpeed;
    private int windSpeedWeight;
    private ArrayList<String> cityList;

    public ChooseState(ChooseState copy){
        currentUser = copy.currentUser;
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

    public User getCurrentUser(){ return this.currentUser;}
    public void setCurrentUser(User user){ this.currentUser = user;}

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

    public List<City> getAddedCities() {
        return addedCities;
    }

    public void setAddedCities(List<City> addedCities) {
        this.addedCities = addedCities;
    }
}
