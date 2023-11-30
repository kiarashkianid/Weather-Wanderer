package interface_adapter.calculate_score;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

//TODO
public class ShowResultViewModel extends ViewModel {

    private ShowResultState state;

    public ShowResultViewModel(String viewName) {super(viewName);

    }
    public ShowResultState getState() {
        return state;
    }

    public void setState(ShowResultState resultState) {
        this.state=resultState;
    }

    public void firePropertyChanged() {
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }


}
