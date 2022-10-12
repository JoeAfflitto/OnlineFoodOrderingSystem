package model;

import view.EndUserUI;

import javax.swing.*;

public class EndUser implements User{
    private String logonName;
    private String logonPass;

    public EndUser(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;
    }

    @Override
    public JFrame getUI() {
        return new EndUserUI();
    }
}
