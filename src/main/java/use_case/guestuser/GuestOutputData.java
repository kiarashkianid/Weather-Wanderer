package use_case.guestuser;

public class GuestOutputData {
    private final int userID;
    public GuestOutputData(int userID){
        this.userID = userID;
    }

    public int getUserID() {
        return userID;
    }
}
