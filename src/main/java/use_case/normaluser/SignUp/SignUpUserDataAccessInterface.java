package use_case.normaluser.SignUp;

import entity.User;

public interface SignUpUserDataAccessInterface {
    boolean existsByName(String username);

    void save(User user);
}
