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

    @Override
    public String getUsername() {
        return this.logonName;
    }

    public String showCustomerData(){
        return "\nDaily Info\n--------------- \nWARNING: You have (2) orders awaiting fulfillment \nOrders fulfilled: 135\nOrders awaiting fulfillment: 2\nHours worked: 5.5";
    }

    @Override
    public String getPassword() {
        return this.logonPass;
    }
}
