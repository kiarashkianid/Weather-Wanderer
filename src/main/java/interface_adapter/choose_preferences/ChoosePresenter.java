package interface_adapter.choose_preferences;

import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.ShowResultState;
import interface_adapter.calculate_score.ShowResultViewModel;
import use_case.choosepreferences.ChooseOutputBoundary;
import use_case.choosepreferences.ChooseOutputData;

public class ChoosePresenter implements ChooseOutputBoundary{
    private final ViewManagerModel viewManagerModel;

    private final ChooseViewModel chooseViewModel;

    private final ShowResultViewModel showResultViewModel;

    public ChoosePresenter(ViewManagerModel viewManagerModel, ChooseViewModel chooseViewModel,
                           ShowResultViewModel showResultViewModel){
        this.viewManagerModel = viewManagerModel;
        this.chooseViewModel = chooseViewModel;
        this.showResultViewModel = showResultViewModel;
    }

    @Override
    public void prepareSuccessView(ChooseOutputData chooseOutputData) {
        // On success, switch to ShowResultView, update chooseState for CalculateScore's Use Case
        // Take outputdata & sets State's attributes, which hold this 'in-limbo' information.
        ChooseState chooseState = chooseViewModel.getState();
        chooseState.setAddedCities(chooseOutputData.getCityList());

        viewManagerModel.setActiveView(showResultViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ChooseState chooseState = chooseViewModel.getState();
        chooseState.setPreferencesError(error);
        chooseViewModel.firePropertyChanged();
    }
}
