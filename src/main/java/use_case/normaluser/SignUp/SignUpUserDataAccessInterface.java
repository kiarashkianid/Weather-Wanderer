package use_case.normaluser.SignUp;

import entity.CommonUser;
import entity.NormalUser;


public interface SignUpUserDataAccessInterface {

    boolean existsByName(String username);

    void save(NormalUser user);


}
