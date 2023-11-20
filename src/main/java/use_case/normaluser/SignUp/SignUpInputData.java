package use_case.normaluser.SignUp;

public class SignUpInputData {

    final private String username;
    final private String password;
    final private String repeatPassword;

    final private int userID;

    public SignUpInputData(String username, String password, String repeatPassword) {
        this.username = username;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userID = (int)Math.floor(Math.random() *(1000 - 1 + 1) + 1); //giving userID between 1-1000
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    int getUserID() {return userID;}
}
