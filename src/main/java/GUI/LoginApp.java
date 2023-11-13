package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton logoutButton;
    private JLabel statusLabel;
    private JLabel backgroundLabel; // Add a JLabel for the background
    private String validUsername = "user";
    private String validPassword = "pass";

    public LoginApp() {
        frame = new JFrame("Login/Logout App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);

        layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        logoutButton = new JButton("Logout");
        statusLabel = new JLabel("");
        backgroundLabel = new JLabel();

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

        // Load and set your GIF file as the background
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\Kiarash\\IdeaProjects\\Weather-Wanderer\\src\\main\\java\\GUI\\loginPageBackground.gif");
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        panel.setBounds(100, 100, 400, 200); // Set bounds for the panel
        statusLabel.setBounds(100, 350, 400, 30); // Set bounds for the statusLabel
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(statusLabel, JLayeredPane.PALETTE_LAYER);

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