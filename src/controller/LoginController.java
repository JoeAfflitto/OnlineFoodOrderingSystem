package controller;

import model.Restauraunts.Restaurant;
import model.Restauraunts.RestaurantData;
import model.Users.*;
import view.Universal.LoginUI;
import view.Universal.LoginWindow;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Manages the logon processes
 */
public class LoginController {
    ArrayList<User> users;
    User currentUser;
    JFrame logonUI;
    RestaurantData rd;

    public LoginController(){
        rd = new RestaurantData();
        this.users = rd.getAllUsers();
        addTestData();

        this.logonUI = new LoginWindow(this);
    }

    public LoginController(boolean visible){
        this.users = new ArrayList<>();
        addTestData();
    }

    /**
     * Inserts testable user credentials into the users ArrayList
     */
    public void addTestData(){
        users.add(new EndUser("endUser", "endPassword"));

        Restaurant smoothieKing = new Restaurant("Smoothie King");
        users.add(new Employee("empUser", "empPassword", smoothieKing));

        users.add(new Manager("managerUser", "managerPassword"));
    }

    /**
     * Checks login against appropriate data
     *
     * @param name username as inputted by user upon login prompt
     * @param pass password as inputted by user upon login prompt
     * @return true if valid credentials are passed, else false
     *
     */
    public boolean isLogin(String name, String pass) throws Exception {
        for (User current : users) {
            if (current.getUsername().equals(name) && current.getPassword().equals(pass)) {
                currentUser = current;
                current.directController();
                return true;
            }
        }
        return false;
    }

}
