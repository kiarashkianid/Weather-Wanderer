package interface_adapter.calculate_score;

import interface_adapter.ViewManagerModel;
import use_case.CalculateScore.CalculateScoreOutputBoundary;
import use_case.CalculateScore.CalculateScoreOutputData;

//TODO not complete yet along with state
public class CalculateScorePresenter implements CalculateScoreOutputBoundary {

    private final CalculateScoreViewModel calculateScoreViewModel;

    private final ShowResultViewModel showResultViewModel;
    private ViewManagerModel viewManagerModel;

    public CalculateScorePresenter (ViewManagerModel viewManagerModel,
                                    CalculateScoreViewModel calculateScoreViewModel,
                                    ShowResultViewModel showResultViewModel) {
        this.viewManagerModel=viewManagerModel;
        this.calculateScoreViewModel=calculateScoreViewModel;
        this.showResultViewModel=showResultViewModel;
    }

    @Override
    public void prepareSuccessView(CalculateScoreOutputData score) {
        //On success, switch to showResult view , take the outputdata and set states attribute
        ShowResultState resultState = showResultViewModel.getState();
        resultState.setFinalScore(score);
        this.showResultViewModel.setState(resultState);
        showResultViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(showResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        CalculateScoreState calculateScoreState=CalculateScoreViewModel.getState();
        calculateScoreState.setFinalScoreError(error);
        calculateScoreViewModel.firePropertyChanged();

    }
}