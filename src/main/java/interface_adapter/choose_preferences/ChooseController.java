package interface_adapter.choose_preferences;

import use_case.choosepreferences.ChooseInputBoundary;
import use_case.choosepreferences.ChooseInputData;

import java.util.ArrayList;

public class ChooseController {
    final ChooseInputBoundary chooseUseCaseInteractor;

    public ChooseController(ChooseInputBoundary chooseInputBoundary) {
        this.chooseUseCaseInteractor = chooseInputBoundary;
    }

    public void execute(int temp, int humidity, int windSpeed, ArrayList<String> cityList){
        // take in the raw inputs & creates input data, then calls the interactor
        // with that input data
        ChooseInputData chooseInputData = new ChooseInputData(temp, humidity, windSpeed, cityList);

        chooseUseCaseInteractor.execute(chooseInputData);
    }
}
