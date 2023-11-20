package use_case.guestuser;

public class GuestInteractor implements GuestInputBoundary{

    // Literally just let's the InMemoryDataAcessObject know that we are a guest user.
    public GuestInteractor(){}
    @Override
    public void execute(GuestInputData guestInputData) {
        // Creates a guest user? Or does nothing
    }

    }
