package interface_adapter.calculate_score;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

// View model responsible for managing ShowResultState
public class ShowResultViewModel extends ViewModel {

    private ShowResultState state; // State containing result data

    // Constructor to initialize the ShowResultViewModel with a view name
    public ShowResultViewModel(String viewName) {
        super(viewName); // Call to superclass constructor
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
    }

    // Override to add a property change listener (currently empty)
    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    }
}
