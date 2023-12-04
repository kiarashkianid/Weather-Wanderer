package CalculateScore;

import View.ResultPageView;
import data_access.InMemoryUserDataAccessObject;
import entity.City;
import entity.CommonUser;
import entity.User;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.ShowResultState;
import interface_adapter.calculate_score.ShowResultViewModel;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInteractor;
import use_case.CalculateScore.CalculateScoreOutputBoundary;
import use_case.choosepreferences.WeatherDataHelper;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CalculateScoreTest {

    // Method to perform a success test
    void successTest() {
        // Creating an instance of data access interface
        CalculateScoreDataAccessInterface calculateScoreDataAccessInterface = new InMemoryUserDataAccessObject();

        // Creating two city instances and asserting their names
        City city1 = new City("toronto,canada");
        assert Objects.equals(city1.getName(), "toronto,canada");
        City city2 = new City("vancouver,canada");
        assert city2.getName().equals("vancouver,canada");

        // Creating a list of cities and adding the cities to it
        List<City> cityList = new ArrayList<>();
        cityList.add(city1);
        cityList.add(city2);

        // Creating a WeatherPref instance and asserting its properties
        WeatherPref testWeatherPref = new WeatherPref(20, 10, 10, 50, 50, 50);
        assert testWeatherPref.getUserHumidityPreference() == 10;
        assert testWeatherPref.getUserTempPreference() == 20;
        assert testWeatherPref.getUserHumidityPreferenceScore() == 50;
        assert testWeatherPref.getUserWindSpeedPreference() == 10;
        assert testWeatherPref.getUserWindSpeedPreferenceScore() == 50;
        assert testWeatherPref.getUserTempPreferenceScore() == 50;

        // Creating a test user instance with ID, preferences, and city list, and asserting their values
        User testUser = new CommonUser(1, testWeatherPref, cityList);
        assert testUser.getUserID() == 1;
        assert testUser.getPreferences().equals(testWeatherPref);
        assert testUser.getCityList().equals(cityList);

        // Setting the current user's weather data in the data access object
        calculateScoreDataAccessInterface.setCurrent_user(WeatherDataHelper.fetchAndUpdateWeatherData(testUser));

        // Creating instances for the view manager, show result view model, and show result state
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        ShowResultViewModel showResultViewModel = new ShowResultViewModel();
        ShowResultState showResultState = showResultViewModel.getState();
        showResultViewModel.setState(showResultState);

        // Creating a success presenter instance
        CalculateScoreOutputBoundary successPresenter = new CalculateScorePresenter(viewManagerModel, showResultViewModel) {
            // Override methods might be implemented here
        };

        // Creating instances for interactor, controller, and executing the controller with user preferences and city list
        CalculateScoreInputBoundary calculateScoreInteractor = new CalculateScoreInteractor(calculateScoreDataAccessInterface, successPresenter);
        CalculateScoreController calculateScoreController = new CalculateScoreController(calculateScoreInteractor);
        calculateScoreController.execute(testUser.getPreferences(), testUser.getCityList());
        showResultViewModel.setState(showResultState);
        ResultPageView resultPageView=new ResultPageView(showResultViewModel);
        JFrame frame=new JFrame();
        resultPageView.initializeComponents(frame);
    }

    public static void main(String[] args) {
        // Creating an instance of CalculateScoreTest and executing the success test
        CalculateScoreTest scoreTest = new CalculateScoreTest();
        scoreTest.successTest();
        // For demonstration purposes, let's simulate displaying the view
        // Usually, in a Swing application, this would be handled within the application's UI framework
    }
}
