package use_case.CalculateScore;

// Defines the output boundary for the CalculateScore use case
public interface CalculateScoreOutputBoundary {

    /**
     * Prepares the success view based on the CalculateScoreOutputData.
     *
     * @param score The CalculateScoreOutputData representing the output data on successful calculation.
     */
    void prepareSuccessView(CalculateScoreOutputData score);

    /**
     * Prepares the failure view and handles error messages.
     *
     * @param error The error message to be handled in case of a failure.
     */
    void prepareFailView(String error);
}
