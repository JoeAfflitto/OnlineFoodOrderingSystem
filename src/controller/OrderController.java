package controller;

import model.Objects.EndUser;
import model.Objects.Restaurant;
import model.TableModels.RestaurantListModel;
import view.OrderingUI;

import java.util.ArrayList;

public class OrderController {
    private EndUser currentUser;
    private OrderingUI ui;
    private DataController data;
    private RestaurantListModel listModel;

    public OrderController(EndUser current){
        this.currentUser = current;
        this.data = new DataController();
        this.listModel = new RestaurantListModel(data.getTheRestaurantList());
        this.ui = new OrderingUI(this);
    }

    public ArrayList<Restaurant> getAvailableBusinesses(){
        return data.getTheRestaurantList();
    }

    public RestaurantListModel getListModel(){
        return this.listModel;
    }

}
