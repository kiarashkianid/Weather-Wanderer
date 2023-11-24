package interface_adapter.choose_preferences;

import use_case.choosepreferences.ChooseInputBoundary;
import use_case.choosepreferences.ChooseInputData;

import java.util.ArrayList;

public class ChooseController {
    final ChooseInputBoundary chooseUseCaseInteractor;

    public ChooseController(ChooseInputBoundary chooseInputBoundary) {
        this.chooseUseCaseInteractor = chooseInputBoundary;
    }

    public void execute(int temp, int tempWeight, int humidity, int humidityWeight, int windSpeed, int windSpeedWeight,
                        ArrayList<String> cityList){
        // take in the raw inputs & creates input data, then calls the interactor
        // with that input data
        ChooseInputData chooseInputData = new ChooseInputData(temp, tempWeight, humidity, humidityWeight, windSpeed,
                windSpeedWeight, cityList);

        chooseUseCaseInteractor.execute(chooseInputData);
    }
}
