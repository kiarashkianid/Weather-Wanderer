/*
package interface_adapter.calculate_score;

import entity.City;
import entity.WeatherPref;
import use_case.choosepreferences.ChooseOutputData;

import java.util.ArrayList;

// Represents the state used for calculating the weather score
public class CalculateScoreState {
    private WeatherPref weatherPref; // Weather preferences
    private ArrayList<City> addedCities; // List of added cities for calculation

    // Constructor (empty)
    public CalculateScoreState() {
        // Empty constructor
    }

    // Copy constructor for creating a new instance by copying another CalculateScoreState instance
    public CalculateScoreState(CalculateScoreState copy) {
        weatherPref = copy.weatherPref;
        addedCities = copy.addedCities;
    }

    /**
     * Set weather preferences and added cities based on the ChooseOutputData.
     * @param preferences The ChooseOutputData containing weather preferences and city list.
     *//*
    public void setPreferences(ChooseOutputData preferences) {
        this.weatherPref = preferences.getWeatherPref(); // Set weather preferences
        this.addedCities = preferences.getCityList(); // Set added cities
    }

    /**
     * Get the list of added cities.
     * @return The ArrayList of City objects representing the added cities.
     *//*
    public ArrayList<City> getCities() {
        return this.addedCities;
    }

    /**
     * Get the weather preferences.
     * @return The WeatherPref object representing the weather preferences.
     *//*
    public WeatherPref getWeatherPref() {
        return this.weatherPref;
    }

    /**
     * Set the final score error message.
     * @param error The error message related to the final score calculation.
     *//*
    public void setFinalScoreError(String error) {
        // Method to set the error message related to the final score calculation if needed
        // Currently empty as there is no implementation for setting the error message in this example
    }
}
*/