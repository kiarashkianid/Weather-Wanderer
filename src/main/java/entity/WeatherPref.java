package entity;

public class WeatherPref {
    private static final int MIN_TEMP_PREFERENCE = -40;
    private static final int MAX_TEMP_PREFERENCE = 40;
    private static final int MIN_HUMIDITY_PREFERENCE = 0;
    private static final int MAX_HUMIDITY_PREFERENCE = 100;
    private static final int MIN_WIND_SPEED_PREFERENCE = 1;
    private static final int MAX_WIND_SPEED_PREFERENCE = 20;

    private int userTempPreference;

    public int getUserTempPreference() {
        return userTempPreference;
    }

    public void setUserTempPreference(int userTempPreference) {
        this.userTempPreference = userTempPreference;
    }

    private int userHumidityPreference;

    public int getUserHumidityPreference() {
        return userHumidityPreference;
    }

    public void setUserHumidityPreference(int userHumidityPreference) {
        this.userHumidityPreference = userHumidityPreference;
    }

    private int userWindSpeedPreference;

    public int getUserWindSpeedPreference() {
        return userWindSpeedPreference;
    }

    public void setUserWindSpeedPreference(int userWindSpeedPreference) {
        this.userWindSpeedPreference = userWindSpeedPreference;
    }

    private int userTempPreferenceScore;

    public int getUserTempPreferenceScore() {
        return userTempPreferenceScore;
    }

    public void setUserTempPreferenceScore(int userTempPreferenceScore) {
        this.userTempPreferenceScore = userTempPreferenceScore;
    }

    private int userHumidityPreferenceScore;

    public int getUserHumidityPreferenceScore() {
        return userHumidityPreferenceScore;
    }

    public void setUserHumidityPreferenceScore(int userHumidityPreferenceScore) {
        this.userHumidityPreferenceScore = userHumidityPreferenceScore;
    }

    private int userWindSpeedPreferenceScore;

    public int getUserWindSpeedPreferenceScore() {
        return userWindSpeedPreferenceScore;
    }

    public void setUserWindSpeedPreferenceScore(int userWindSpeedPreferenceScore) {
        this.userWindSpeedPreferenceScore = userWindSpeedPreferenceScore;
    }

    public WeatherPref(int userTempPreference, int userHumidityPreference, int userWindSpeedPreference,
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
}
