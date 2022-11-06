package controller;

import model.Objects.EndUser;
import view.MenuUI;
import view.RestaurantSelectionUI;

import javax.swing.*;

public class OrderController {
    private EndUser currentUser;

    private JFrame ui;
    public DataController data;

    public OrderController(EndUser current) throws Exception {
        this.currentUser = current;
        this.data = new DataController();
        this.ui = new RestaurantSelectionUI(this);
    }

    public void toRestaurantUI(int selection){
        this.ui = new MenuUI(selection, this);
    }


}
