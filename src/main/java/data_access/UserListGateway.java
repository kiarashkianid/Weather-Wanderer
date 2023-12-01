package data_access;

import entity.City;
import entity.NormalUser;
import entity.User;
import use_case.normaluser.Login.LoginUserDataAccessInterface;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserListGateway implements SignUpUserDataAccessInterface, LoginUserDataAccessInterface {
    private static List<NormalUser> userList = new ArrayList<>();

    public static List<NormalUser> getUserList() {
        return userList;
    }
    @Override
    public boolean existsByName(String username) {
        User user = null;
        for (NormalUser normal: userList) {
            if (normal.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(NormalUser user) {
        userList.add(user);
    }

    public User get(String username) {
        User user = null;
        for (NormalUser normal: userList) {
            if (normal.getUsername().equals(username)){
                user = normal;
            }
        }
        return user;
    }
}
