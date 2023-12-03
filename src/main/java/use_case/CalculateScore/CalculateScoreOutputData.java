package use_case.CalculateScore;

import entity.City;

// Represents the output data of the CalculateScore use case
public class CalculateScoreOutputData {

    private final City score; // City object representing the overall score

    /**
     * Constructor for CalculateScoreOutputData.
     *
     * @param overallScore The City object representing the overall score for a city.
     */
    public CalculateScoreOutputData(City overallScore) {
        this.score = overallScore;
    }

    /**
     * Retrieves the City object representing the overall score.
     *
     * @return The City object representing the overall score.
     */
    public City getCity() {
        return this.score;
    }
}
