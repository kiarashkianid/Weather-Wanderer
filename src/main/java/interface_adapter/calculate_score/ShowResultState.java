package interface_adapter.calculate_score;

import entity.City;
import entity.WeatherScore;
import use_case.CalculateScore.CalculateScoreOutputData;

public class ShowResultState {

    private City city;
    private WeatherScore finalScore;

    public ShowResultState(ShowResultState copy){
        city=copy.city;
        finalScore=copy.finalScore;
    }
    public void setFinalScore(CalculateScoreOutputData cityWithHighestScore) {
        this.city = cityWithHighestScore.getCity();
        this.finalScore = cityWithHighestScore.getCity().getWeatherScore();
    }

    public City getCity(){return city;}

    public WeatherScore getFinalScore(){return finalScore;}

    public void setFinalScoreError(String error) {

    }
}




