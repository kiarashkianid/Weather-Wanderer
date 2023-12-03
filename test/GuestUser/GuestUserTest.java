package GuestUser;

import ChoosePreferences.testDataAccessObject;
import entity.GuestUser;
import interface_adapter.ViewManagerModel;
import interface_adapter.choose_preferences.ChooseViewModel;
import interface_adapter.guest_user.GuestUserController;
import interface_adapter.guest_user.GuestUserPresenter;
import interface_adapter.guest_user.GuestUserViewModel;
import use_case.choosepreferences.ChooseDataAccessInterface;
import use_case.guestuser.*;

import java.io.IOException;
import java.util.Objects;

public class GuestUserTest {
    GuestDataAccessInterface guestDataAccessObject = new testDataAccessObject();
    ViewManagerModel viewManagerModel = new ViewManagerModel();
    GuestUserViewModel guestUserViewModel = new GuestUserViewModel();
    ChooseViewModel chooseViewModel = new ChooseViewModel();
    GuestOutputBoundary guestPresenter = new GuestUserPresenter(viewManagerModel, guestUserViewModel, chooseViewModel);
    GuestInputBoundary guestInteractor = new GuestInteractor(guestDataAccessObject, guestPresenter);
    GuestUserController guestUserController = new GuestUserController(guestInteractor);

    @org.junit.Test // Want to test when executed, changes current user in DAO to a guest user.
    public void testGuestControllerAndInteractor() throws IOException {

        guestUserController.execute();

        // Check DAO for current user, meaning the interactor was successfully tested:
        assert guestDataAccessObject.getCurr_User().getUserID() == 0; // Guest users always have userID 0.
    }


    @org.junit.Test // Want to test when prepareSuccessView() is called, switches to ChoosePreferencesView
    public void testGuestPresenter() throws IOException {
        GuestOutputData guestOutputData = new GuestOutputData(new GuestUser(null, null));
        guestPresenter.prepareSuccessView(guestOutputData);

        // Check viewManagerModel for its curent activeView:
        assert Objects.equals(viewManagerModel.getActiveView(), "ChooseView");
    }
}
