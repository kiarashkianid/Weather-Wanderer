package interface_adapter.choose_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreState;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import use_case.choosepreferences.ChooseOutputBoundary;
import use_case.choosepreferences.ChooseOutputData;

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
    public void prepareSuccessView(ChooseOutputData chooseOutputData) {
        // On success, switch to CalculateWeatherScoreView
        // Take outputdata & sets State's attributes, which hold this 'in-limbo' information.
        CalculateScoreState calculateWeatherScoreState = calculateWeatherScoreViewModel.getState();
        calculateWeatherScoreState.setPreferences(chooseOutputData);
        this.calculateWeatherScoreViewModel.setState(calculateWeatherScoreState);
        calculateWeatherScoreViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(calculateWeatherScoreViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ChooseState chooseState = chooseViewModel.getState();
        chooseState.setPreferencesError(error);
        chooseViewModel.firePropertyChanged();
    }
}
