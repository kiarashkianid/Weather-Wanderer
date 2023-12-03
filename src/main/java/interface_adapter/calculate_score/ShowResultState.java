package interface_adapter.calculate_score;

import entity.City;
import entity.WeatherScore;
import use_case.CalculateScore.CalculateScoreOutputData;
import use_case.choosepreferences.ChooseOutputData;

import java.util.ArrayList;

/**
 * State class representing the result to be shown after calculating the score.
 * Contains city information and the final weather score.
 */
public class ShowResultState {

    // Fields to store city and final weather score
    private City city;
    private WeatherScore finalScore;
    private ArrayList<City> cities;

    // Copy constructor for creating a new instance by copying another ShowResultState instance
    public ShowResultState(ShowResultState copy, ArrayList<City> cities) {
        city = copy.city;
        finalScore = copy.finalScore;
        cities=copy.cities;
    }

    /**
     * Sets the final score and city based on the CalculateScoreOutputData.
     * @param cityWithHighestScore The CalculateScoreOutputData containing the city and its score.
     */
    public void setFinalScore(CalculateScoreOutputData cityWithHighestScore) {
        // Setting the city and its weather score from the CalculateScoreOutputData
        this.city = cityWithHighestScore.getCity();
        this.finalScore = cityWithHighestScore.getCity().getWeatherScore();
    }

    /**
     * Retrieves the city from the ShowResultState.
     * @return The City object representing the city associated with the result state.
     */
    public City getCity() {
        return city;
    }

    /**
     * Retrieves the final weather score from the ShowResultState.
     * @return The WeatherScore object representing the final score associated with the result state.
     */
    public WeatherScore getFinalScore() {
        return finalScore;
    }

    /**
     * Sets the final score error message.
     * @param error The error message related to the final score calculation.
     */
    public void setFinalScoreError(String error) {
        // Method to set the error message related to the final score calculation if needed
        // Currently empty as there is no implementation for setting the error message in this example
    }

    public void setPreferences(ChooseOutputData chooseOutputData) {
    }

    public ArrayList<City> getCities() { return this.cities;
    }
}
