package interface_adapter.login;

import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.ViewManagerModel;
import use_case.normaluser.Login.LoginOutputData;
import use_case.normaluser.Login.LoginOutputBoundary;


public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final ChooseViewModel chooseViewModel;
    private ViewManagerModel viewManagerModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          ChooseViewModel chooseViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.chooseViewModel = chooseViewModel;
        this.loginViewModel = loginViewModel;
    }


    @Override
    public void prepareSuccessView(LoginOutputData user) {
        ChooseState loggedInState = chooseViewModel.getState();
        this.chooseViewModel.setState(loggedInState);
        chooseViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(chooseViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
        System.out.println(viewManagerModel.getActiveView());
    }
    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}

