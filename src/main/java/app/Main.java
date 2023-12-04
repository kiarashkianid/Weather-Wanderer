package app;

import View.*;
import data_access.FileUserDataAccessObject;
import data_access.InMemoryUserDataAccessObject;
import data_access.UserListGateway;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScorePresenter;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.calculate_score.ShowResultViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.guest_user.GuestUserViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginPresenter;
import interface_adapter.login.LoginViewModel;
import interface_adapter.sign_up.SignUpController;
import interface_adapter.sign_up.SignUpViewModel;
import use_case.CalculateScore.CalculateScoreInputBoundary;
import use_case.CalculateScore.CalculateScoreInteractor;
import use_case.CalculateScore.CalculateScoreOutputBoundary;
import use_case.normaluser.Login.LoginInputBoundary;
import use_case.normaluser.Login.LoginInteractor;
import use_case.normaluser.Login.LoginOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // The main application window.
        JFrame application = new JFrame("Calculate WeatherScore");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // Initialize All the ViewModels:
        SignUpViewModel signUpViewModel = new SignUpViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        GuestUserViewModel guestUserViewModel = new GuestUserViewModel();
        ChooseViewModel chooseViewModel = new ChooseViewModel();
        ShowResultViewModel calculateScoreViewModel = new ShowResultViewModel();

        // TODO: Initialize the DAOs
        UserListGateway userListGateway = new UserListGateway();
        FileUserDataAccessObject fileUserDataAccessObject=new FileUserDataAccessObject();//TODO @Oscar how do u initialize the File user DAO,i dont understand User factory implementation
        InMemoryUserDataAccessObject inMemoryUserDataAccessObject=new InMemoryUserDataAccessObject();

        // TODO: Initialize the different Views using UseCaseFactories for each of them as shown:
        //Signup view
        SignUpController signUpController=SignupUseCaseFactory.createUserSignupUseCase(viewManagerModel,signUpViewModel,chooseViewModel,fileUserDataAccessObject);
        SignUpView signUpView = new SignUpView(signUpController,signUpViewModel,viewManagerModel);
        views.add(signUpView, signUpView.viewName);
        //LoginView
        LoginOutputBoundary loginOutputBoundary=new LoginPresenter(viewManagerModel,chooseViewModel,loginViewModel);
        LoginInputBoundary loginInputBoundary =new LoginInteractor(inMemoryUserDataAccessObject,userListGateway,loginOutputBoundary);//TODO: @Matthew pls initialize ur userlistGateway
        LoginController loginController=new LoginController(loginInputBoundary);
        LoginView loginView=new LoginView(loginController);
        views.add(loginView,loginView.viewName);
        //ChoosePreferencesView
        ChooseController chooseController=ChoosePreferencesFactory.createUserSignUpUseCase(viewManagerModel,chooseViewModel,calculateScoreViewModel,inMemoryUserDataAccessObject);
        CalculateScoreOutputBoundary calculateScoreOutputBoundary=new CalculateScorePresenter(viewManagerModel,calculateScoreViewModel);
        CalculateScoreInputBoundary calculateScoreInputBoundary=new CalculateScoreInteractor(inMemoryUserDataAccessObject,calculateScoreOutputBoundary);
        CalculateScoreController calculateScoreController=new CalculateScoreController(calculateScoreInputBoundary);
        ChoosePreferencesView preferencesView=new ChoosePreferencesView(chooseController,chooseViewModel,calculateScoreController,calculateScoreViewModel);
        ResultPageView resultPageView=new ResultPageView(calculateScoreViewModel);
        views.add(preferencesView,preferencesView.viewName);
        views.add(resultPageView,resultPageView.viewName);

        application.pack();;
        application.setVisible(false); //TODO: set to "true" once complete, then it should work (hopefully)

    }
}
