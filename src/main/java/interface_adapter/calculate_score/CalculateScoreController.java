package interface_adapter.calculate_score;

import entity.WeatherPref;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInputData;

// Modified Controller responsible for handling user input and triggering the use case
public class CalculateScoreController {
    private CalculateScoreInputBoundary interactor;

    public CalculateScoreController(CalculateScoreInputBoundary interactor) {
        this.interactor = interactor;
    }

    public void calculateWeatherScore(
            WeatherPref userPreferences,
            double actualTemperature,
            double actualHumidity,
            double actualPrecipitation
    ) {
        CalculateScoreInputData inputData = new CalculateScoreInputData(
                userPreferences,
                actualTemperature,
                actualHumidity,
                actualPrecipitation
        );
        interactor.calculateWeatherScore(inputData);
    }
}
