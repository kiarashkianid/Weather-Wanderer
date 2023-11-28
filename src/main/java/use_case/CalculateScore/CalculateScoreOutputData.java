package use_case.CalculateScore;

import entity.City;

public class CalculateScoreOutputData {
    private final City score;
    public CalculateScoreOutputData(City overallScore) {
        this.score=overallScore;

}

    public City getCity() {return this.score;
    }
}

