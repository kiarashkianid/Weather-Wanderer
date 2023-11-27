package use_case.choosepreferences;

import entity.City;
import entity.User;
import entity.WeatherPref;

import java.util.ArrayList;

public interface ChooseDataAccessInterface {
    void savePreferences(User currentUser, WeatherPref weatherPref, ArrayList<City> cityList);

    void setCurr_User(User user);

    User getCurr_User();
}
