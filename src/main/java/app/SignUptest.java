package app;

import View.ChoosePreferencesView;
import data_access.FileUserDataAccessObject;
import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import View.ViewManager;
import interface_adapter.sign_up.SignUpViewModel;
import interface_adapter.choose_preferences.ChooseViewModel;
import View.SignUpView;
import interface_adapter.sign_up.SignUpController;
import interface_adapter.login.LoginViewModel;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;
import interface_adapter.choose_preferences.ChooseViewModel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static app.SignupUseCaseFactory.createUserSignupUseCase;

public class SignUptest {
    public static void main(String[] args) throws IOException {
        JFrame application = new JFrame("Signup Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        JPanel views = new JPanel(cardLayout);
        application.add(views);

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        SignUpViewModel signupViewModel = new SignUpViewModel();
        ChooseViewModel chooseViewModel = new ChooseViewModel("choosing");

        FileUserDataAccessObject userDataAccessObject;
        userDataAccessObject = new FileUserDataAccessObject(new CommonUserFactory());
        SignUpController signupController = createUserSignupUseCase(viewManagerModel, signupViewModel, chooseViewModel, userDataAccessObject);


        SignUpView signupView = new SignUpView(signupController, signupViewModel, viewManagerModel);
        views.add(signupView, signupView.viewName);

        //ChoosePreferencesView choosePreferencesView = new ChoosePreferencesView()

        viewManagerModel.setActiveView(signupView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);


    }
}
