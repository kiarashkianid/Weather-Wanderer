package entity;

public class WeatherData {
    private static final double MIN_WIND_SPEED = 1;
    private static final double MAX_WIND_SPEED = 20;
    private static final double MIN_HUMIDITY = 0;
    private static final double MAX_HUMIDITY = 100;
    private static final double MIN_TEMPERATURE = -40;
    private static final double MAX_TEMPERATURE = 40;

    private final double windSpeed;
    private final double humidity;
    private final double temperature;

    public WeatherData(double windSpeed, double humidity, double temperature) {
        // Validate and set wind speed within the specified range
        if (windSpeed < MIN_WIND_SPEED || windSpeed > MAX_WIND_SPEED) {
            throw new IllegalArgumentException("Wind speed out of range");
        }
        this.windSpeed = windSpeed;

        // Validate and set humidity within the specified range
        if (humidity < MIN_HUMIDITY || humidity > MAX_HUMIDITY) {
            throw new IllegalArgumentException("Humidity out of range");
        }
        this.humidity = humidity;

        // Validate and set temperature within the specified range
        if (temperature < MIN_TEMPERATURE || temperature > MAX_TEMPERATURE) {
            throw new IllegalArgumentException("Temperature out of range");
        }
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public double getTemperature() {
        return temperature;
    }
}
