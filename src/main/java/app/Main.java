package app;

import View.SignUpView;
import View.ViewManager;
import interface_adapter.ViewManagerModel;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.calculate_score.ShowResultViewModel;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.guest_user.GuestUserViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.sign_up.SignUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
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

        // TODO: Initialize the different Views using UseCaseFactories for each of them as shown:
        SignUpView signUpView = SignupUseCaseFactory.createUserSignupUseCase();
        views.add(signUpView, signUpView.viewName);


        application.pack();;
        application.setVisible(false); //TODO: set to "true" once complete, then it should work (hopefully)

    }
}
