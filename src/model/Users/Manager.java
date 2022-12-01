package model.Users;

import model.Restauraunts.Restaurant;
import view.Managers.ManagerPanel;

/**
 * Datatype model for manager users
 */
public class Manager extends AbstractUser implements User {
    private String logonName;
    private String logonPass;
    private Restaurant organization;

    public Manager(String lName, String lPass, Restaurant restaurant){
        this.logonName = lName;
        this.logonPass = lPass;
        this.organization = restaurant;
    }

    @Override
    public void directController() {
        new ManagerPanel(this);
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
