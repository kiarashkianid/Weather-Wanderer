package use_case.choosepreferences;

import java.util.ArrayList;

public class ChooseOutputData {
    private final int temperature;

    public int getTemperature() {
        return temperature;
    }

    private final int humidity;

    public int getHumidity() {
        return humidity;
    }

    private final int windSpeed;

    public int getWindSpeed() {
        return windSpeed;
    }

    private final ArrayList<String> cityList;

    public ArrayList<String> getCityList() {
        return cityList;
    }

    public ChooseOutputData(int temperature, int humidity, int windSpeed, ArrayList<String> cityList){
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.cityList = cityList;
    }
}
