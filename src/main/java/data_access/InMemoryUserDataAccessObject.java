package data_access;

import entity.GuestUser;
import entity.User;
import use_case.guestuser.GuestDataAccessInterface;

public class InMemoryUserDataAccessObject implements GuestDataAccessInterface {
    private User current_user = null;
    @Override
    public void saveGuest(GuestUser user) {
        current_user = user;
    }
}
