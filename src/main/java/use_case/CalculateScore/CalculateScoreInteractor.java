package use_case.CalculateScore;

import entity.WeatherData;
import entity.WeatherPref;

public class CalculateScoreInteractor implements CalculateScoreInputBoundary {
    final CalculateScoreDataAccessInterface userDataAccessObject;
    final CalculateScoreOutputBoundary calculateScorePresenter;


    public CalculateScoreInteractor(CalculateScoreDataAccessInterface userDataAccessObject, CalculateScoreOutputBoundary calculateScorePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.calculateScorePresenter = calculateScorePresenter;
    }

    @Override
    public void execute(CalculateScoreInputData inputData) {
        WeatherPref userPreferences = inputData.getUserPreferences();
        WeatherData weatherData = inputData.getWeatherData();

        double idealTemp = weatherData.getIdealTemp()/* Get ideal temperature from user preferences */;
        double idealHumidity =weatherData.getIdealHumidity() /* Get ideal humidity from user preferences */;
        double idealWindSpeed = weatherData.getIdealWindspeed()/* Get ideal windspeed from user preferences */;

        double actualTemperature = weatherData.temperature()/* Fetch actual temperature from weather data API */;
        double actualHumidity =weatherData.humidity() /* Fetch actual humidity from weather data API */;
        double actualPrecipitation =weatherData.windSpeed() /* Fetch actual precipitation from weather data API */;

        int userTempPreference = userPreferences.getUserTempPreference();
        int userHumidityPreference = userPreferences.getUserHumidityPreference();
        int userWindSpeedPreference = userPreferences.getUserWindSpeedPreference();

        int userTempWeight = userPreferences.getUserTempPreferenceScore();
        int userHumidityWeight = userPreferences.getUserHumidityPreferenceScore();
        int userWindSpeedWeight= userPreferences.getUserWindSpeedPreferenceScore();

        int overallScore = CalculateWeatherScore.calculateOverallWeatherScore(
                 idealTemp, idealHumidity, idealWindSpeed,
                userTempPreference, userHumidityPreference, userWindSpeedPreference,
                actualTemperature, actualHumidity, actualPrecipitation,userTempWeight,userHumidityWeight,userWindSpeedWeight
        );

        // Further logic like saving the weather score or sending it to the output boundary TODO
    }
}
