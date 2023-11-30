package data_access;

import app.NormalUserFactory;
import entity.*;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.choosepreferences.ChooseDataAccessInterface;
import entity.City;
import entity.NormalUser;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;
import java.io.IOException;

public class FileUserDataAccessObject implements ChooseDataAccessInterface {

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

    private void saveUser(){
        //(hopefully) this creates a txt file which stores every NormalUser's userid, name, and list of cities
        String txtfile = "savedUsers.txt";
        try {
            FileWriter fileWriter = new FileWriter(txtfile);
            for (NormalUser user: UserListGateway.getUserList())
            {
                fileWriter.write(Integer.toString(user.getUserID()) + " " + user.getUsername());
                for (City city: user.getCityList())
                {
                    fileWriter.write(city.getName());
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
