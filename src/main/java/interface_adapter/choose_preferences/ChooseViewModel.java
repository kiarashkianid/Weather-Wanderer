package interface_adapter.choose_preferences;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ChooseViewModel extends ViewModel {
    private static ChooseState state = new ChooseState();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);


    public ChooseViewModel() {
        super("Choose Preferences");
    }

    public static ChooseState getState() {
        return state;
    }

    public void setState(ChooseState state) {
        this.state = state;
    }

    //TODO: Why is the propertyName "state", does it matter???
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
