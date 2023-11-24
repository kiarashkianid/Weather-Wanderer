package use_case.choosepreferences;

import entity.User;
import entity.WeatherPref;

import java.util.ArrayList;

public interface ChooseDataAccessInterface {
    void savePreferences(WeatherPref weatherPref, ArrayList<String> cityList);

    void setCurr_User(User user);

    User getCurr_User();
}
