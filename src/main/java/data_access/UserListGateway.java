package data_access;

import entity.NormalUser;
import entity.User;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class UserListGateway implements SignUpUserDataAccessInterface {
    private static List<NormalUser> userList = new ArrayList<>();

    public static List<NormalUser> getUserList() {
        return userList;
    }
    @Override
    public boolean existsByName(String username) {
        return false;
    }

    @Override
    public void save(NormalUser user) {
        userList.add(user);
    }
}
