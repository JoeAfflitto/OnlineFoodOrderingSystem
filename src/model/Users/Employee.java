package model.Users;

import controller.EmployeeController;
import model.Restauraunts.Restaurant;

public class Employee extends AbstractUser implements User {
    private String logonName;
    private String logonPass;
    public Restaurant employer;

    /**
     *
     * @param lName Logon name
     * @param lPass Logon password
     * @param restaurant Pointer to employer's Business object
     */
    public Employee(String lName, String lPass, Restaurant restaurant){
        this.logonName = lName;
        this.logonPass = lPass;
        this.employer = restaurant;
    }

    /**
     * Initiates the employee user interface
     */
    @Override
    public void directController() {
        new EmployeeController(this);
    }

    /**
     *
     * @return Employee's username
     */
    @Override
    public String getUsername() {
        return this.logonName;
    }

    /**
     *
     * @return Employee's password
     */
    @Override
    public String getPassword() {
        return this.logonPass;
    }
}
