package use_case.choosepreferences;


import app.ChoosePreferencesFactory;
import entity.WeatherPref;

public class ChooseInteractor implements ChooseInputBoundary{
    // If User_ID == "GUEST_USER", need InMemoryDataAcessObject, which stores a User Type UserInterface
    // which can either be a normal user or a guest user.
    // Both these have their preferences.
    final ChooseDataAccessInterface chooseDataAccessObject;
    final ChooseOutputBoundary choosePresenter;
    final ChoosePreferencesFactory choosePreferencesFactory;

    public ChooseInteractor(ChooseDataAccessInterface chooseDataAccessInterface,
                           ChooseOutputBoundary choosePresenter,
                           ChoosePreferencesFactory choosePreferencesFactory) {
        this.chooseDataAccessObject = chooseDataAccessInterface;
        this.choosePresenter = choosePresenter;
        this.choosePreferencesFactory = choosePreferencesFactory;
    }
    @Override
    public void execute(ChooseInputData chooseInputData){
        // InputData: The input data comes from the user, whichever 3 preferences they choose
        // as well as the cities they add to the list.
        // A lot happens in ChooseState (I think) as the user chooses the preferences & changes
        // data live.

        // Fail Case dealt with in the View already.

        //Success case:
        // TODO: If Kiarash wants a User as their input for calculateWeatherScore, then we need to change that using a User Factory.
        // First create WeatherPref Entity
        WeatherPref weatherPref = new WeatherPref(chooseInputData.getTemperature(), chooseInputData.getHumidity(),
                chooseInputData.getWindSpeed(), chooseInputData.getTemperatureWeight(),
                chooseInputData.getHumidityWeight(), chooseInputData.getWindSpeedWeight());

        // Then Save & prepareSuccessView
        chooseDataAccessObject.savePreferences(weatherPref, chooseInputData.getCityList());
        ChooseOutputData chooseOutputData = new ChooseOutputData(weatherPref, chooseInputData.getCityList());
        choosePresenter.prepareSuccessView(chooseOutputData);
    }
}
