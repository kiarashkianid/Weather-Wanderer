package interface_adapter.sign_up;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.normaluser.SignUp.SignUpInputBoundary;
import use_case.normaluser.SignUp.SignUpOutputBoundary;
import use_case.normaluser.SignUp.SignUpOutputData;
import interface_adapter.login.LoginViewModel;
import data_access.FileUserDataAccessObject;


public class SignUpPresenter implements SignUpOutputBoundary {
    private final SignUpViewModel signupViewModel;
    private final ChooseViewModel chooseViewModel;
    private ViewManagerModel viewManagerModel;

    public SignUpPresenter(ViewManagerModel viewManagerModel,
                           SignUpViewModel signupViewModel,
                           ChooseViewModel chooseViewModel) {
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
        this.chooseViewModel = chooseViewModel;

    }

    @Override
    public void prepareFailView(String error) {
        SignUpState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();

    }

    @Override
    public void prepareSuccessView(SignUpOutputData user) {//switch to choose and also save in database

        ChooseState chooseState = chooseViewModel.getState();
        System.out.println(chooseState);
        this.chooseViewModel.setState(chooseState);
        chooseViewModel.firePropertyChanged();


        viewManagerModel.setActiveView("login"); //TODO:
        viewManagerModel.firePropertyChanged();
        System.out.println(viewManagerModel.getActiveView());
    }
}
