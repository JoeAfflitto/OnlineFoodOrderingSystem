package model;

import model.User;
import view.EmployeeUI;

import javax.swing.*;

public class Employee implements User {
    private String logonName;
    private String logonPass;
    public Business employer;

    /**
     *
     * @param lName Logon name
     * @param lPass Logon password
     * @param business Pointer to employer's Business object
     */
    public Employee(String lName, String lPass, Business business){
        this.logonName = lName;
        this.logonPass = lPass;
        this.employer = business;
    }

    /**
     * Initiates the employee user interface
     */
    @Override
    public void getUI() {
        new EmployeeUI(this);
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
