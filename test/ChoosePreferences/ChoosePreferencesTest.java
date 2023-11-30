package ChoosePreferences;

import app.ChoosePreferencesFactory;
import data_access.InMemoryUserDataAccessObject;
import entity.City;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreState;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.choose_preferences.ChoosePresenter;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.choosepreferences.ChooseInputData;
import use_case.choosepreferences.ChooseInteractor;
import use_case.choosepreferences.ChooseOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ChoosePreferencesTest {
    // Attributes used to hold common classes that multiple tests will need.
    ChooseDataAccessInterface chooseDataAccessObject = new InMemoryUserDataAccessObject();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    ChooseViewModel chooseViewModel = new ChooseViewModel("ChoosePreferences");
    CalculateScoreViewModel calculateScoreViewModel = new CalculateScoreViewModel("ResultView");
    ChooseOutputBoundary choosePresenter = new ChoosePresenter(viewManagerModel, chooseViewModel,
            calculateScoreViewModel);
    ChoosePreferencesFactory choosePreferencesFactory = new ChoosePreferencesFactory();
    ChooseInteractor chooseInteractor = new ChooseInteractor(chooseDataAccessObject, choosePresenter,
            choosePreferencesFactory);
    @org.junit.Test // Want to test given correct inputdata, we get correct outputdata!
    public void testChooseInteractorCorrectOutput() throws IOException {


    ArrayList<String> cityList = new ArrayList<>();
    cityList.add("paris,france");
    ChooseInputData chooseInputData = new ChooseInputData(1, 1, 1,
            1, 1, 1, cityList);

    // TODO: Currently fails due to missing implementation, should work when implementation is complete.


        chooseInteractor.execute(chooseInputData);
        // Interactor executed, on success should manipulate the following data:
        // 1. calculateWeatherScoreState.setPreferences(chooseOutputData)
        // 2. ViewManagerModel should have active view "ResultView"

        // 1:
        ArrayList<City> expectedCitiesList = new ArrayList<>();
        expectedCitiesList.add(new City("paris,france"));
        CalculateScoreState calculateScoreState = calculateScoreViewModel.getState();
        ArrayList<City> obtainedCitiesList = calculateScoreState.getAddedCities();

        assert Objects.equals(obtainedCitiesList.get(0).getName(), expectedCitiesList.get(0).getName());

        assert obtainedCitiesList.get(0).getWeatherScore() != null;
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

}
