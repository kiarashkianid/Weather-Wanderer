package interface_adapter.login;
import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginViewModel extends ViewModel{
    public static final String TITLE_LABEL = "Login View";
    public static final String USERNAME_LABEL = "Username";
    public static final String PASSWORD_LABEL = "Password";

    public static final String LOGIN_BUTTON_LABEL = "Login";

    private LoginState state = new LoginState();

    public LoginViewModel() {
        super("login");
    }

    public void setState(LoginState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public LoginState getState() {
        return state;
    }


}
