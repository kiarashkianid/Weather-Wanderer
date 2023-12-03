package use_case.CalculateScore;

// Represents the InputBoundary for the CalculateScore use case
public interface CalculateScoreInputBoundary {

    /**
     * Executes the CalculateScore use case based on the input data.
     *
     * @param inputData The CalculateScoreInputData containing necessary input data.
     */
    void execute(CalculateScoreInputData inputData);
}
