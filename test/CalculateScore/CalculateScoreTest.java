package CalculateScore;

import data_access.InMemoryUserDataAccessObject;
import entity.City;
import entity.GuestUser;
import entity.User;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.calculate_score.ShowResultViewModel;
import use_case.CalculateScore.*;

import java.util.ArrayList;
import java.util.List;

public class CalculateScoreTest {
    void successTest(){
        CalculateScoreDataAccessInterface calculateScoreDataAccessInterface=new InMemoryUserDataAccessObject();

        City city1=new City("toronto");
        City city2=new City("london");
        List<City> cityList=new ArrayList<City>();
        cityList.add(city1);
        cityList.add(city2);
        User testUser=new GuestUser(new WeatherPref(20,10,10,50,50,50),cityList);
        calculateScoreDataAccessInterface.setCurrent_user(WeatherDataHelper.fetchAndUpdateWeatherData(testUser));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        CalculateScoreViewModel calculateScoreViewModel = new CalculateScoreViewModel("calculateScore");
        ShowResultViewModel showResultViewModel=new ShowResultViewModel("showResult");

        CalculateScoreOutputBoundary successPresenter = new CalculateScorePresenter(viewManagerModel,calculateScoreViewModel,showResultViewModel) {

            @Override
            public void prepareSuccessView(CalculateScoreOutputData score) {
                List<City> cities =testUser.getCityList();
                assert cities.get(0).getWeatherScore() == null;
                assert cities.get(1).getWeatherScore() == null;
                assert testUser.getCityList().equals(cityList);
            }

            @Override
            public void prepareFailView(String error) {
                System.out.println(error);
            }


        };
        CalculateScoreInputBoundary calculateScoreInteractor=new CalculateScoreInteractor(calculateScoreDataAccessInterface,successPresenter);
        CalculateScoreController calculateScoreController= new CalculateScoreController(calculateScoreInteractor);
        calculateScoreController.execute(testUser.getPreferences(),testUser.getCityList());

    }

    public static void main(String[] args) {
        CalculateScoreTest scoreTest=new CalculateScoreTest();
        scoreTest.successTest();

    }
}

