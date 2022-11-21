package model.Users;

import controller.EndUseController;

/**
 * Datatype model for end-user information processing
 */
public class EndUser extends AbstractUser implements User{
    private String logonName;
    private String logonPass;


    public EndUser(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;

    }

    /**
     * Initiates the employee user interface
     */
    @Override
    public void directController() throws Exception {
        new EndUseController(this);
    }

    @Override
    public String getUsername() {
        return this.logonName;
    }

    @Override
    public String getPassword() {
        return this.logonPass;
    }

}
