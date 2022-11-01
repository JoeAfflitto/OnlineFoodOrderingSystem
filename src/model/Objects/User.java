package model.Objects;

/**
 * Interface ensuring each user type can be processed appropriately by the login controller
 */
public interface User {

    /**
     * To instantiate respective user interface
     */
    void directController();
    String getUsername();
    String getPassword();
}
