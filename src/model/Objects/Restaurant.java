package model.Objects;

import java.util.ArrayList;

/**
 * Datatype model for individual businesses
 */
public class Restaurant {
    private String name;
    // TODO: Storage of other business-related info
    private ArrayList<User> userList;
    private ArrayList<Product> products;

    public Restaurant(String title) {
        this.name = title;
        this.userList = new ArrayList<>();
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

    public String getName(){
        return this.name;
    }
}
