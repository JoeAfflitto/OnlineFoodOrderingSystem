package controller;

import dataAccess.hopefullyGoodConnector;
import model.UserObjects.EndUser;
import model.UserObjects.Restaurant;
import model.TableModels.RestaurantTableModel;
import view.EndUserFlow.MenuUI;
import view.EndUserFlow.PaymentUI;
import view.EndUserFlow.RestaurantSelectionUI;

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
        // this.theRestaurantList = rd.getRestaurantList();
        // if(theRestaurantList.isEmpty())
        //     theRestaurantList.add(new Restaurant("Empty Database"));

        theRestaurantList = new ArrayList<>();
        theRestaurantList.add(new Restaurant("Asdf"));

        this.ui = new RestaurantSelectionUI(this);
        this.tableModel = new RestaurantTableModel(theRestaurantList);

    }

    public void toMenuUI(int selection){
        this.ui.setVisible(false);
        this.ui = new MenuUI(selection, this);
    }

    public void toPaymentUI(){
        ui.setVisible(false);
        ui = new PaymentUI();
    }

    public RestaurantTableModel getTheTableModel() {
        return this.tableModel;
    }

}
