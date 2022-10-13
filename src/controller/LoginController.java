package controller;

import model.Employee;
import model.EndUser;
import model.Manager;
import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginController {
    ArrayList<User> users;

    public LoginController(){
        this.users = new ArrayList<>();
        addTestUsers();
        login();
    }

    public void addTestUsers(){
        users.add(new EndUser("endUser", "endPassword"));
        users.add(new Employee("empUser", "empPassword"));
        users.add(new Manager("managerUser", "managerPassword"));
    }

    public void login(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter account type: \n\t1) User\n\t2) Employee \n\t3) Manager ");
        int acctType = Integer.parseInt(scan.nextLine());
        System.out.println("Enter your username: ");
        String uName = scan.nextLine();
        System.out.println("Enter your password: ");
        String uPass = scan.nextLine();

        if(!isLogin(acctType, uName, uPass)){
            do {
                System.out.println("Credentials incorrect. Please try again");

                System.out.println("Enter your username: ");
                uName = scan.nextLine();
                System.out.println("Enter your password: ");
                uPass = scan.nextLine();
            } while(!isLogin(acctType, uName, uPass));
        }

        System.out.println("Credentials accepted\nWelcome, " + uName);
        switch (acctType){
            case 1:
                EndUser endUser = new EndUser(uName, uPass);
                ArrayList<String> menu = endUser.getMenu();
                System.out.println("Here is the menu: ");
                System.out.println("________________________");
                for (String item: menu
                     ) {
                    System.out.println(item);
                    
                }
                break;
            case 2:
                Employee employee = new Employee(uName, uPass);
                String employeeData = employee.showCustomerData();
                System.out.println(employeeData);
                break;
            case 3:
                Manager manager = new Manager(uName, uPass);
                String managerData = manager.showDailySales();
                System.out.println(managerData);
                break;
            default:
                System.out.println("Not recognized.");
                break;
        }

    }

    boolean isLogin(int type, String name, String pass){
        for(int i=0; i < users.size(); i++){
            User current = users.get(i);
            if(current.getUsername().equals(name) && current.getPassword().equals(pass))
                return true;
        }
        return false;
    }

}
