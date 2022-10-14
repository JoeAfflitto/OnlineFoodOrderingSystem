package model;

import view.EndUsers.EndUserUI;

import java.util.ArrayList;


public class EndUser implements User{
    private String logonName;
    private String logonPass;

    public EndUser(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;

    }

    @Override
    public void getUI() {
        new EndUserUI(this);
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
