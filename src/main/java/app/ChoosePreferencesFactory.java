package app;

import View.ChoosePreferencesView;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
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



    public static ChoosePreferencesView create (ChooseController chooseController, ChooseViewModel chooseViewModel, CalculateScoreController calculateScoreController)
    {

        return new ChoosePreferencesView(chooseController,chooseViewModel, calculateScoreController);
    }

    public static ChooseController createUserSignUpUseCase (ViewManagerModel viewManagerModel, ChooseViewModel chooseViewModel, ShowResultViewModel showResultViewModel, ChooseDataAccessInterface userDataAccessObject)
    {
        ChooseOutputBoundary chooseOutputBoundary = new ChoosePresenter(viewManagerModel, chooseViewModel,
                showResultViewModel);
        ChoosePreferencesFactory userFactory = new ChoosePreferencesFactory();
        ChooseInputBoundary userChooseInteractor = new ChooseInteractor(userDataAccessObject, chooseOutputBoundary);
        return new ChooseController(userChooseInteractor);

    }

    public static CalculateScoreController createSignUpUseCase(ViewManagerModel viewManagerModel,
                                                               ShowResultViewModel showResultViewModel,
                                                               CalculateScoreDataAccessInterface userDataAccessObject)
    {
        CalculateScoreOutputBoundary calculateScoreOutputBoundary = new CalculateScorePresenter(viewManagerModel, showResultViewModel);
        CalculateScoreInputBoundary userCalculateInteractor = new CalculateScoreInteractor(userDataAccessObject, calculateScoreOutputBoundary);
        return new CalculateScoreController(userCalculateInteractor);


    }

}
