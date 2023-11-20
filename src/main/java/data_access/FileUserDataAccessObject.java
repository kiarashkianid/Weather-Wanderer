package data_access;

import entity.City;
import entity.NormalUser;
import data_access.UserListGateway;

import java.io.FileWriter;
import java.io.IOException;
 //still needs to be worked on
public class FileUserDataAccessObject {

    public static void main (String[] args)
    { //(hopefully) this creates a txt file which stores every NormalUser's userid, name, and list of cities
        String txtfile = "savedUsers.txt";
        try {
            FileWriter fileWriter = new FileWriter(txtfile);
            for (NormalUser user: UserListGateway.getUserList())
            {
                fileWriter.write(Integer.toString(user.getUserID()) + " " + user.getUsername());
                for (City city: user.getCityList())
                {
                    fileWriter.write(city.getName());
                }
            }
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
