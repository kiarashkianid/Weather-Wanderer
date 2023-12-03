package View;

import entity.City;
import entity.WeatherPref;
import interface_adapter.ViewModel;
import interface_adapter.calculate_score.CalculateScoreController;
import interface_adapter.calculate_score.CalculateScoreViewModel;
import interface_adapter.choose_preferences.ChooseController;
import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.CalculateScore.CalculateScoreInputData;
import use_case.CalculateScore.CalculateScoreInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoosePreferencesView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "Choose Preferences";

    private final ChooseController chooseController;

    private final ChooseViewModel chooseViewModel;
    private final CalculateScoreController calculateScoreController;
    private JFrame choosePreferencesFrame;
    private final JPanel citiesPanel;
    private final JTextField cityTextField;
    private final JTextField factor1Field;
    private final JTextField preference1Field;
    private final JTextField factor2Field;
    private final JTextField preference2Field;
    private final JTextField factor3Field;
    private final JTextField preference3Field;

    // This will the button that saves the preferences & moves onto the next View, being calculateWeatherScores.

    private final JButton caclculateButton;

    private final ArrayList<String> addedCities = new ArrayList<>();

    public ChoosePreferencesView(ChooseController chooseController, ChooseViewModel chooseViewModel,
                                 CalculateScoreController calculateScoreController, CalculateScoreViewModel calculateScoreViewModel ) {
        this.chooseController = chooseController;
        this.chooseViewModel = chooseViewModel;
        this.calculateScoreController = calculateScoreController;

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
                            // TODO: On success, execute chooseController
                            currentState.setTemperature(Integer.parseInt(preference1Field.getText()));
                            currentState.setHumidity(Integer.parseInt(preference2Field.getText()));
                            currentState.setWindSpeed(Integer.parseInt(preference3Field.getText()));
                            currentState.setTemperatureWeight(Integer.parseInt(factor1Field.getText()));
                            currentState.setHumidityWeight(Integer.parseInt(factor2Field.getText()));
                            currentState.setWindSpeedWeight(Integer.parseInt(factor3Field.getText()));
                            currentState.setCityList(addedCities);
                            if (!addedCities.isEmpty() && !factor1Field.getText().isEmpty() &&
                                    !factor2Field.getText().isEmpty() && !factor3Field.getText().isEmpty() &&
                                    !preference1Field.getText().isEmpty() && !preference2Field.getText().isEmpty() &&
                                    !preference3Field.getText().isEmpty())
                                chooseController.execute(currentState.getTemperature(),
                                        currentState.getTemperatureWeight(), currentState.getHumidity(),
                                        currentState.getHumidityWeight(), currentState.getWindSpeed(),
                                        currentState.getWindSpeedWeight(), currentState.getCityList());

                            // Create Calculate Controller & Execute it:());
                            ArrayList<City> addedCites = calculateScoreViewModel.getState().getCities();
                            WeatherPref weatherPref = new WeatherPref(chooseViewModel.getState().getTemperature(),
                                    chooseViewModel.getState().getTemperatureWeight(), chooseViewModel.getState().getHumidity(),
                                    chooseViewModel.getState().getHumidityWeight(), chooseViewModel.getState().getWindSpeed(),
                                    chooseViewModel.getState().getWindSpeedWeight());

                            calculateScoreController.execute(weatherPref, addedCites);
                        }
                            else {
                                JOptionPane.showMessageDialog(null, "Not all Preferences Have" +
                                        " Been Chosen.\nPlease Input Your Preferences and Try Again.");
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

                // Checks if the user input text is in the form: "city,country" using regex:
                Pattern pattern = Pattern.compile("^[a-zA-Z]+,[a-zA-Z]+$");
                Matcher matcher = pattern.matcher(cityName);

                if (matcher.matches()) {
                    addedCities.add(cityName.toLowerCase()); // converts the string to lower case for the API.
                    updateCitiesList();
                    cityTextField.setText("");
                }
                else {
                    // Creates a popup telling the user their city,country input is incorrect:
                    JOptionPane.showMessageDialog(null, "City Input Incorrect.\nPlease Input Your" +
                            " City In the following format:\ncity,country");
                }
            }
        });

        inputPanel.add(cityTextField);
        inputPanel.add(addButton);

        // Create and add the score entry components
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(6, 1));

        preference1Field = new JTextField(5);
        preference2Field = new JTextField(5);
        preference3Field = new JTextField(5);
        factor1Field = new JTextField(5);
        factor2Field = new JTextField(5);
        factor3Field = new JTextField(5);

        scorePanel.add(new JLabel("What is your ideal Temperature between -40 to 40 degrees Celsius? "));
        scorePanel.add(preference1Field);
        scorePanel.add(new JLabel("What is your ideal Humidity from 1% to 100% ? \""));
        scorePanel.add(preference2Field);
        scorePanel.add(new JLabel("What is your ideal WindSpeed between 1 and 20 meters/second ? \""));
        scorePanel.add(preference3Field);
        scorePanel.add(new JLabel("How important is the Temperature to you between 1% and 100% ? "));
        scorePanel.add(factor1Field);
        scorePanel.add(new JLabel("How important is the Humidity to you between 1% and 100% ? \""));
        scorePanel.add(factor2Field);
        scorePanel.add(new JLabel("How important is the WindSpeed to you between 1% and 100% ? \""));
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
