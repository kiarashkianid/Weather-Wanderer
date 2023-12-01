package use_case.normaluser.Login;

import data_access.InMemoryUserDataAccessObject;
import data_access.UserListGateway;
import entity.User;

public class LoginInteractor implements LoginInputBoundary {
    final InMemoryUserDataAccessObject inMemoryUserDataAccessObject;
    final UserListGateway userDataAccessObject;
    final LoginOutputBoundary loginPresenter;

    public LoginInteractor(InMemoryUserDataAccessObject inMemoryUserDataAccessObject, UserListGateway userDataAccessInterface,
                           LoginOutputBoundary loginOutputBoundary) {
        this.inMemoryUserDataAccessObject = inMemoryUserDataAccessObject;
        this.userDataAccessObject = userDataAccessInterface;
        this.loginPresenter = loginOutputBoundary;
    }

    @Override
    public void execute(LoginInputData loginInputData) {
        String username = loginInputData.getUsername();
        String password = loginInputData.getPassword();
        if (!userDataAccessObject.existsByName(username)) {
            loginPresenter.prepareFailView(username + ": Account does not exist.");
        } else {
            String pwd = userDataAccessObject.get(username).getPassword();
            if (!password.equals(pwd)) {
                loginPresenter.prepareFailView("Incorrect password for " + username + ".");
            } else {

                User user = userDataAccessObject.get(loginInputData.getUsername());
                inMemoryUserDataAccessObject.setCurr_User(user);

                LoginOutputData loginOutputData = new LoginOutputData(user.getName(), false);
                loginPresenter.prepareSuccessView(loginOutputData);
            }
        }
    }
}
