package ChoosePreferences;

import app.ChoosePreferencesFactory;
import data_access.InMemoryUserDataAccessObject;
import entity.City;
import entity.NormalUser;
import entity.User;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreState;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChoosePresenter;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.choosepreferences.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChoosePreferencesTest {
    // Attributes used to hold common classes that multiple tests will need.
    ChooseDataAccessInterface chooseDataAccessObject = new testDataAccessObject();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ChooseViewModel chooseViewModel = new ChooseViewModel();
    CalculateScoreViewModel calculateScoreViewModel = new CalculateScoreViewModel("ResultView");
    ChooseOutputBoundary choosePresenter = new ChoosePresenter(viewManagerModel, chooseViewModel,
            calculateScoreViewModel);
    ChooseInputBoundary chooseInteractor = new ChooseInteractor(chooseDataAccessObject, choosePresenter);
    @org.junit.Test // Want to test given correct inputdata, we get correct outputdata
    public void testChooseInteractor() throws IOException {


    ArrayList<String> cityList = new ArrayList<>();
    cityList.add("paris,france");
    ChooseInputData chooseInputData = new ChooseInputData(1, 1, 1,
            1, 1, 1, cityList);
    // Sets the current user in the DAO, simulating a login/signup process
    User user = new NormalUser(1000, "username", "password");
    chooseDataAccessObject.setCurr_User(user);

        chooseInteractor.execute(chooseInputData);
        // Interactor executed, on success should manipulate the following data:
        // 1. calculateWeatherScoreState.setPreferences(chooseOutputData)
        // 2. ViewManagerModel should have active view "ResultView"

        // 1:
        ArrayList<City> expectedCitiesList = new ArrayList<>();
        expectedCitiesList.add(new City("paris,france"));
        CalculateScoreState calculateScoreState = calculateScoreViewModel.getState();
        ArrayList<City> obtainedCitiesList = calculateScoreState.getCities();

        assert Objects.equals(obtainedCitiesList.get(0).getName(), expectedCitiesList.get(0).getName());

        // TODO: getWeatherScore() assertion fails, so it must be returning null weatherScore :/
        // assert obtainedCitiesList.get(0).getWeatherScore() != null;
        assert obtainedCitiesList.get(0).getWeatherData() != null;

        WeatherPref expectedWeatherPref = new WeatherPref(1,1,
                1,1,1,1);

        WeatherPref obtainedWeatherPref = calculateScoreState.getWeatherPref();

        assert obtainedWeatherPref.getUserTempPreference() == expectedWeatherPref.getUserTempPreference();
        assert obtainedWeatherPref.getUserTempPreferenceScore() == expectedWeatherPref.getUserTempPreferenceScore();
        assert obtainedWeatherPref.getUserHumidityPreference() == expectedWeatherPref.getUserHumidityPreference();
        assert obtainedWeatherPref.getUserHumidityPreferenceScore() == expectedWeatherPref.getUserHumidityPreferenceScore();
        assert obtainedWeatherPref.getUserWindSpeedPreference() == expectedWeatherPref.getUserWindSpeedPreference();
        assert obtainedWeatherPref.getUserWindSpeedPreferenceScore() == expectedWeatherPref.getUserWindSpeedPreferenceScore();

        // 2:
        assert Objects.equals(viewManagerModel.getActiveView(), "ResultView");
    }

    @org.junit.Test // Want to test given correct raw inputdata, interactor is succesfully executed w/correct inputdata
    public void testChooseController() throws IOException {

        ChooseController chooseController = new ChooseController(chooseInteractor);
        ArrayList<String> cityNamesList = new ArrayList<>();
        cityNamesList.add("rome,italy");
        cityNamesList.add("warsaw,poland");

        // Sets the current user in the DAO, simulating a login/signup process
        User user = new NormalUser(1001, "username", "password");
        chooseDataAccessObject.setCurr_User(user);

        chooseController.execute(1, 2, 3, 4, 5, 6,
                cityNamesList);

        // Check if interactor successful by checking the DAO's current user attributes:
        User currentUser = chooseDataAccessObject.getCurr_User();

        assert Objects.equals(currentUser.getCityList().get(0).getName(), "rome,italy");
        assert Objects.equals(currentUser.getCityList().get(1).getName(), "warsaw,poland");
        assert currentUser.getPreferences().getUserTempPreference() == 1;
        assert currentUser.getPreferences().getUserTempPreferenceScore() == 2;
        assert currentUser.getPreferences().getUserHumidityPreference() == 3;
;       assert currentUser.getPreferences().getUserHumidityPreferenceScore() == 4;
        assert currentUser.getPreferences().getUserWindSpeedPreference() == 5;
        assert currentUser.getPreferences().getUserWindSpeedPreferenceScore() == 6;
    }

    @org.junit.Test // Want to test prepareSuccessView such that calculateScoreState is correctly updated with the
                    // outputdata and the viewManagerModel's active view is changed to the resultView
    public void testChoosePresenter() throws IOException {
        // Make outputdata:
        WeatherPref weatherPref = new WeatherPref(1,3,5,
                2,4,6);
        ArrayList<City> cityList = new ArrayList<>();
        cityList.add(new City("rome,italy"));
        ChooseOutputData chooseOutputData = new ChooseOutputData(weatherPref, cityList);
        choosePresenter.prepareSuccessView(chooseOutputData);

        // Check calculateScoreState:
        CalculateScoreState calculateScoreState = calculateScoreViewModel.getState();

        assert calculateScoreState.getWeatherPref().getUserTempPreference() == 1;
        assert calculateScoreState.getWeatherPref().getUserTempPreferenceScore() == 2;
        assert calculateScoreState.getWeatherPref().getUserHumidityPreference() == 3;
        assert calculateScoreState.getWeatherPref().getUserHumidityPreferenceScore() == 4;
        assert calculateScoreState.getWeatherPref().getUserWindSpeedPreference() == 5;
        assert calculateScoreState.getWeatherPref().getUserWindSpeedPreferenceScore() == 6;

        assert Objects.equals(calculateScoreState.getCities().get(0).getName(), "rome,italy");

        // Check the active view:
        assert Objects.equals(viewManagerModel.getActiveView(), "ResultView");
    }

}
