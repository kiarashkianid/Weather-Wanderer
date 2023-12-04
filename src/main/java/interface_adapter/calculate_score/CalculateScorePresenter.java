package interface_adapter.calculate_score;

import View.ResultPageView;
import interface_adapter.ViewManagerModel;
import use_case.CalculateScore.CalculateScoreOutputBoundary;
import use_case.CalculateScore.CalculateScoreOutputData;

import javax.swing.*;

// Presenter class responsible for preparing views related to CalculateScore
public class CalculateScorePresenter implements CalculateScoreOutputBoundary {

    private final ShowResultViewModel showResultViewModel; // ViewModel for the ShowResult view
    private ViewManagerModel viewManagerModel; // Model to manage views

    // Constructor to initialize the CalculateScorePresenter
    public CalculateScorePresenter(ViewManagerModel viewManagerModel,
                                   ShowResultViewModel showResultViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.showResultViewModel = showResultViewModel;
    }

    // Method to prepare view on successful score calculation
    @Override
    public void prepareSuccessView(CalculateScoreOutputData cityWithHighestScore) {
        // Retrieve the state from the ShowResultViewModel
        ShowResultState resultState = showResultViewModel.getState();

        // Set the final score attribute in the ShowResultState using the CalculateScoreOutputData
        resultState.setFinalScore(cityWithHighestScore);

        // Update the state in the ShowResultViewModel
        this.showResultViewModel.setState(resultState);
        // Trigger property change notification for potential view updates
        showResultViewModel.firePropertyChanged();

        // Set the active view to showResult view in the ViewManagerModel
        viewManagerModel.setActiveView(showResultViewModel.getViewName());
        // Trigger property change notification for potential view updates
        viewManagerModel.firePropertyChanged();
        ResultPageView resultPageView = new ResultPageView(showResultViewModel);
        JFrame jFrame = new JFrame();
        resultPageView.initializeComponents(jFrame);
    }

    // Method to prepare view on failed score calculation
    @Override
    public void prepareFailView(String error) {
        // Retrieve the state from the ShowResultViewModel
        ShowResultState calculateScoreState = showResultViewModel.getState();

        // Set the final score error message in the state
        calculateScoreState.setFinalScoreError(error);

        // Trigger property change notification for potential view updates
        showResultViewModel.firePropertyChanged();
    }
}
