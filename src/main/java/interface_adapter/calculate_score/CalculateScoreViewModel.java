package interface_adapter.calculate_score;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class CalculateScoreViewModel extends ViewModel {

    private CalculateScoreState state = new CalculateScoreState();
    public CalculateScoreViewModel(String viewName) {
        super(viewName);
    }
    public String getViewName() {
        return super.getViewName();
    }
    //TODO
    public CalculateScoreState getState(){return state;}

    public void setState(CalculateScoreState calculateWeatherScoreState) {
        this.state=calculateWeatherScoreState;
    }
    public void firePropertyChanged() {
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}




