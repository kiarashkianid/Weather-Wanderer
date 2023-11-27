package entity;

import java.time.LocalDateTime;
import java.util.List;

public class CommonUserFactory implements UserFactory{

    public static CommonUser create(int userID, WeatherPref weatherPref, List<City> cityList) {
        return new CommonUser(userID, weatherPref, cityList);
    }

    @Override
    public User create() {
        return null;
    }
}
