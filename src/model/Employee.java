package model;

import view.EmployeeUI;

import javax.swing.*;

public class Employee implements User{
    private String logonName;
    private String logonPass;

    public Employee(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;
    }

    @Override
    public JFrame getUI() {
        return new EmployeeUI();
    }
}
