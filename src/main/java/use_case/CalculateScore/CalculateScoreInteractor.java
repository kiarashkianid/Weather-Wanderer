package use_case.CalculateScore;

import entity.City;
import entity.User;
import entity.WeatherPref;
import entity.WeatherScore;

import java.util.List;

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
        List<City> cities = inputData.getAddedCities();

        User inMemoUser=userDataAccessObject.getCurr_User();
        List<City> currentUserCities =inMemoUser.getCityList();
        for (City city: cities ) {

            double idealTemp = city.getWeatherData().getIdealTemp()/* Get ideal temperature from user preferences */;
            double idealHumidity = city.getWeatherData().getIdealHumidity() /* Get ideal humidity from user preferences */;
            double idealWindSpeed = city.getWeatherData().getIdealWindspeed()/* Get ideal windspeed from user preferences */;

            double actualTemperature = city.getWeatherData().temperature()/* Fetch actual temperature from weather data API */;
            double actualHumidity = city.getWeatherData().humidity() /* Fetch actual humidity from weather data API */;
            double actualPrecipitation = city.getWeatherData().windSpeed() /* Fetch actual precipitation from weather data API */;

            int userTempPreference = userPreferences.getUserTempPreference();
            int userHumidityPreference = userPreferences.getUserHumidityPreference();
            int userWindSpeedPreference = userPreferences.getUserWindSpeedPreference();

            int userTempWeight = userPreferences.getUserTempPreferenceScore();
            int userHumidityWeight = userPreferences.getUserHumidityPreferenceScore();
            int userWindSpeedWeight = userPreferences.getUserWindSpeedPreferenceScore();

            int overallScore = CalculateWeatherScore.calculateOverallWeatherScore(
                    idealTemp, idealHumidity, idealWindSpeed,
                    userTempPreference, userHumidityPreference, userWindSpeedPreference,
                    actualTemperature, actualHumidity, actualPrecipitation, userTempWeight, userHumidityWeight, userWindSpeedWeight
            );
            city.setWeatherScore(new WeatherScore(overallScore));
        }
        for (City city:currentUserCities ){
            for (City city1 : cities){
                if (city.name.equals(city1.name)){
                    city.setWeatherScore(city1.getWeatherScore());
                }
            }
        }


        //modify the in memory user after setting the new score incase the useer is to be saved
        userDataAccessObject.setCurrent_user(inMemoUser);

        //User currentUser =WeatherDataHelper.fetchAndUpdateWeatherData(userDataAccessObject.getCurr_User());
        City cityWithHighestScore = currentUserCities.get(0); // Initialize with the first city
        int highestScore = currentUserCities.get(0).getWeatherScore().weather_score; // Initialize with the score of the first city

        for (City city : currentUserCities) {
            int currentScore = city.getWeatherScore().weather_score;
            if (currentScore > highestScore) {
                highestScore = currentScore;
                cityWithHighestScore = city;
            }
        }


        if (cityWithHighestScore.getWeatherScore().weather_score >= 1 && cityWithHighestScore.getWeatherScore().weather_score <= 100) {
            CalculateScoreOutputData calculateScoreOutputData=new CalculateScoreOutputData(cityWithHighestScore.getWeatherScore().weather_score);
            calculateScorePresenter.prepareSuccessView(calculateScoreOutputData);
        }else{
            calculateScorePresenter.prepareFailView("Calculation failed , please try again!");
        }

    }
}
