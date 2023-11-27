package use_case.CalculateScore;

public class CalculateWeatherScore {


    public static int calculateOverallWeatherScore(double ideal_temp, double ideal_humidity, double ideal_windSpeed,
                                                    int userTempPreference, int userHumidityPreference, int userWindSpeedPreference,
                                                    double actualTemperature, double actualHumidity, double actualWindSpeed,
                                                    double tempWeight, double humidityWeight, double windSpeedWeight) {

        // Calculate temperature score using user preference score, ideal temp score, and the actual score from API
        int temperatureScore = (int) (100 - Math.abs((((double) userTempPreference / 100) * actualTemperature) - ideal_temp));
        temperatureScore = (int) (temperatureScore * tempWeight); // Apply temperature weight

        // Calculate humidity score using user preference score, ideal humidity score, and the actual score from API
        int humidityScore = (int) (100 - Math.abs((((double) userHumidityPreference / 100) * actualHumidity) - ideal_humidity));
        humidityScore = (int) (humidityScore * humidityWeight); // Apply humidity weight

        // Calculate wind speed score using user preference score, ideal wind speed score, and the actual wind speed from API
        int windSpeedScore = (int) (100 - Math.abs((((double) userWindSpeedPreference / 100) * actualWindSpeed) - ideal_windSpeed));
        windSpeedScore = (int) (windSpeedScore * windSpeedWeight); // Apply wind speed weight

        // Calculate the overall weather score. Each parameter score is weighted and averaged based on their importance.
        int overallScore = (temperatureScore + humidityScore + windSpeedScore) / 3;

        // Ensure the overall score stays within the range of 0 to 100.
        overallScore = Math.max(0, Math.min(100, overallScore));

        return overallScore;
    }

}