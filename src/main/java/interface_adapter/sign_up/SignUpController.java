package interface_adapter.sign_up;

import use_case.normaluser.SignUp.SignUpInputBoundary;
import use_case.normaluser.SignUp.SignUpInputData;

public class SignUpController {
    final SignUpInputBoundary userSignupUseCaseInteractor;
    public SignUpController(SignUpInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    public void execute(String username, String password1, String password2) {
        SignUpInputData signupInputData = new SignUpInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

}
