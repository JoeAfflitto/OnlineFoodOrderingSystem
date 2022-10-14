package model;

import view.ManagerUI;

import javax.swing.*;

public class Manager implements User {
    private String logonName;
    private String logonPass;

    public Manager(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;
    }

    @Override
    public void getUI() {
        new ManagerUI();
    }

    @Override
    public String getUsername() {
        return this.logonName;
    }

    @Override
    public String getPassword() {
        return this.logonPass;
    }

    public String showDailySales(){
        return "\nDaily Summary \n--------------- \nSales: 135\nGross Profit: $1,450\nHours of operation: 8";
    }
}
