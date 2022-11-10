package model.Restauraunts;

//import com.sun.org.apache.xpath.internal.operations.Bool;
import model.Users.Product;
import model.Users.User;
//import sun.jvm.hotspot.debugger.win32.coff.DebugVC50SymbolEnums;

import javax.swing.*;
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

        // Decorator: Ability to modify menu items and restaurant names (in OrderController class)

        if (this.businessName.equalsIgnoreCase("McDonalds")){
            productList.add(new Product("Burger", 5.59, "1/4 Pounder"));
            productList.add(new Product("Burger", 6.59, "Big Mac"));
            productList.add(new Product("Chicken", 5.59, "10 pc. Nugget"));
        }
        else if (this.businessName.equalsIgnoreCase("Chipotle")){
            productList.add(new Product("Burrito", 7.79, "Carnitas"));
            productList.add(new Product("Tacos", 6.99, "Chicken"));
            productList.add(new Product("Quesadilla", 7.49, "Steak"));
        }


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
