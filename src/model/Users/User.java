package model.Users;

/**
 * Interface ensuring each user type can be processed appropriately by the login controller
 */
public interface User {

    /**
     * To instantiate respective user interface
     */
    void directController() throws Exception;
    String getUsername();
    String getPassword();
}
