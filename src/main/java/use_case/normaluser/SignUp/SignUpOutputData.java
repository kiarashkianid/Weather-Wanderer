package use_case.normaluser.SignUp;

public class SignUpOutputData {

    private final String username;
    private String creationTime;

    private boolean useCaseFailed;

    public SignUpOutputData(String username, String creationTime, boolean useCaseFailed) {
        this.username = username;
        this.creationTime = creationTime;
        this.useCaseFailed = useCaseFailed;
    }

}
