package model.Restauraunts;

import model.Users.Product;

import java.util.ArrayList;

public class RestaurantData {

    public RestaurantData(){

    }

    public ArrayList<Restaurant> getTheRestaurantList(){
        ArrayList<Restaurant> out = new ArrayList<>();

        out.add(new Restaurant("McDonald's"));
        out.get(0).getTheProductList().add(new Product("Burger", 5.99, "Quarter pounder"));
        out.get(0).getTheProductList().add(new Product("French fries", 3.99, "Medium fries"));
        out.add(new Restaurant("Chipotle"));
        out.get(1).getTheProductList().add(new Product("Burrito", 9.99, "Chicken burrito"));
        out.get(1).getTheProductList().add(new Product("Bowl", 10.99, "Burrito bowl"));

        return out;
    }

    public Restaurant getRestaurant(int index){
        return this.getTheRestaurantList().get(index);
    }
}
