package use_case.choosepreferences;

import api.OpenWeatherAPI;
import entity.City;
import entity.User;
import entity.WeatherData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeatherDataHelper {

    // Method to fetch weather data for cities and update the user's city list
    public User fetchAndUpdateWeatherData(User user) {
        OpenWeatherAPI openWeatherAPI = new OpenWeatherAPI();

        // Get the user's city list without weather data
        List<City> cities = user.getCityList();

        // Extract city names from the list
        ArrayList<String> cityNames = new ArrayList<>();
        for (City city : cities) {
            cityNames.add(city.getName());
        }

        // Call OpenWeatherAPI to get weather data for each city
        HashMap<String, HashMap> weatherDataMap = openWeatherAPI.getData(cityNames);

        // Update the city list in the user object with weather data
        for (City city : cities) {
            HashMap<String, Double> weatherInfo = weatherDataMap.get(city.getName());

            // Create WeatherData object from retrieved API data
            WeatherData weatherData = new WeatherData(
                    weatherInfo.get("WindSpeed"),
                    weatherInfo.get("Humidity"),
                    weatherInfo.get("Temperature")
            );

            // Update the City object with WeatherData
            city.setWeatherData(weatherData);
        }

        // Update the user's city list
        user.setCityList(cities);

        return user;
    }
}
