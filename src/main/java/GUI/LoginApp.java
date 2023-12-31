package GUI;

import interface_adapter.login.LoginPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginApp {
    /*
    private JFrame frame;
    private JLayeredPane layeredPane;
    private JPanel panel;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JLabel statusLabel;
    private JLabel backgroundLabel; // Add a JLabel for the background

    public LoginApp() {
        frame = new JFrame("Login App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 400);

        layeredPane = new JLayeredPane();
        frame.add(layeredPane);

        panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        usernameField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");
        statusLabel = new JLabel("");
        backgroundLabel = new JLabel();

        usernameField.setPreferredSize(new Dimension(150, 150));
        passwordField.setPreferredSize(new Dimension(150, 150));

        GridBagConstraints constrainUserLabel = new GridBagConstraints();
        constrainUserLabel.gridx = 0;
        constrainUserLabel.gridy = 0;
        GridBagConstraints constrainUserField = new GridBagConstraints();
        constrainUserField.gridx = 1;
        constrainUserField.gridy = 0;
        constrainUserField.gridwidth = 2;
        constrainUserField.anchor = GridBagConstraints.WEST;
        constrainUserField.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints constrainPassLabel = new GridBagConstraints();
        constrainPassLabel.gridx = 0;
        constrainPassLabel.gridy = 1;
        GridBagConstraints constrainPassField = new GridBagConstraints();
        constrainPassField.gridx = 1;
        constrainPassField.gridy = 1;
        constrainPassField.gridwidth = 2;
        constrainPassField.anchor = GridBagConstraints.WEST;
        constrainPassField.fill = GridBagConstraints.HORIZONTAL;
        GridBagConstraints constrainLogin = new GridBagConstraints();
        constrainLogin.gridx = 1;
        constrainLogin.gridy = 2;

        panel.add(new JLabel("Username:"), constrainUserLabel);
        panel.add(usernameField, constrainUserField);
        panel.add(new JLabel("Password:"), constrainPassLabel);
        panel.add(passwordField, constrainPassField);
        panel.add(loginButton, constrainLogin);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String message = authenticate(username, password);
                if (message.toLowerCase().contains("success")) {
                    usernameField.setEnabled(false);
                    passwordField.setEnabled(false);
                    loginButton.setEnabled(false);
                }
                statusLabel.setText(message);

            }
        });

        // Load and set your GIF file as the background
        ImageIcon backgroundIcon = new ImageIcon("src/main/java/GUI/loginPageBackground.gif");
        backgroundLabel.setIcon(backgroundIcon);
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        panel.setBounds(100, 100, 400, 200); // Set bounds for the panel
        statusLabel.setBounds(100, 60, 400, 30); // Set bounds for the statusLabel
        layeredPane.add(panel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(statusLabel, JLayeredPane.POPUP_LAYER);

        frame.setVisible(true);
    }

    private String authenticate(String username, String password) {
        return LoginPresenter.initializeLogin(username, password);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginApp();
            }
        });
    }

     */
}