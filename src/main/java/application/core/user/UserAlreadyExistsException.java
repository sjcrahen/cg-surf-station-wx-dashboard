package application.core.user;

public class UserAlreadyExistsException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = -7342998458850527321L;

    public UserAlreadyExistsException() {
        super();
        // TODO Auto-generated constructor stub
    }

    public UserAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        // TODO Auto-generated constructor stub
    }

    public UserAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }

    public UserAlreadyExistsException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public UserAlreadyExistsException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }


}
