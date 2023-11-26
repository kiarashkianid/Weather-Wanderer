package use_case.CalculateScore;

import entity.City;
import entity.WeatherPref;

import java.util.List;

// Updated Input data class used by the Controller
public class CalculateScoreInputData {
    private final WeatherPref userPreferences;
    private final List<City> addedCity;

    public CalculateScoreInputData(
            WeatherPref userPreferences,
            List<City> addedCity) {
        this.userPreferences = userPreferences;

        this.addedCity = addedCity;
    }

    public WeatherPref getUserPreferences() {
        return userPreferences;
    }

    public List<City> getAddedCities(){return addedCity;}

}

