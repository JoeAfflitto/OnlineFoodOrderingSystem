package model.Restauraunts;

import model.Users.Product;
import model.Users.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Datatype model for individual businesses
 */
public class Restaurant implements Serializable {
    private String businessName;
    private ArrayList<User> userList;
    private ArrayList<Product> productList;

    public Restaurant(String title) {
        this.businessName = title;
        this.userList = new ArrayList<>();
        setProductList();
    }

    private void setProductList() {
        this.productList = new ArrayList<>();
        productList.add(new Product("Burger", 5.59, "Quarter Pounder"));
    }

    public ArrayList<Product> getTheProductList(){
        return this.productList;
    }

    public ArrayList<User> getUserList(){
        return this.userList;
    }

    public void addUser(User u){
        this.userList.add(u);
    }

    public void removeUser(User u){
        this.userList.remove(u);
    }

    public String getBusinessName(){
        return this.businessName;
    }

    @Override
    public String toString() {
        return this.businessName;
    }
}
