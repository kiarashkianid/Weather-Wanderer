package interface_adapter.choose_preferences;

import java.util.ArrayList;

public class ChooseState {



    // Needs all 3 prefs & cityList so that weatherScore can access them.
    private int temperature;

    private int humidity;

    private int windSpeed;

    private ArrayList<String> cityList;

    public ChooseState(ChooseState copy){
        temperature = copy.temperature;
        humidity = copy.humidity;
        windSpeed = copy.windSpeed;
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

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }
    public ArrayList<String> getCityList() {
        return cityList;
    }

    public void setCityList(ArrayList<String> cityList) {
        this.cityList = cityList;
    }

}
