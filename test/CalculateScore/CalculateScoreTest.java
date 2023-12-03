package CalculateScore;

import data_access.InMemoryUserDataAccessObject;
import entity.City;
import entity.CommonUser;
import entity.User;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.*;
import use_case.CalculateScore.*;

import java.util.ArrayList;
import java.util.List;

public class CalculateScoreTest {
    void successTest(){
        CalculateScoreDataAccessInterface calculateScoreDataAccessInterface=new InMemoryUserDataAccessObject();

        City city1=new City("yazd,iran");
        City city2=new City("london,uk");
        List<City> cityList=new ArrayList<City>();
        cityList.add(city1);
        cityList.add(city2);
        WeatherPref testWeatherPref= new WeatherPref(20,10,10,50,50,50);
        User testUser=new CommonUser(1,testWeatherPref,cityList);
        calculateScoreDataAccessInterface.setCurrent_user(WeatherDataHelper.fetchAndUpdateWeatherData(testUser));
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        CalculateScoreViewModel calculateScoreViewModel = new CalculateScoreViewModel("calculateScore");
        ShowResultViewModel showResultViewModel=new ShowResultViewModel("showResult");
        ShowResultState showResultState=new ShowResultState();
        showResultViewModel.setState(showResultState);
        CalculateScoreOutputBoundary successPresenter = new CalculateScorePresenter(viewManagerModel,showResultViewModel) {
        /*
            @Override
            public void prepareSuccessView(CalculateScoreOutputData score) {
                List<City> cities =testUser.getCityList();
                assert testUser.getCityList().equals(cityList);
            }

            @Override
            public void prepareFailView(String error) {
                System.out.println(error);
            }

        */
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

