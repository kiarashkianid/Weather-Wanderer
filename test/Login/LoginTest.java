package Login;

import View.LoginView;
import data_access.FileUserDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import data_access.UserListGateway;
import entity.City;
import entity.NormalUser;
import entity.User;
import entity.WeatherPref;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.normaluser.Login.*;

import java.util.ArrayList;
import java.util.List;

public class LoginTest {

    void successTest(){

        fileUserDataAccessObject.readUser();
        LoginView loginView = new LoginView(loginController);


    }
    InMemoryUserDataAccessObject inMemoryUserDataAccessObject = new InMemoryUserDataAccessObject();
    UserListGateway userListGateway = new UserListGateway();


    ViewManagerModel viewManagerModel = new ViewManagerModel();

    ChooseViewModel chooseViewModel = new ChooseViewModel();

    LoginViewModel loginViewModel = new LoginViewModel();


    LoginPresenter loginPresenter = new LoginPresenter(viewManagerModel,chooseViewModel,loginViewModel);
    LoginInteractor loginInteractor = new LoginInteractor(inMemoryUserDataAccessObject, userListGateway, loginPresenter);
    LoginController loginController = new LoginController(loginInteractor);



    FileUserDataAccessObject fileUserDataAccessObject = new FileUserDataAccessObject(null);

    public static void main(String[] args) {
        LoginTest loginTest=new LoginTest();
        loginTest.successTest();

    }
}
