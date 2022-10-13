package model;

import view.EndUserUI;

import javax.swing.*;
import java.util.ArrayList;


public class EndUser implements User{
    private String logonName;
    private String logonPass;
    private ArrayList<String> menu = new ArrayList<>();



    public EndUser(String lName, String lPass){
        this.logonName = lName;
        this.logonPass = lPass;
        createMenu();

    }



    @Override
    public JFrame getUI() {
        return new EndUserUI();
    }

    @Override
    public String getUsername() {
        return this.logonName;
    }

    @Override
    public String getPassword() {
        return this.logonPass;
    }

    public void createMenu(){
        menu.add("Chicken Tenders: $13");
        menu.add("Cheeseburger: $8");
        menu.add("Wings: $10");
        menu.add("Hot Dog: $6");
        menu.add("Soda: $2");
        menu.add("Water: $1");
    }

    public ArrayList<String> getMenu() {
        return menu;
    }

}
