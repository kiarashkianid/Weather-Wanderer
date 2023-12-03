package app;

import View.ChoosePreferencesView;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.calculate_score.ShowResultViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChoosePresenter;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInteractor;
import use_case.CalculateScore.CalculateScoreOutputBoundary;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.choosepreferences.ChooseInputBoundary;
import use_case.choosepreferences.ChooseInteractor;
import use_case.choosepreferences.ChooseOutputBoundary;

public class ChoosePreferencesFactory {

    public static ViewManagerModel viewManagerModel;

    public ChoosePreferencesFactory(){}



    public static ChoosePreferencesView create (ChooseController chooseController, ChooseViewModel chooseViewModel, CalculateScoreController calculateScoreController, CalculateScoreViewModel calculateScoreViewModel)
    {

        return new ChoosePreferencesView(chooseController,chooseViewModel, calculateScoreController, calculateScoreViewModel);
    }

    public static ChooseController createUserSignUpUseCase (ViewManagerModel viewManagerModel, ChooseViewModel chooseViewModel, CalculateScoreViewModel calculateWeatherScoreViewModel, ChooseDataAccessInterface userDataAccessObject)
    {
        ChooseOutputBoundary chooseOutputBoundary = new ChoosePresenter(viewManagerModel, chooseViewModel,
                calculateWeatherScoreViewModel);
        ChoosePreferencesFactory userFactory = new ChoosePreferencesFactory();
        ChooseInputBoundary userChooseInteractor = new ChooseInteractor(userDataAccessObject, chooseOutputBoundary);
        return new ChooseController(userChooseInteractor);

    }

    public static CalculateScoreController createSignUpUseCase(ViewManagerModel viewManagerModel,
                                                               CalculateScoreViewModel calculateScoreViewModel,
                                                               ShowResultViewModel showResultViewModel, CalculateScoreDataAccessInterface userDataAccessObject)
    {
        CalculateScoreOutputBoundary calculateScoreOutputBoundary = new CalculateScorePresenter(viewManagerModel, showResultViewModel);
        CalculateScoreInputBoundary userCalculateInteractor = new CalculateScoreInteractor(userDataAccessObject, calculateScoreOutputBoundary);
        return new CalculateScoreController(userCalculateInteractor);


    }

}
