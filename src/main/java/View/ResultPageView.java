package View;

import entity.City;
import entity.WeatherScore;
import interface_adapter.calculate_score.ShowResultState;
import interface_adapter.calculate_score.ShowResultViewModel;
import use_case.CalculateScore.CalculateScoreOutputData;

import javax.swing.*;
import java.awt.*;

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
        JFrame frame = new JFrame("Result Page");

        initializeComponents(frame); // Initialize UI components

        // Retrieve the state from the view model
        ShowResultState resultState = resultViewModel.getState();

        // If the state exists, display city name and final score
        if (resultState.getCity()!=null) {
            // Get the city name and final score from the ShowResultState
            String cityName = resultState.getCity().getName();
            double finalScore = resultState.getFinalScore().weather_score;

            // Display the city name and final score in the view components
            cityLabel.setText("City with highest score is  " + cityName);
            scoreLabel.setText("with the final weather score of  " + finalScore);
            // Customize label appearance
            cityLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Larger and bold font for city
            scoreLabel.setFont(new Font("Arial", Font.BOLD, 15)); // Slightly smaller font for score

            cityLabel.setForeground(Color.BLUE); // Change city text color to blue
            scoreLabel.setForeground(Color.RED); // Change score text color
        }
        frame.setVisible(true);

        // Initialize UI components and set up the view
    }

    /**
     * Method to initialize UI components, set layout, and add them to the view.
     */
    private void initializeComponents(JFrame frame) {
        cityLabel = new JLabel();
        scoreLabel = new JLabel();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setBackground(Color.LIGHT_GRAY); // Set background color of panel

        // Set layout to GroupLayout for better spacing and resizing
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Add labels to the panel with GroupLayout
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cityLabel)
                        .addComponent(scoreLabel))
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(cityLabel)
                .addComponent(scoreLabel)
        );

        frame.add(panel);
        frame.pack();
        frame.setSize(400, 100); // Set a custom size for the frame
        frame.setLocationRelativeTo(null); // Center the frame on screen
    }

    public static void main(String[] args) {
        ShowResultState showResultState=new ShowResultState();
        City testCity=new City("toronto,Canada");
        testCity.setWeatherScore(new WeatherScore(20));
        showResultState.setFinalScore(new CalculateScoreOutputData(testCity));
        ShowResultViewModel showResultViewModel=new ShowResultViewModel();
        showResultViewModel.setState(showResultState);
        ResultPageView resultPageView=new ResultPageView(showResultViewModel);
        JFrame frame=new JFrame();
        resultPageView.initializeComponents(frame);
    }
}
