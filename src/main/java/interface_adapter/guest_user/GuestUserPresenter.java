package interface_adapter.guest_user;

import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseState;
import interface_adapter.choose_preferences.ChooseViewModel;
import use_case.guestuser.GuestOutputBoundary;
import use_case.guestuser.GuestOutputData;

public class GuestUserPresenter implements GuestOutputBoundary{
    private final ViewManagerModel viewManagerModel;

    private final GuestUserViewModel guestUserViewModel;

    private final ChooseViewModel chooseViewModel;

    public GuestUserPresenter(ViewManagerModel viewManagerModel, GuestUserViewModel guestUserViewModel, ChooseViewModel chooseViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.guestUserViewModel = guestUserViewModel;
        this.chooseViewModel = chooseViewModel;
    }


    @Override
    public void prepareSuccessView(GuestOutputData guestOutputData) {
        // On success, switch to choose preferences view
        ChooseState chooseState = chooseViewModel.getState();
        chooseState.setCurrentUser(guestOutputData.getUserID());
        this.chooseViewModel.setState(chooseState);
        chooseViewModel.firePropertyChanged();

        viewManagerModel.setActiveView(chooseViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        // Should never happen.
    }
}
