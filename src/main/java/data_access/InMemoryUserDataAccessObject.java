package data_access;

import entity.City;
import entity.GuestUser;
import entity.User;
import entity.WeatherPref;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.guestuser.GuestDataAccessInterface;

import java.util.ArrayList;

public class InMemoryUserDataAccessObject implements GuestDataAccessInterface, ChooseDataAccessInterface, CalculateScoreDataAccessInterface {

    private User current_user = null;
    public User getCurrent_user() {
        return current_user;
    }
    public void setCurrent_user(User current_user) {
        this.current_user = current_user;
    }
    @Override
    public void saveGuest(GuestUser user) {
        current_user = user;
    }

    @Override
    public void savePreferences(User currentUser, WeatherPref weatherPref, ArrayList<City> cityList) {
        System.out.println("Preferences saved to In-Memory Data");
    }

    @Override
    public void setCurr_User(User user) {

    }

    @Override
    public User getCurr_User() {
        return null;
    }
}
