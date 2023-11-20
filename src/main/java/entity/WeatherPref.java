package entity;

public class WeatherPref {

    private static final int MIN_TEMP_PREFERENCE = -40;
    private static final int MAX_TEMP_PREFERENCE = 40;
    private static final int MIN_HUMIDITY_PREFERENCE = 0;
    private static final int MAX_HUMIDITY_PREFERENCE = 100;
    private static final int MIN_WIND_SPEED_PREFERENCE = 1;
    private static final int MAX_WIND_SPEED_PREFERENCE = 20;

    private final int userTempPreference;
    private final int userHumidityPreference;
    private final int userWindSpeedPreference;
    private final int userTempPreferenceScore;
    private final int userHumidityPreferenceScore;
    private final int userWindSpeedPreferenceScore;

    public WeatherPref(int userHumidityPreference, int userTempPreference, int userWindSpeedPreference,
                       int userTempPreferenceScore, int userHumidityPreferenceScore, int userWindSpeedPreferenceScore) {

        // Validate and set temperature preference within the specified range
        if (userTempPreference < MIN_TEMP_PREFERENCE || userTempPreference > MAX_TEMP_PREFERENCE) {
            throw new IllegalArgumentException("Temperature preference out of range");
        }
        this.userTempPreference = userTempPreference;

        // Validate and set humidity preference within the specified range
        if (userHumidityPreference < MIN_HUMIDITY_PREFERENCE || userHumidityPreference > MAX_HUMIDITY_PREFERENCE) {
            throw new IllegalArgumentException("Humidity preference out of range");
        }
        this.userHumidityPreference = userHumidityPreference;

        // Validate and set wind speed preference within the specified range
        if (userWindSpeedPreference < MIN_WIND_SPEED_PREFERENCE || userWindSpeedPreference > MAX_WIND_SPEED_PREFERENCE) {
            throw new IllegalArgumentException("Wind speed preference out of range");
        }
        this.userWindSpeedPreference = userWindSpeedPreference;

        this.userHumidityPreferenceScore = userHumidityPreferenceScore;
        this.userWindSpeedPreferenceScore = userWindSpeedPreferenceScore;
        this.userTempPreferenceScore = userTempPreferenceScore;
    }

    public int getUserTempPreference() {
        return this.userTempPreference;
    }

    public int getUserHumidityPreference() {
        return this.userHumidityPreference;
    }

    public int getUserWindSpeedPreference(){
        return this.userWindSpeedPreference;
    }

    public int getUserTempPreferenceScore(){return this.userTempPreferenceScore;}
    public int getUserHumidityPreferenceScore(){return this.userHumidityPreferenceScore;}

    public int getUserWindSpeedPreferenceScore(){return this.userWindSpeedPreferenceScore;}


}
