package use_case.CalculateScore;

import entity.WeatherData;
import entity.WeatherPref;

// Updated Input data class used by the Controller
public class CalculateScoreInputData {
    private final WeatherPref userPreferences;
    private final WeatherData weatherData;

    public CalculateScoreInputData(
            WeatherPref userPreferences,
            WeatherData weatherData
    ) {
        this.userPreferences = userPreferences;
        this.weatherData = weatherData;

    }

    public WeatherPref getUserPreferences() {
        return userPreferences;
    }

    public WeatherData getWeatherData() { return weatherData;}

}

