package data_access;

import entity.NormalUser;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserListGateway {
    private static List<NormalUser> userList = new ArrayList<>();

    public static List<NormalUser> getUserList() {
        return userList;
    }

    public static void add(NormalUser user){
        userList.add(user);
    }
}
