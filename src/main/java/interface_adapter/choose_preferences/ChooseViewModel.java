package interface_adapter.choose_preferences;

import interface_adapter.ViewModel;

public class ChooseViewModel extends ViewModel {
    private ChooseState state = new ChooseState();

    public ChooseState getState() {
        return state;
    }

    public void setState(ChooseState state) {
        this.state = state;
    }
}
