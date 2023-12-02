package app;

import entity.CommonUserFactory;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.sign_up.SignUpController;
import interface_adapter.sign_up.SignUpPresenter;
import interface_adapter.sign_up.SignUpViewModel;
import use_case.normaluser.SignUp.SignUpInputBoundary;
import use_case.normaluser.SignUp.SignUpInteractor;
import use_case.normaluser.SignUp.SignUpOutputBoundary;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.normaluser.SignUp.SignUpUserDataAccessInterface;
import View.SignUpView;

import javax.swing.*;
import java.io.IOException;

public class SignupUseCaseFactory {

    /** Prevent instantiation. */
    private SignupUseCaseFactory() {}


    static SignUpController createUserSignupUseCase(ViewManagerModel viewManagerModel, SignUpViewModel signupViewModel, ChooseViewModel chooseViewModel, SignUpUserDataAccessInterface userDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        SignUpOutputBoundary signupOutputBoundary = new SignUpPresenter(viewManagerModel, signupViewModel, chooseViewModel);

        NormalUserFactory userFactory = new NormalUserFactory();

        SignUpInputBoundary userSignupInteractor = new SignUpInteractor(
                userDataAccessObject, signupOutputBoundary, userFactory);

        return new SignUpController(userSignupInteractor);
    }
}
