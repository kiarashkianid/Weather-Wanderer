package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GuestPage {
    private JFrame guestFrame;
    private JPanel citiesPanel;
    private JTextField cityTextField;
    private JTextField factor1Field;
    private JTextField factor2Field;
    private JTextField factor3Field;

    private ArrayList<String> addedCities = new ArrayList<>();

    public GuestPage() {
        guestFrame = new JFrame("Guest Page");
        guestFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guestFrame.setSize(800, 600);

        JPanel guestPanel = new JPanel();
        guestPanel.setLayout(new BorderLayout());

        // Create and add the city input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 1));

        cityTextField = new JTextField(20);
        JButton addButton = new JButton("Add City");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cityName = cityTextField.getText();
                if (!cityName.isEmpty()) {
                    addedCities.add(cityName);
                    updateCitiesList();
                    cityTextField.setText("");
                }
            }
        });

        inputPanel.add(cityTextField);
        inputPanel.add(addButton);

        // Create and add the score entry components
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(4, 1));

        factor1Field = new JTextField(10);
        factor2Field = new JTextField(10);
        factor3Field = new JTextField(10);

        scorePanel.add(new JLabel("How important is the temperature to you between 1 and 100 ? "));
        scorePanel.add(factor1Field);
        scorePanel.add(new JLabel("How important is the humidity to you between 1 and 100 ? \""));
        scorePanel.add(factor2Field);
        scorePanel.add(new JLabel("How important is the precipitation to you between 1 and 100 ? \""));
        scorePanel.add(factor3Field);

        guestPanel.add(inputPanel, BorderLayout.NORTH);
        guestPanel.add(scorePanel, BorderLayout.CENTER);

        // Create and add the list of added cities
        citiesPanel = new JPanel();
        citiesPanel.setLayout(new BoxLayout(citiesPanel, BoxLayout.Y_AXIS));

        guestPanel.add(new JScrollPane(citiesPanel), BorderLayout.SOUTH);

        guestFrame.add(guestPanel);
        guestFrame.setVisible(true);
    }

    private void updateCitiesList() {
        citiesPanel.removeAll();
        for (String city : addedCities) {
            citiesPanel.add(new JLabel(city));
        }
        citiesPanel.revalidate();
        citiesPanel.repaint();
    }
}
