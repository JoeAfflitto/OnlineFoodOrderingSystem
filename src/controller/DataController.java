package controller;

import dataAccess.OldDBconnector;
import model.Objects.Restaurant;
import model.TableModels.RestaurantTableModel;

import java.util.ArrayList;

public class DataController {
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel tableModel;
    private OldDBconnector rd;

    public DataController() throws Exception {
        rd = new OldDBconnector();
        this.theRestaurantList = rd.getRestaurantList();

        this.tableModel = new RestaurantTableModel(theRestaurantList);
    }

    public ArrayList<Restaurant> getTheRestaurantList() {
        return theRestaurantList;
    }

    public RestaurantTableModel getTheTableModel() {
        return this.tableModel;
    }
}