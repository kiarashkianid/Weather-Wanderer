package data_access;

import entity.City;
import entity.NormalUser;

import java.io.FileWriter;
import java.io.IOException;
 //still needs to be worked on
public class FileUserDataAccessObject {

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
