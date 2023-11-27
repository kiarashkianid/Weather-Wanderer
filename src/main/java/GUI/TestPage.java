package GUI;

import View.ChoosePreferencesView;
import View.GuestUserView;
import app.ChoosePreferencesFactory;
import data_access.FileUserDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import entity.CommonUserFactory;
import entity.NormalUser;
import entity.User;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.calculate_score.ShowResultViewModel;
import interface_adapter.calculateweatherscore.CalculateWeatherScoreViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChoosePresenter;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.CalculateScore.CalculateScoreInteractor;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.choosepreferences.ChooseInputBoundary;
import use_case.choosepreferences.ChooseInteractor;
import use_case.choosepreferences.ChooseOutputBoundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class TestPage {

    public static void main(String[] args) {
        // List<String> cityList1 = new ArrayList<String>();
        // cityList1.add("paris,france");

        User normalUser = new NormalUser(2, "TestUser", "TestPassword",null, null);

        ChooseDataAccessInterface chooseDataAccessObject = new FileUserDataAccessObject(new CommonUserFactory());
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ChooseViewModel chooseViewModel = new ChooseViewModel("chooseView");
        CalculateScoreViewModel calculateWeatherScoreViewModel = new CalculateScoreViewModel("calculateWeatherScoreView");
        ChooseOutputBoundary choosePresenter = new ChoosePresenter(viewManagerModel, chooseViewModel, calculateWeatherScoreViewModel);
        ChoosePreferencesFactory choosePreferencesFactory = new ChoosePreferencesFactory();
        ChooseInputBoundary chooseInteractor = new ChooseInteractor(chooseDataAccessObject, choosePresenter, choosePreferencesFactory);
        ChooseController chooseController = new ChooseController(chooseInteractor);
        ShowResultViewModel showResultViewModel = new ShowResultViewModel();
        CalculateScorePresenter calculateScorePresenter = new CalculateScorePresenter(viewManagerModel, calculateWeatherScoreViewModel, showResultViewModel);
        CalculateScoreDataAccessInterface calculateDAO = new InMemoryUserDataAccessObject();
        CalculateScoreInteractor calculateScoreInteractor = new CalculateScoreInteractor(calculateDAO, calculateScorePresenter);
        CalculateScoreController CalculateScoreController = new CalculateScoreController(calculateScoreInteractor);
        ChoosePreferencesView choosePreferencesView = new ChoosePreferencesView(chooseController, chooseViewModel, CalculateScoreController, CalculateScoreViewModel);

        chooseDataAccessObject.setCurr_User(normalUser);

        new ChoosePreferencesView(chooseController, chooseViewModel); // Create and show the GuestPage


    }
}
