package interface_adapter.choose_preferences;

import interface_adapter.ViewManagerModel;
import use_case.CalculateScore.CalculateWeatherScore;
import use_case.choosepreferences.ChooseOutputBoundary;
import use_case.choosepreferences.ChooseOutputData;
import interface_adapter.calculate_score.CalculateScoreViewModel;

public class ChoosePresenter implements ChooseOutputBoundary{
    private final ViewManagerModel viewManagerModel;

    private final ChooseViewModel chooseViewModel;

    private final CalculateScoreViewModel calculateWeatherScoreViewModel;

    public ChoosePresenter(ViewManagerModel viewManagerModel, ChooseViewModel chooseViewModel,
                           CalculateScoreViewModel calculateWeatherScoreViewModel){
        this.viewManagerModel = viewManagerModel;
        this.chooseViewModel = chooseViewModel;
        this.calculateWeatherScoreViewModel = calculateWeatherScoreViewModel;
    }

    @Override
    public void prepareSuccessView(ChooseOutputData preferences) {
        // On success, switch to CalculateWeatherScoreView

        // Take outputdata & sets State's attributes, which hold this 'in-limbo' information.
    }

    @Override
    public void prepareFailView(String error) {

    }
}
