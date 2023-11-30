package View;

import interface_adapter.calculate_score.ShowResultState;
import javax.swing.*;


public class ResultPageView {

    // Assume these are your UI components for displaying the city and score
    private JLabel cityLabel;
    private JLabel scoreLabel;

    public ResultPageView() {
        // Initialize UI components and set up the view
        initializeComponents();
    }

    private void initializeComponents() {
        // Initialize UI components, set layout, add them to the view, etc.
        cityLabel = new JLabel();
        scoreLabel = new JLabel();
        // Add labels to the view...
    }

    // Method to update the view based on the ShowResultState
    public void updateView(ShowResultState resultState) {
        if (resultState != null) {
            // Get the city and score from the ShowResultState
            String cityName = resultState.getCity().getName();
            double finalScore = resultState.getFinalScore().weather_score;

            // Display the city name and final score in the view components
            cityLabel.setText("City: " + cityName);
            scoreLabel.setText("Final Score: " + finalScore);
        }
    }

}

