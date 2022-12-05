package model.Users;

import controller.ManagerController;
import model.Restauraunts.Restaurant;
import view.Managers.ManagerPanel;

/**
 * Datatype model for manager users
 */
public class Manager extends AbstractUser implements User {
    private String logonName;
    private String logonPass;
    private Restaurant organization;

    public Manager(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;
    }

    @Override
    public void directController() {
        new ManagerController(this);
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
