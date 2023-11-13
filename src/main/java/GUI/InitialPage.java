package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPage {
    private JFrame initialFrame;

    public InitialPage() {
        initialFrame = new JFrame("Welcome");
        initialFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initialFrame.setSize(650, 450);

        JPanel initialPanel = new JPanel();
        initialPanel.setLayout(new GridLayout(2, 1));

        JButton guestButton = new JButton("Guest");
        JButton userButton = new JButton("User");

        initialPanel.add(guestButton);
        initialPanel.add(userButton);

        guestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the guest use case here
                new GuestPage(); // Create and show the GuestPage
                initialFrame.dispose(); // Close the initial page
            }
        });

        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle the user use case here
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        new LoginApp();
                    }
                });
                initialFrame.dispose(); // Close the initial page
            }
        });

        initialFrame.add(initialPanel, BorderLayout.CENTER);
        initialFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InitialPage();
            }
        });
    }
}
