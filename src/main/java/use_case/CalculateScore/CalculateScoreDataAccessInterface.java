package use_case.CalculateScore;

import entity.User;

// Interface defining data access methods for CalculateScore use case
public interface CalculateScoreDataAccessInterface {

      /**
       * Retrieves the current user.
       *
       * @return The User object representing the current user.
       */
      User getCurr_User();

      /**
       * Sets the current user.
       *
       * @param user The User object to be set as the current user.
       */
      void setCurrent_user(User user);
}
