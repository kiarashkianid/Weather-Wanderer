package use_case.CalculateScore;

public class CalculateWeatherScore {


    public static int calculateOverallWeatherScore(int ideal_temp, int ideal_humidity,int ideal_precipitation,int userTempPreference, int userHumidityPreference, int userPrecipitationPreference, double actualTemperature, double actualHumidity, double actualPrecipitation) {

        // Calculate temperature score using user preference score , ideal temp score and the actual score from API
        int temperatureScore = (int) (100 - Math.abs((((double) userTempPreference /100)*actualTemperature)-ideal_temp));

        // Calculate humidity score using user preference score , ideal humidity score and the actual score from API
        int humidityScore = (int) (100 - Math.abs((((double) userHumidityPreference /100)*actualHumidity)-ideal_humidity));

        // Calculate precipitation score using user preference score , ideal precipitation score , ideal precipitation score and the actual precipitation from API
        int precipitationScore = (int) (100 - Math.abs((((double) userPrecipitationPreference /100)*actualPrecipitation)-ideal_precipitation));

        // Calculate the overall weather score. should be between 0-100 as each of the 3 variables can be between 1-100 given the weights from the user
        int overallScore = (temperatureScore + humidityScore + precipitationScore) / 3;

        // Ensure the overall score stays within the range of 0 to 100.
        overallScore = Math.max(0, Math.min(100, overallScore));

        return overallScore;
    }
}