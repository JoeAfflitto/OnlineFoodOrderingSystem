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
        this.productList = new ArrayList<>();
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
