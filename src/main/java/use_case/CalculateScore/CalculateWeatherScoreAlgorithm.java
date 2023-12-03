// Interface for implementing the Strategy Design Pattern
package use_case.CalculateScore;

// Interface defining the strategy for calculating weather score
public interface CalculateWeatherScoreAlgorithm {
    // Method to calculate the overall weather score based on preferences and actual weather conditions
    // Parameters:
    // - userTempPreference: User's temperature preference
    // - userHumidityPreference: User's humidity preference
    // - userWindSpeedPreference: User's wind speed preference
    // - actualTemperature: Actual temperature
    // - actualHumidity: Actual humidity
    // - actualWindSpeed: Actual wind speed
    // - tempWeight: Weight for temperature in the calculation
    // - humidityWeight: Weight for humidity in the calculation
    // - windSpeedWeight: Weight for wind speed in the calculation
    // Returns: Calculated overall weather score
    int calculateOverallWeatherScore(int userTempPreference, int userHumidityPreference, int userWindSpeedPreference,
                                     double actualTemperature, double actualHumidity, double actualWindSpeed,
                                     double tempWeight, double humidityWeight, double windSpeedWeight);
}
