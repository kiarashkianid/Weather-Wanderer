package use_case.guestuser;

import entity.User;

public class GuestOutputData {
    private final User guestUser;
    public GuestOutputData(User guestUser){
        this.guestUser = guestUser;
    }

    public User getUserID() {
        return guestUser;
    }
}
