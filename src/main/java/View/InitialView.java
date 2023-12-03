package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class InitialView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "Initial Page";
    final JButton logIn;

    final JButton signup;

    final JButton guest;

    public InitialView(JButton logIn, JButton signup, JButton guest) {
        this.logIn = logIn;
        this.signup = signup;
        this.guest = guest;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == logIn) {
            //LoginController loginController = new LoginController(); // Create your LoginController instance

            // Initialize and display the LoginView
            //LoginView loginView = new LoginView(loginController);
        } else if (e.getSource() == signup) {

            // Perform actions for signup button click
            // For instance, navigate to the signup view
        } else if (e.getSource() == guest) {
            // Perform actions for guest button click
            // For instance, continue as a guest user
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        // Respond to property changes if needed
        // For instance, if properties of components change, handle those changes here
    }

}
