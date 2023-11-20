package use_case.choosepreferences;

import use_case.guestuser.GuestOutputData;

public interface ChooseOutputBoundary {
    void prepareSuccessView(ChooseOutputData chooseOutputData);

    void prepareFailView(String error);
}
