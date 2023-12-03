package interface_adapter.calculate_score;

import entity.City;
import entity.WeatherPref;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInputData;

import java.util.List;

// Modified Controller responsible for handling user input and triggering the use case
public class CalculateScoreController {
    final CalculateScoreInputBoundary calculateScoreInteractor; // Interactor for executing the use case

    // Constructor to initialize the CalculateScoreController
    public CalculateScoreController(CalculateScoreInputBoundary calculateScoreInteractor) {
        this.calculateScoreInteractor = calculateScoreInteractor;
    }

    /**
     * Executes the use case to calculate the score based on user preferences and added cities.
     * @param userPreferences The WeatherPref object representing user's weather preferences.
     * @param addedCity The List of City objects representing added cities.
     */
    public void execute(WeatherPref userPreferences, List<City> addedCity) {
        CalculateScoreInputData calculateScoreInputData; // Input data for the use case

        // Create CalculateScoreInputData with user preferences and added cities
        calculateScoreInputData = new CalculateScoreInputData(userPreferences, addedCity);

        // Execute the use case via the CalculateScoreInputBoundary (interactor)
        calculateScoreInteractor.execute(calculateScoreInputData);
    }
}
