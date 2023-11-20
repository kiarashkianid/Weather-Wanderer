package use_case.CalculateScore;

import entity.WeatherPref;

// Updated Input data class used by the Controller
public class CalculateScoreInputData {
    private WeatherPref userPreferences;
    private double actualTemperature;
    private double actualHumidity;
    private double actualPrecipitation;

    public CalculateScoreInputData(
            WeatherPref userPreferences,
            double actualTemperature,
            double actualHumidity,
            double actualPrecipitation
    ) {
        this.userPreferences = userPreferences;
        this.actualTemperature = actualTemperature;
        this.actualHumidity = actualHumidity;
        this.actualPrecipitation = actualPrecipitation;
    }

    public WeatherPref getUserPreferences() {
        return userPreferences;
    }

    public double getActualTemperature() {
        return actualTemperature;
    }

    public double getActualHumidity() {
        return actualHumidity;
    }

    public double getActualPrecipitation() {
        return actualPrecipitation;
    }
}

