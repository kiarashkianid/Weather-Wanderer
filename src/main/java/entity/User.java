package entity;

import java.util.List;

public interface User {
    void setCityList(List<City> cities);

    List<City> getCityList();
}
