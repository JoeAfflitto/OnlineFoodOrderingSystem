package controller;

import dataAccess.hopefullyGoodConnector;
import model.UserObjects.EndUser;
import model.UserObjects.Restaurant;
import model.TableModels.RestaurantTableModel;
import view.MenuUI;
import view.RestaurantSelectionUI;

import javax.swing.*;
import java.util.ArrayList;

public class OrderController {
    private EndUser currentUser;
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel tableModel;


    private JFrame ui;

    public OrderController(EndUser current) throws Exception {
        this.currentUser = current;
        hopefullyGoodConnector rd = new hopefullyGoodConnector();
        this.theRestaurantList = rd.getRestaurantList();
        if(theRestaurantList.isEmpty())
            theRestaurantList.add(new Restaurant("Empty Database"));

        this.ui = new RestaurantSelectionUI(this);
        this.tableModel = new RestaurantTableModel(theRestaurantList);

    }

    public void toRestaurantUI(int selection){
        this.ui = new MenuUI(selection, this);
    }

    public RestaurantTableModel getTheTableModel() {
        return this.tableModel;
    }

}
