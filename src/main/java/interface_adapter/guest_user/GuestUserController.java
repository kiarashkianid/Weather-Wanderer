package interface_adapter.guest_user;

import use_case.guestuser.GuestInputBoundary;
import use_case.guestuser.GuestInputData;

public class GuestUserController {
    final GuestInputBoundary guestInteractor;

    public GuestUserController(GuestInputBoundary guestInputBoundary){
        this.guestInteractor = guestInputBoundary;
    }

    public void execute(){
        GuestInputData guestInputData = new GuestInputData();

        guestInteractor.execute(guestInputData);
    }
}
