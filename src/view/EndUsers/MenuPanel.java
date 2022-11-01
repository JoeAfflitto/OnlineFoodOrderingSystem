package view.EndUsers;

import model.Objects.EndUser;

import java.util.ArrayList;

/**
 * Contains menu-displaying related functions
 * To be a JFrame
 */
public class MenuPanel {
    private ArrayList<String> menu = new ArrayList<>();
    private EndUser currentUser;

    public MenuPanel(EndUser user){
        this.currentUser = user;
        createMenu();
        printMenu();
    }

    public void createMenu(){
        menu.add("Chicken Tenders: $13");
        menu.add("Cheeseburger: $8");
        menu.add("Wings: $10");
        menu.add("Hot Dog: $6");
        menu.add("Soda: $2");
        menu.add("Water: $1");
    }

    public void printMenu(){
        System.out.println("Welcome, " + this.currentUser.getUsername() + ".\nHere is the menu: ");
        System.out.println("________________________");
        for (String item: menu
        ) {
            System.out.println(item);

        }
    }
}
