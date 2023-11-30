package View;

import interface_adapter.calculate_score.ShowResultState;
import interface_adapter.calculate_score.ShowResultViewModel;

import javax.swing.*;


public class ResultPageView {

    // UI components for displaying the city and score
    private JLabel cityLabel;
    private JLabel scoreLabel;

    private final ShowResultViewModel resultViewModel;

    public ResultPageView(ShowResultViewModel resultViewModel) {
        this.resultViewModel = resultViewModel;
        initializeComponents();
        ShowResultState resultState=resultViewModel.getState();
        if (resultState != null) {
            // Get the city and score from the ShowResultState
            String cityName = resultState.getCity().getName();
            double finalScore = resultState.getFinalScore().weather_score;

            // Display the city name and final score in the view components
            cityLabel.setText("City: " + cityName);
            scoreLabel.setText("Final Score: " + finalScore);
        }
        // Initialize UI components and set up the view
    }

    private void initializeComponents() {
        // Initialize UI components, set layout, add them to the view, etc.
        cityLabel = new JLabel();
        scoreLabel = new JLabel();
        // Add labels to the view...
    }


}

