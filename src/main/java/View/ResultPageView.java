package View;

import interface_adapter.calculate_score.ShowResultState;
import interface_adapter.calculate_score.ShowResultViewModel;

import javax.swing.*;

/**
 * View class representing the result page that displays city and score information.
 */
public class ResultPageView {
    public final String viewName = "Result View";

    // UI components for displaying the city and score
    private JLabel cityLabel;
    private JLabel scoreLabel;

    // ViewModel instance to access the state
    private final ShowResultViewModel resultViewModel;

    /**
     * Constructor to initialize the ResultPageView with a ShowResultViewModel.
     * @param resultViewModel The ShowResultViewModel containing the state to display.
     */
    public ResultPageView(ShowResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
        initializeComponents(); // Initialize UI components

        // Retrieve the state from the view model
        ShowResultState resultState = resultViewModel.getState();

        // If the state exists, display city name and final score
        if (resultState != null) {
            // Get the city name and final score from the ShowResultState
            String cityName = resultState.getCity().getName();
            double finalScore = resultState.getFinalScore().weather_score;

            // Display the city name and final score in the view components
            cityLabel.setText("City: " + cityName);
            scoreLabel.setText("Final Score: " + finalScore);
        }

        // Initialize UI components and set up the view
    }

    /**
     * Method to initialize UI components, set layout, and add them to the view.
     */
    private void initializeComponents() {
        // Initialize UI components such as JLabels
        cityLabel = new JLabel();
        scoreLabel = new JLabel();
        // Add labels to the view or set layout...
    }
}
