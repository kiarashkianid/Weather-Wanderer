package View;

import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ChoosePreferencesView extends JPanel implements ActionListener, PropertyChangeListener {

    private final ChooseController chooseController;

    private final ChooseViewModel chooseViewModel;
    private JFrame choosePreferencesFrame;
    private JPanel citiesPanel;
    private JTextField cityTextField;
    private JTextField factor1Field;
    private JTextField factor2Field;
    private JTextField factor3Field;

    // This will the button that saves the preferences & moves onto the next View, being calculateWeatherScores.

    private JButton caclculateButton;

    private ArrayList<String> addedCities = new ArrayList<>();

    public ChoosePreferencesView(ChooseController chooseController, ChooseViewModel chooseViewModel) {
        this.chooseController = chooseController;
        this.chooseViewModel = chooseViewModel;

        choosePreferencesFrame = new JFrame("Choose Preferences");
        choosePreferencesFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        choosePreferencesFrame.setSize(800, 600);

        JPanel choosePreferencesPanel = new JPanel();
        choosePreferencesPanel.setLayout(new BorderLayout());

        // Create & add the calculateScores button
        JPanel calculatePanel = new JPanel();
        calculatePanel.setLayout(new GridLayout(1, 1));

        caclculateButton = new JButton("Calculate Weather Scores");

        caclculateButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(caclculateButton)) {
                            ChooseState currentState = chooseViewModel.getState();
                            // TODO: On success, execute chooseController & execute calculateWeatherScore ( i think)
                            if (!addedCities.isEmpty() && !factor1Field.getText().isEmpty() &&
                                    !factor2Field.getText().isEmpty() && !factor3Field.getText().isEmpty())
                                chooseController.execute(currentState.getTemperature(), currentState.getHumidity(),
                                    currentState.getWindSpeed(), currentState.getCityList());
                            else {
                                JOptionPane.showMessageDialog(null, "Not all Preferences Have" +
                                        " Been Chosen.\nPlease Input Your Preferences and Try Again.");
                            }
                            // TODO: execute calculateWeatherScore ( I THINK )
                        }
                    }
                }
        );

        calculatePanel.add(caclculateButton);

        // Create and add the city input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 1));

        cityTextField = new JTextField(20);
        JButton addButton = new JButton("Add City Using The Following Format: city,country");

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

        // Create and add the list of added cities
        citiesPanel = new JPanel();
        citiesPanel.setLayout(new BoxLayout(citiesPanel, BoxLayout.Y_AXIS));

        inputPanel.add(new JScrollPane(citiesPanel), BorderLayout.SOUTH);

        choosePreferencesPanel.add(inputPanel, BorderLayout.NORTH);
        choosePreferencesPanel.add(scorePanel, BorderLayout.CENTER);
        choosePreferencesPanel.add(calculatePanel, BorderLayout.SOUTH);

        choosePreferencesFrame.add(choosePreferencesPanel);
        choosePreferencesFrame.setVisible(true);
    }

    private void updateCitiesList() {
        citiesPanel.removeAll();
        for (String city : addedCities) {
            citiesPanel.add(new JLabel(city));
        }
        citiesPanel.revalidate();
        citiesPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
