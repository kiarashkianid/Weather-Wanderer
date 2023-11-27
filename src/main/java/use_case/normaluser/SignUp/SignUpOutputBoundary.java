package use_case.normaluser.SignUp;

public interface SignUpOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(SignUpOutputData user);
}
