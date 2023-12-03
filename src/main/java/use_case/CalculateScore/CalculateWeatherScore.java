package use_case.CalculateScore;

// Helper class to calculate the overall weather score based on user preferences and actual weather data
public class CalculateWeatherScore implements CalculateWeatherScoreAlgorithm {

    /**
     * Calculates the overall weather score based on user preferences and actual weather data.
     *
     * @param userTempPreference    The user's temperature preference.
     * @param userHumidityPreference The user's humidity preference.
     * @param userWindSpeedPreference The user's wind speed preference.
     * @param actualTemperature     The actual temperature obtained from the weather API.
     * @param actualHumidity        The actual humidity obtained from the weather API.
     * @param actualWindSpeed       The actual wind speed obtained from the weather API.
     * @param tempWeight            The weightage assigned to temperature in the overall score calculation.
     * @param humidityWeight        The weightage assigned to humidity in the overall score calculation.
     * @param windSpeedWeight       The weightage assigned to wind speed in the overall score calculation.
     * @return The calculated overall weather score.
     */
    @Override
    public  int calculateOverallWeatherScore(int userTempPreference, int userHumidityPreference, int userWindSpeedPreference,
                                                   double actualTemperature, double actualHumidity, double actualWindSpeed,
                                                   double tempWeight, double humidityWeight, double windSpeedWeight) {

        // Calculate temperature score using user preference score, ideal temp score, and the actual score from API
        int temperatureScore = (int) (100 - 100 * Math.abs(((double) userTempPreference - actualTemperature) / 40));
        temperatureScore = (int) (temperatureScore * (tempWeight / 100)); // Apply temperature weight

        // Calculate humidity score using user preference score, ideal humidity score, and the actual score from API
        int humidityScore = (int) (100 - 100 * Math.abs((((double) userHumidityPreference - actualHumidity) / 100)));
        humidityScore = (int) (humidityScore * (humidityWeight / 100)); // Apply humidity weight

        // Calculate wind speed score using user preference score, ideal wind speed score, and the actual wind speed from API
        int windSpeedScore = (int) (100 - 100 * Math.abs((((double) userWindSpeedPreference - actualWindSpeed) / 20)));
        windSpeedScore = (int) (windSpeedScore * (windSpeedWeight / 100)); // Apply wind speed weight

        // Calculate the overall weather score. Each parameter score is weighted and averaged based on their importance.
        int overallScore = (temperatureScore + humidityScore + windSpeedScore) / 3;

        // Ensure the overall score stays within the range of 0 to 100.
        return overallScore;
    }

}
