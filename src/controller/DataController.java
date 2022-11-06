package controller;

import dataAccess.RestaurantData;
import model.Objects.Restaurant;
import model.TableModels.RestaurantTableModel;

import java.util.ArrayList;

public class DataController {
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel tableModel;
    private RestaurantData rd;

    public DataController() throws Exception {
        rd = new RestaurantData();
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