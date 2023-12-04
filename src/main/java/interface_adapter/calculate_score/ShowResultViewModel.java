package interface_adapter.calculate_score;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// View model responsible for managing ShowResultState
public class ShowResultViewModel extends ViewModel {

    private ShowResultState state = new ShowResultState(); // State containing result data
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // Constructor to initialize the ShowResultViewModel with a view name
    public ShowResultViewModel() {
        super("Result View"); // Call to superclass constructor
    }

    // Retrieve the current state
    public ShowResultState getState() {
        return state;
    }

    // Set the state to be managed by the view model
    public void setState(ShowResultState resultState) {
        this.state = resultState;
    }

    // Trigger a property change notification (currently empty)
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    // Override to add a property change listener (currently empty)
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}
