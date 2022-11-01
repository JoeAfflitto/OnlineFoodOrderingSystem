package model.Objects;

/**
 * Datatype model for manager users
 */
public class Manager implements User {
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
        // new ManagerUI(this);
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
