package use_case.normaluser.Login;

public interface LoginOutputBoundary {

    void prepareSuccessView(LoginOutputData user);

    void prepareFailView(String error);

}
