package GUI;

import View.ChoosePreferencesView;
import app.ChoosePreferencesFactory;
import data_access.InMemoryUserDataAccessObject;
import entity.NormalUser;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.ShowResultViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChoosePresenter;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.CalculateScore.CalculateScoreInteractor;
import use_case.choosepreferences.ChooseInputBoundary;
import use_case.choosepreferences.ChooseInteractor;
import use_case.choosepreferences.ChooseOutputBoundary;


public class TestPage {

    public static void main(String[] args) {
        // List<String> cityList1 = new ArrayList<String>();
        // cityList1.add("paris,france");

        User normalUser = new NormalUser(1, "TestUser", "TestPassword",null, null);

        InMemoryUserDataAccessObject chooseDataAccessObject = new InMemoryUserDataAccessObject();
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ChooseViewModel chooseViewModel = new ChooseViewModel();
        ShowResultViewModel showResultViewModel = new ShowResultViewModel();
        ChooseOutputBoundary choosePresenter = new ChoosePresenter(viewManagerModel, chooseViewModel, showResultViewModel);

        ChooseInputBoundary chooseInteractor = new ChooseInteractor(chooseDataAccessObject, choosePresenter);
        ChooseController chooseController = new ChooseController(chooseInteractor);
        CalculateScorePresenter calculateScorePresenter = new CalculateScorePresenter(viewManagerModel, showResultViewModel);
        CalculateScoreInteractor calculateScoreInteractor = new CalculateScoreInteractor(chooseDataAccessObject, calculateScorePresenter);
        CalculateScoreController calculateScoreController = new CalculateScoreController(calculateScoreInteractor);

        chooseDataAccessObject.setCurr_User(normalUser);

        ChoosePreferencesView choosePreferencesView = new ChoosePreferencesView(chooseController, chooseViewModel, calculateScoreController);

    }
}