package interface_adapter.calculateweatherscore;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class CalculateWeatherScoreViewModel extends ViewModel {
    public CalculateWeatherScoreViewModel(String viewName) {
        super(viewName);
    }

    public void setState(CalculateWeatherScoreState calculateWeatherScoreState) {
    }
    public CalculateWeatherScoreState getState(){
        return new CalculateWeatherScoreState();
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
