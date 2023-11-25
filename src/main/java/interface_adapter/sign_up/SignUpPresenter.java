package interface_adapter.sign_up;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.normaluser.SignUp.SignUpInputBoundary;
import use_case.normaluser.SignUp.SignUpOutputBoundary;
import use_case.normaluser.SignUp.SignUpOutputData;
import interface_adapter.login.LoginViewModel;


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
    public void prepareSuccessView(SignUpOutputData user) {//switch to choose preferences
        ChooseState chooseState = ChooseViewModel.getState();
        this.chooseViewModel.setState(chooseState);
        chooseViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(chooseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

    }
}
