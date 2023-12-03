package use_case.choosepreferences;


import app.ChoosePreferencesFactory;
import entity.City;
import entity.User;
import entity.WeatherPref;
import use_case.CalculateScore.WeatherDataHelper;

import java.util.ArrayList;
import java.util.List;

public class ChooseInteractor implements ChooseInputBoundary{
    // If User_ID == "GUEST_USER", need InMemoryDataAcessObject, which stores a User Type UserInterface
    // which can either be a normal user or a guest user.
    // Both these have their preferences.
    final ChooseDataAccessInterface chooseDataAccessObject;
    final ChooseOutputBoundary choosePresenter;

    public ChooseInteractor(ChooseDataAccessInterface chooseDataAccessInterface,
                           ChooseOutputBoundary choosePresenter) {
        this.chooseDataAccessObject = chooseDataAccessInterface;
        this.choosePresenter = choosePresenter;
    }
    @Override
    public void execute(ChooseInputData chooseInputData){
        // InputData: The input data comes from the user, whichever 3 preferences they choose
        // as well as the cities they add to the list.
        // A lot happens in ChooseState (I think) as the user chooses the preferences & changes
        // data live.

        // Fail Case dealt with in the View already.

        //Success case:

        // First create WeatherPref Entity
        WeatherPref weatherPref = new WeatherPref(chooseInputData.getTemperature(), chooseInputData.getHumidity(),
                chooseInputData.getWindSpeed(), chooseInputData.getTemperatureWeight(),
                chooseInputData.getHumidityWeight(), chooseInputData.getWindSpeedWeight());


        //Turn the cities from CityList into type City:
        ArrayList<City> cityList = new ArrayList<City>();
        for (String cityName : chooseInputData.getCityList())
            cityList.add(new City(cityName));


        // Get the User, update the user with the API Helper.
        User inMemoryUser = chooseDataAccessObject.getCurr_User();
        inMemoryUser.setCityList(cityList);
        inMemoryUser.setPreferences(weatherPref);

        User currentUser = WeatherDataHelper.fetchAndUpdateWeatherData(inMemoryUser);


        // Then Save User and its preferences, & execute prepareSuccessView
        chooseDataAccessObject.savePreferences(currentUser, weatherPref, cityList);
        //Change ArrayList to normal List:
        List<City> cities = currentUser.getCityList();

        ChooseOutputData chooseOutputData = new ChooseOutputData(currentUser.getPreferences(), cities);
        choosePresenter.prepareSuccessView(chooseOutputData);

    }
}
