package use_case.normaluser.SignUp;

public class SignUpOutputData {

    private final String username;


    private boolean useCaseFailed;

    public SignUpOutputData(String username, boolean useCaseFailed) {
        this.username = username;
        this.useCaseFailed = useCaseFailed;
    }

}
