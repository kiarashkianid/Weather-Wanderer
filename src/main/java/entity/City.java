package entity;

public class City {
    public String name;
    private WeatherData weatherData;
    private WeatherScore weatherScore;

    public City(String name){
        this.name = name;
        this.weatherData=null;
        this.weatherScore=null;
    }
    public String getName() {
        return name;
    }
    public void setWeatherData(WeatherData weatherData){this.weatherData=weatherData;}

    public WeatherData getWeatherData(){return this.weatherData;}
    public void setWeatherScore(WeatherScore weatherScore){this.weatherScore=weatherScore;}

    public WeatherScore getWeatherScore(){return this.weatherScore;}
}
