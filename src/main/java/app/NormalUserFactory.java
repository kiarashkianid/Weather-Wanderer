package app;

import entity.NormalUser;
import interface_adapter.normal_user.NormalUserController;

public class NormalUserFactory { //creates instances of NormalUser object
    public static NormalUser create(int userID, String username, String password) {

        return new NormalUser(userID, username, password);
    }

    private static NormalUserController createNormalUserUseCase() {

        return null;
    }
    /*
    public static NormalUserView create()
    {

        return null;
    };*/
}
