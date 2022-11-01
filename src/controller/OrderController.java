package controller;

import model.Objects.EndUser;
import view.MenuUI;
import view.RestaurantSelectionUI;

import javax.swing.*;

public class OrderController {
    private EndUser currentUser;

    // User interfaces
    private JFrame ui;
    public DataController data;

    public OrderController(EndUser current){
        this.currentUser = current;
        this.data = new DataController();
        this.ui = new RestaurantSelectionUI(this);
    }

    public void toRestaurantUI(int selection){
        this.ui = new MenuUI(this);
    }


}
