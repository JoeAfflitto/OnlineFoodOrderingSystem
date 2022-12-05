package model.Restauraunts;

import model.Users.Manager;
import model.Users.Product;
import model.Users.User;

import java.util.ArrayList;

public class RestaurantData {

    public RestaurantData(){

    }

    public ArrayList<Restaurant> getTheRestaurantList(){
        ArrayList<Restaurant> out = new ArrayList<>();

        // McDick's data configs
        out.add(new Restaurant("McDonald's"));
        out.get(0).getTheProductList().add(new Product("Burger", 5.99, "Quarter pounder"));
        out.get(0).getTheProductList().add(new Product("French fries", 3.99, "Medium fries"));
        out.get(0).addUser(new Manager("mcUser", "mcPass"));

        // Chip data configs
        out.add(new Restaurant("Chipotle"));
        out.get(1).getTheProductList().add(new Product("Burrito", 9.99, "Chicken burrito"));
        out.get(1).getTheProductList().add(new Product("Bowl", 10.99, "Burrito bowl"));
        out.get(1).addUser(new Manager("chipUser", "chipPass"));

        return out;
    }

    public Restaurant getRestaurant(int index){
        return this.getTheRestaurantList().get(index);
    }

    public RestaurantTableModel getRestaurantTableModel() {
        return new RestaurantTableModel(this.getTheRestaurantList());
    }

    public ArrayList<User> getAllUsers(){
        ArrayList<User> out = new ArrayList<>();

        for(Restaurant r: getTheRestaurantList()){
            for(User u: r.getUserList())
                out.add(u);
        }

        return out;
    }


}
