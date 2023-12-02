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

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
