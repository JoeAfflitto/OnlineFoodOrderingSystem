package controller;

import model.Objects.Restaurant;

import java.util.ArrayList;

public class DataController {
    private ArrayList<Restaurant> theRestaurantList;

    public DataController(){
        this.theRestaurantList = new ArrayList<>();
        theRestaurantList.add(new Restaurant("Title I"));
        theRestaurantList.add(new Restaurant("Title II"));

    }


    public ArrayList<Restaurant> getTheRestaurantList() {
        return theRestaurantList;
    }
}
