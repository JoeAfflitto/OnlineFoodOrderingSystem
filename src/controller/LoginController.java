package controller;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Manages the logon processes
 */
public class LoginController {
    ArrayList<User> users;
    User currentUser;

    public LoginController(){
        this.users = new ArrayList<>();
        addTestData();
        login();
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
     * Simulates the intended functionality of login window
     */
    public void login(){

        // In place of actual UI for testing
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter your username: ");
        String uName = scan.nextLine();
        System.out.println("Enter your password: ");
        String uPass = scan.nextLine();

        // continue asking for password while entered credentials are incorrect
        // currentUser variable is set by isLogin()
        if(!isLogin(uName, uPass)){
            do {
                System.out.println("Credentials incorrect. Please try again");

                System.out.println("Enter your username: ");
                uName = scan.nextLine();
                System.out.println("Enter your password: ");
                uPass = scan.nextLine();
            } while(!isLogin(uName, uPass));
        }

        // Sends user to respective UI
        currentUser.getUI();

    }

    /**
     * For checking provided credentials against user database
     * Additionally sets currentUser variable for use elsewhere in controller
     *
     * @param name username as inputted by user upon login prompt
     * @param pass password as inputted by user upon login prompt
     * @return true if valid credentials are passed, else false
     */
    boolean isLogin(String name, String pass){
        for (User current : users) {
            if (current.getUsername().equals(name) && current.getPassword().equals(pass)) {
                currentUser = current;
                return true;
            }
        }
        return false;
    }

}
