package model;

import view.ManagerUI;

import javax.swing.*;

public class Manager implements User {
    private String logonName;
    private String logonPass;
    private Business organization;

    public Manager(String lName, String lPass, Business business){
        this.logonName = lName;
        this.logonPass = lPass;
        this.organization = business;
    }

    @Override
    public void getUI() {
        new ManagerUI(this);
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
