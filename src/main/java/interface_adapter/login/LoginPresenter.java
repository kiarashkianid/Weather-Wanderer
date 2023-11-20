package interface_adapter.login;

import use_case.normaluser.Login.LoginInteractor;

public class LoginPresenter {
    public static String initializeLogin(String username, String password){
        if (username.isEmpty() || password.isEmpty()){
            return "Invalid Input";
        }
        else if (LoginInteractor.authenticate(username, password)) {
            return "Login successful.";
        }
        else {
            return "Login failed. Invalid username or password.";
        }
    }
}
