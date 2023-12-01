package use_case.normaluser.Login;

import entity.NormalUser;
import entity.User;

public interface LoginUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(NormalUser user);

    User get(String username);
}
