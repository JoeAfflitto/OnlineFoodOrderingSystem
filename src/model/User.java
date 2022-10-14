package model;

import javax.swing.*;

/**
 * Interface ensuring each user type can be processed appropriately by the login controller
 */
public interface User {

    /**
     * To instantiate respective user interface
     */
    void getUI();
    String getUsername();
    String getPassword();
}
