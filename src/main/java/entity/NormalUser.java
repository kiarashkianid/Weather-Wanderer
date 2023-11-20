package entity;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class NormalUser implements User {
    private int userID;
    private String username;
    private String password;
    private WeatherPref weatherPreference;
    private List<City> cityList;

    private static List<NormalUser> savedCities = new ArrayList<>();

    public NormalUser(int userID, String username, String password, WeatherPref weatherPreference, List<City> cityList)
    {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.weatherPreference = weatherPreference;
        this.cityList = cityList;

        savedCities.add(this);
    }

    public static void main (String[] args)
    { //(hopefully) this creates a txt file which stores every NormalUser's userid, name, and list of cities
        String txtfile = "savedUsers.txt";
        try {
            FileWriter fileWriter = new FileWriter(txtfile);
            for (NormalUser user: savedCities)
            {
                fileWriter.write(Integer.toString(user.userID) + " " + user.username);
                for (City city: user.cityList)
                {
                    fileWriter.write(city.name);
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
