import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    private JFrame frame;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton logoutButton;
    private JLabel statusLabel;
    private String validUsername = "user";
    private String validPassword = "pass";

    public LoginApp() {
        frame = new JFrame("Login/Logout App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        logoutButton = new JButton("Logout");
        statusLabel = new JLabel("");

        panel.add(new JLabel("Username:"));
        panel.add(usernameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(logoutButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(username, password)) {
                    statusLabel.setText("Login successful.");
                    loginButton.setEnabled(false);
                    logoutButton.setEnabled(true);
                    usernameField.setEnabled(false);
                    passwordField.setEnabled(false);
                } else {
                    statusLabel.setText("Login failed. Invalid username or password.");
                }
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statusLabel.setText("");
                loginButton.setEnabled(true);
                logoutButton.setEnabled(false);
                usernameField.setEnabled(true);
                passwordField.setEnabled(true);
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        logoutButton.setEnabled(false);

        frame.add(panel, BorderLayout.CENTER);
        frame.add(statusLabel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    private boolean authenticate(String username, String password) {
        return username.equals(validUsername) && password.equals(validPassword);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginApp();
            }
        });
    }
}
