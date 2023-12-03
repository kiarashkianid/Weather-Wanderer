package use_case.CalculateScore;

import entity.City;
import entity.User;
import entity.WeatherPref;
import entity.WeatherScore;

import java.util.List;

// Interactor responsible for executing the CalculateScore use case
public class CalculateScoreInteractor implements CalculateScoreInputBoundary {

    final CalculateScoreDataAccessInterface userDataAccessObject;
    final CalculateScoreOutputBoundary calculateScorePresenter;

    // Constructor to initialize the interactor with necessary dependencies
    public CalculateScoreInteractor(CalculateScoreDataAccessInterface userDataAccessObject,
                                    CalculateScoreOutputBoundary calculateScorePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.calculateScorePresenter = calculateScorePresenter;
    }

    @Override
    public void execute(CalculateScoreInputData inputData) {
        // Retrieve user preferences and added cities from the input data
        WeatherPref userPreferences = inputData.getUserPreferences();
        List<City> cities = inputData.getAddedCities();

        // Retrieve current user and their cities from the data access object
        User inMemoUser = userDataAccessObject.getCurr_User();
        List<City> currentUserCities = inMemoUser.getCityList();

        // Calculate weather scores for each added city and update the scores
        for (City city : cities) {
            // Fetch actual weather data (temperature, humidity, wind speed) for the city from weather data API
            double actualTemperature = city.getWeatherData().temperature();
            double actualHumidity = city.getWeatherData().humidity();
            double actualPrecipitation = city.getWeatherData().windSpeed();

            // Retrieve user preferences and weights for temperature, humidity, and wind speed
            int userTempPreference = userPreferences.getUserTempPreference();
            int userHumidityPreference = userPreferences.getUserHumidityPreference();
            int userWindSpeedPreference = userPreferences.getUserWindSpeedPreference();
            int userTempWeight = userPreferences.getUserTempPreferenceScore();
            int userHumidityWeight = userPreferences.getUserHumidityPreferenceScore();
            int userWindSpeedWeight = userPreferences.getUserWindSpeedPreferenceScore();
            CalculateWeatherScoreAlgorithm calculateWeatherScoreAlgorithm=new CalculateWeatherScore();
            // Calculate overall weather score for the city
            int overallScore = calculateWeatherScoreAlgorithm.calculateOverallWeatherScore(
                    userTempPreference, userHumidityPreference, userWindSpeedPreference,
                    actualTemperature, actualHumidity, actualPrecipitation,
                    userTempWeight, userHumidityWeight, userWindSpeedWeight
            );

            // Set the calculated weather score for the city
            city.setWeatherScore(new WeatherScore(overallScore));
        }

        // Update the current user's city list with the calculated weather scores
        for (City city : currentUserCities) {
            for (City city1 : cities) {
                if (city.name.equals(city1.name)) {
                    city.setWeatherScore(city1.getWeatherScore());
                }
            }
        }

        // Update the user in the data access object with the modified city list
        userDataAccessObject.setCurrent_user(inMemoUser);

        // Find the city with the highest weather score among the user's cities
        City cityWithHighestScore = currentUserCities.get(0); // Initialize with the first city
        int highestScore = currentUserCities.get(0).getWeatherScore().weather_score; // Initialize with the score of the first city

        // Find the city with the highest weather score
        for (City city : currentUserCities) {
            int currentScore = city.getWeatherScore().weather_score;
            if (currentScore > highestScore) {
                highestScore = currentScore;
                cityWithHighestScore = city;
            }
        }

        // Determine success or failure based on the highest score
        if (cityWithHighestScore.getWeatherScore().weather_score >= 1 &&
                cityWithHighestScore.getWeatherScore().weather_score <= 100) {
            // If highest score is within a valid range, prepare success view
            CalculateScoreOutputData calculateScoreOutputData = new CalculateScoreOutputData(cityWithHighestScore);
            calculateScorePresenter.prepareSuccessView(calculateScoreOutputData);
        } else {
            // If highest score is not within valid range, prepare failure view
            calculateScorePresenter.prepareFailView("Calculation failed, please try again!");
        }
    }
}
