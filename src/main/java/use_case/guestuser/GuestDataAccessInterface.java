package use_case.guestuser;

import entity.GuestUser;
import entity.User;

public interface GuestDataAccessInterface {
    void saveGuest(GuestUser user);
    void setCurr_User(User user);

    User getCurr_User();
}
