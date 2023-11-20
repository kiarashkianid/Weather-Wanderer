package use_case.choosepreferences;


import app.ChoosePreferencesFactory;

public class ChooseInteractor {
    // If User_ID == "GUEST_USER", need InMemoryDataAcessObject, which stores a User Type UserInterface
    // which can either be a normal user or a guest user.
    // Both these have their preferences.
    final ChooseDataAccessInterface chooseDataAccessObject;
    final ChooseOutputBoundary choosePresenter;
    final ChoosePreferencesFactory choosePreferencesFactory;

    public GuestInteractor(ChooseDataAccessInterface chooseDataAccessInterface,
                           ChooseOutputBoundary choosePresenter,
                           ChoosePreferencesFactory choosePreferencesFactory) {
        this.chooseDataAccessObject = chooseDataAccessInterface;
        this.choosePresenter = choosePresenter;
        this.choosePreferencesFactory = choosePreferencesFactory;
    }

    public void execute(ChooseInputData chooseInputData){
        // InputData: The input data comes from the user, whichever 3 preferences they choose
        // as well as the cities they add to the list.
        // A lot happens in ChooseState (i think) as the user chooses the preferences & changes
        // data live.

        //Need to take input data, turn into weatherPref entity.

        // Then save that WeatherPref entity
        chooseDataAccessObject.save();
    }
}
