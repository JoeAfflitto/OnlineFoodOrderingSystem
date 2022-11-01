package controller;

import model.Objects.EndUser;
import model.Objects.Restaurant;
import model.TableModels.RestaurantTableModel;
import view.OrderingUI;

import java.util.ArrayList;

public class OrderController {
    private EndUser currentUser;
    private OrderingUI ui;
    private DataController data;
    private RestaurantTableModel tableModel;

    public OrderController(EndUser current){
        this.currentUser = current;
        this.data = new DataController();
        this.ui = new OrderingUI();
        this.tableModel = new RestaurantTableModel(data.getTheRestaurantList());
    }

    public ArrayList<Restaurant> getAvailableBusinesses(){
        return data.getTheRestaurantList();
    }

    public RestaurantTableModel getTheRestaurantTableModel() {
        return this.tableModel;
    }
}
