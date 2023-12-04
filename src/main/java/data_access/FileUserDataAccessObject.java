package data_access;

import app.NormalUserFactory;
import entity.*;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.choosepreferences.ChooseDataAccessInterface;
import entity.City;
import entity.NormalUser;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    private final UserListGateway userListGateway;

    public FileUserDataAccessObject(UserListGateway userListGateway){
        this.userListGateway = userListGateway;
    }

    @Override
    public void savePreferences(User currentUser, WeatherPref weatherPref, ArrayList<City> cityList){
    }


    public void readUser() {
        File txtfile = new File("savedUsers.txt");
        List<String> users = new ArrayList<>();
        try (Scanner userData = new Scanner(txtfile).useDelimiter("\n")) {
            while (userData.hasNext()) {
                users.add(userData.next());
            }
            for (String string : users) {
                Scanner parameters = new Scanner(string).useDelimiter(",");
                NormalUser normalUser = new NormalUser(Integer.parseInt(parameters.next()), parameters.next(), parameters.next());
                while (parameters.hasNext()) {
                    normalUser.getCityList().add(new City(parameters.next()));
                }
                userListGateway.getUserList().add(normalUser);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean existsByName(String username) {
        for (NormalUser user: UserListGateway.getUserList()){
            if (Objects.equals(user.getName(), username)) {
                return true;
            }
        };
        return false;
    }


    @Override
    public void save(NormalUser user) {
        userListGateway.save(user);
    }

}
