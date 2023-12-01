package use_case.CalculateScore;

public class CalculateWeatherScore {


    public static int calculateOverallWeatherScore(int userTempPreference, int userHumidityPreference, int userWindSpeedPreference,
                                                    double actualTemperature, double actualHumidity, double actualWindSpeed,
                                                    double tempWeight, double humidityWeight, double windSpeedWeight) {

        // Calculate temperature score using user preference score, ideal temp score, and the actual score from API
        int temperatureScore = (int) (100-100*Math.abs(((double) userTempPreference-actualTemperature)/40));
        temperatureScore = (int) (temperatureScore * (tempWeight/100)); // Apply temperature weight

        // Calculate humidity score using user preference score, ideal humidity score, and the actual score from API
        //TODO : currently when the actual humidity is greater than userHumiditiy preference the scores get all over the 100
        int humidityScore = (int) (100-100*Math.abs((((double) userHumidityPreference-actualHumidity)/100)));
        humidityScore = (int) (humidityScore * (humidityWeight/100)); // Apply humidity weight

        // Calculate wind speed score using user preference score, ideal wind speed score, and the actual wind speed from API
        int windSpeedScore = (int) (100-100*Math.abs((((double) userWindSpeedPreference-actualWindSpeed)/20)));
        windSpeedScore = (int) (windSpeedScore * (windSpeedWeight/100)); // Apply wind speed weight

        // Calculate the overall weather score. Each parameter score is weighted and averaged based on their importance.
        int overallScore = (temperatureScore + humidityScore + windSpeedScore) / 3;

        // Ensure the overall score stays within the range of 0 to 100.
        return overallScore;
    }

}