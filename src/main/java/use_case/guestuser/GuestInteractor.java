package use_case.guestuser;

import entity.GuestUser;
import use_case.choosepreferences.ChooseOutputData;

public class GuestInteractor implements GuestInputBoundary{

    final GuestDataAccessInterface guestUserDataAccessObject;
    final GuestOutputBoundary guestPresenter;
    public GuestInteractor(GuestDataAccessInterface guestUserDataAccessObject, GuestOutputBoundary guestPresenter){
        this.guestUserDataAccessObject = guestUserDataAccessObject;
        this.guestPresenter = guestPresenter;
    }
    @Override
    public void execute(GuestInputData guestInputData) {
        // Creates a guest user & changes curr_user in DAOs
        GuestUser guestUser = new GuestUser(null, null);
        guestUserDataAccessObject.saveGuest(guestUser);


        GuestOutputData guestOutputData = new GuestOutputData(0);
        guestPresenter.prepareSuccessView(guestOutputData);
    }

}
