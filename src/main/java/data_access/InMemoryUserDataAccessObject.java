package data_access;

import entity.GuestUser;
import entity.User;
import use_case.CalculateScore.CalculateScoreDataAccessInterface;
import use_case.guestuser.GuestDataAccessInterface;

public class InMemoryUserDataAccessObject implements CalculateScoreDataAccessInterface,GuestDataAccessInterface {
    private User current_user = null;
    @Override
    public void saveGuest(GuestUser user) {
        current_user = user;
    }

    @Override
    public User get() {
        return null;
    }
}
