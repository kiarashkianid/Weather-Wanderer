package use_case.CalculateScore;

import entity.City;
import entity.WeatherPref;

import java.util.List;

// Represents the input data used by the Controller for CalculateScore use case
public class CalculateScoreInputData {

    // User's weather preferences
    private final WeatherPref userPreferences;

    // List of added cities for weather score calculation
    private final List<City> addedCity;

    /**
     * Constructor to initialize CalculateScoreInputData.
     *
     * @param userPreferences The user's weather preferences.
     * @param addedCity       List of cities for which weather scores are to be calculated.
     */
    public CalculateScoreInputData(WeatherPref userPreferences, List<City> addedCity) {
        this.userPreferences = userPreferences;
        this.addedCity = addedCity;
    }

    /**
     * Retrieves the user's weather preferences.
     *
     * @return The WeatherPref object representing the user's weather preferences.
     */
    public WeatherPref getUserPreferences() {
        return userPreferences;
    }

    /**
     * Retrieves the list of added cities for weather score calculation.
     *
     * @return The list of City objects representing added cities for score calculation.
     */
    public List<City> getAddedCities() {
        return addedCity;
    }
}
