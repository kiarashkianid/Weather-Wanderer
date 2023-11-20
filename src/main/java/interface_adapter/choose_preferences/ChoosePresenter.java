package interface_adapter.choose_preferences;

import interface_adapter.ViewManagerModel;
import use_case.calculateweatherscore.CalculateWeatherScore;
import use_case.choosepreferences.ChooseOutputBoundary;
import use_case.choosepreferences.ChooseOutputData;

public class ChoosePresenter implements ChooseOutputBoundary{
    private final ViewManagerModel viewManagerModel;

    private final ChooseViewModel chooseViewModel;

    private final CalculateWeatherScoreViewModel calculateWeatherScoreViewModel;

    public ChoosePresenter(ViewManagerModel viewManagerModel, ChooseViewModel chooseViewModel,
                           CalculateWeatherScoreViewModel calculateWeatherScoreViewModel){
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
