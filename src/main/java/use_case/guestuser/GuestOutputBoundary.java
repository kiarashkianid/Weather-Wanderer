package use_case.guestuser;

public interface GuestOutputBoundary {
    void prepareSuccessView(GuestOutputData guestOutputData);

    void prepareFailView(String error);
}
