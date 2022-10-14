package model;

import model.User;
import view.EmployeeUI;

import javax.swing.*;

public class Employee implements User {
    private String logonName;
    private String logonPass;
    public Business employer;

    public Employee(String lName, String lPass, Business business){
        this.logonName = lName;
        this.logonPass = lPass;
        this.employer = business;
    }

    @Override
    public void getUI() {
        new EmployeeUI(this);
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
