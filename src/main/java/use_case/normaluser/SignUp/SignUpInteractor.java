package use_case.normaluser.SignUp;
import app.NormalUserFactory;
import entity.NormalUser;
import entity.User;
import java.lang.Math;

import java.time.LocalDateTime;

// receives input from user, gets work done by entities, and returns output to user
public class SignUpInteractor implements SignUpInputBoundary{

    final SignUpUserDataAccessInterface userDataAccessObject;
    final SignUpOutputBoundary userPresenter;
    final NormalUserFactory userFactory;

    public SignUpInteractor(SignUpUserDataAccessInterface userDataAccessObject, SignUpOutputBoundary userPresenter, NormalUserFactory userFactory) {
        this.userDataAccessObject = userDataAccessObject;
        this.userPresenter = userPresenter;
        this.userFactory = userFactory;
    }

    @Override
    public void execute(SignUpInputData signupInputData) {

        if (userDataAccessObject.existsByName(signupInputData.getUsername())) {
            userPresenter.prepareFailView("User already exists.");
        } else if (!signupInputData.getPassword().equals(signupInputData.getRepeatPassword())) {
            userPresenter.prepareFailView("Passwords don't match.");
        } else {

            NormalUser user = NormalUserFactory.create(signupInputData.getUserID(),signupInputData.getUsername(), signupInputData.getPassword());
            userDataAccessObject.save(user);
            SignUpOutputData signupOutputData = new SignUpOutputData(user.getUsername(), false);
            userPresenter.prepareSuccessView(signupOutputData);
        }

    }





}
