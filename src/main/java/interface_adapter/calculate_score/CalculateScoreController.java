package interface_adapter.calculate_score;

import entity.WeatherData;
import entity.WeatherPref;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInputData;

// Modified Controller responsible for handling user input and triggering the use case
public class CalculateScoreController {
    final CalculateScoreInputBoundary calculateScoreInteractor;

    public CalculateScoreController(CalculateScoreInputBoundary calculateScoreInteractor) {
        this.calculateScoreInteractor = calculateScoreInteractor;
    }


    public void execute(WeatherPref userPreferences,
                        WeatherData weatherData) {
        CalculateScoreInputData calculateScoreInputData;
        calculateScoreInputData = new CalculateScoreInputData( userPreferences, weatherData);
        calculateScoreInteractor.execute(calculateScoreInputData);
    }
}


