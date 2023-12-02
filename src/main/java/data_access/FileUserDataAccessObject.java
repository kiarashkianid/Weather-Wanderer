package data_access;

import entity.*;
import use_case.choosepreferences.ChooseDataAccessInterface;
import entity.City;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;

import java.io.*;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class FileUserDataAccessObject implements ChooseDataAccessInterface, SignUpUserDataAccessInterface {



 //still needs to be worked on

    private final File preferencesCsvFile = new File("preferences.csv");

    private final Map<String, Integer> preferencesHeaders = new LinkedHashMap<>();

    private User curr_User;

    private final Map<String, CommonUser> accounts = new HashMap<>(); // In the form: {String userID: User user}

    public User getCurr_User() {
        return curr_User;
    }

    public void setCurr_User(User curr_User) {
        this.curr_User = curr_User;
    }

    private boolean isGuestUser = false;

    public FileUserDataAccessObject(UserFactory userFactory){}

    @Override
    public void savePreferences(User currentUser, WeatherPref weatherPref, ArrayList<City> cityList){
    }


    @Override
    public boolean existsByName(String username) {
        return false;
    }

    @Override
    public void save(NormalUser user) {

    }
}
