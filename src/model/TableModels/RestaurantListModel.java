package model.TableModels;

import model.Objects.Restaurant;

import javax.swing.*;
import java.util.ArrayList;

public class RestaurantListModel extends DefaultListModel<Restaurant> {
    ArrayList<Restaurant> restaurants;

    public RestaurantListModel(ArrayList<Restaurant> restaurantArrayList){
        this.restaurants = restaurantArrayList;
    }
    @Override
    public int getSize() {
        return restaurants.size();
    }

    @Override
    public Restaurant getElementAt(int index) {
        return restaurants.get(index);
    }
}
