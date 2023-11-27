package use_case.CalculateScore;

public interface CalculateScoreOutputBoundary {
    void prepareSuccessView(CalculateScoreOutputData score);

    void prepareFailView(String error);
}
