package interface_adapter.choose_preferences;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class ChooseViewModel extends ViewModel {
    private ChooseState state = new ChooseState();

    public ChooseViewModel() {
        super("Choose Preferences");
    }

    public ChooseState getState() {
        return state;
    }

    public void setState(ChooseState state) {
        this.state = state;
    }

    public void firePropertyChanged() {
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
