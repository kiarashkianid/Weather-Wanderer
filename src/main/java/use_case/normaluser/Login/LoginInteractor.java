package use_case.normaluser.Login;

public class LoginInteractor {
    public static boolean authenticate(String username, String password) {
        if (username.equals("user") && password.equals("pass")){
        return true;}
        else {return false;}
        //TODO: Code Interactor to pull from DB via Gateway
    }

    public static void userIdToMemory(int id){
        //TODO: Add to Memory
    }
}
