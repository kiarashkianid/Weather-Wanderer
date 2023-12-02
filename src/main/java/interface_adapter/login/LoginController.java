package interface_adapter.login;
import use_case.normaluser.Login.LoginInputData;
import use_case.normaluser.Login.LoginInputBoundary;

public class LoginController {
    static LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }


    public static void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);
        loginUseCaseInteractor.execute(loginInputData);
    }

}
