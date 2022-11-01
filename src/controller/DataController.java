package controller;

import model.Objects.Restaurant;
import model.TableModels.RestaurantTableModel;

import java.util.ArrayList;

public class DataController {
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel tableModel;

    public DataController(){
        this.theRestaurantList = new ArrayList<>();
        theRestaurantList.add(new Restaurant("Title I"));
        theRestaurantList.add(new Restaurant("Title II"));
        this.tableModel = new RestaurantTableModel(theRestaurantList);

    }


    public ArrayList<Restaurant> getTheRestaurantList() {
        return theRestaurantList;
    }

    public RestaurantTableModel getTheTableModel(){
        return this.tableModel;
    }
}
