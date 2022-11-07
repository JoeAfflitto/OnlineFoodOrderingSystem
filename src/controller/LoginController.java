package controller;

import model.UserObjects.*;
import view.LoginWindow;

import java.util.ArrayList;

/**
 * Manages the logon processes
 */
public class LoginController {
    ArrayList<User> users;
    User currentUser;
    LoginWindow logonUI;

    public LoginController(){
        this.users = new ArrayList<>();
        addTestData();
        this.logonUI = new LoginWindow(this);

    }

    /**
     * Inserts testable user credentials into the users ArrayList
     */
    public void addTestData(){
        users.add(new EndUser("endUser", "endPassword"));

        Restaurant smoothieKing = new Restaurant("Smoothie King");
        users.add(new Employee("empUser", "empPassword", smoothieKing));

        users.add(new Manager("managerUser", "managerPassword", smoothieKing));
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
