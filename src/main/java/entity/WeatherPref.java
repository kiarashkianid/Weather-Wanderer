package entity;

public class WeatherPref {
    private int userTempPreference;
    private int userHumidityPreference;
    private int userPrecipitationPreference;
    private int userTempPreferenceScore;
    private int userHumidityPreferenceScore;
    private int userPrecipitationPreferenceScore;

    public WeatherPref(int userTempPreference, int userHumidityPreference, int userPrecipitationPreference, int userTempPreferenceScore, int userHumidityPreferenceScore, int userPrecipitationPreferenceScore)
    {
        this.userTempPreference = userTempPreference;
        this.userHumidityPreference = userHumidityPreference;
        this.userPrecipitationPreference = userPrecipitationPreference;
        this.userTempPreferenceScore = userTempPreferenceScore;
        this.userHumidityPreferenceScore = userHumidityPreferenceScore;
        this.userPrecipitationPreferenceScore = userPrecipitationPreferenceScore;
    }
}
