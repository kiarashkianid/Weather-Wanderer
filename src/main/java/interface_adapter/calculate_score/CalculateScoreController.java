package interface_adapter.calculate_score;

import entity.City;
import entity.WeatherPref;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInputData;

import java.util.List;

// Modified Controller responsible for handling user input and triggering the use case
public class CalculateScoreController {
    final CalculateScoreInputBoundary calculateScoreInteractor;

    public CalculateScoreController(CalculateScoreInputBoundary calculateScoreInteractor) {
        this.calculateScoreInteractor = calculateScoreInteractor;
    }


    public void execute(WeatherPref userPreferences, List<City> addedCity) {
        CalculateScoreInputData calculateScoreInputData;
        calculateScoreInputData = new CalculateScoreInputData( userPreferences, addedCity);
        calculateScoreInteractor.execute(calculateScoreInputData);
    }
}


