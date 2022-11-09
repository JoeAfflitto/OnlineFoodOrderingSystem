package controller;

import model.Restauraunts.*;
import model.Users.EndUser;
import model.Users.Product;
import view.Ordering.CartView;
import view.Ordering.MenuUI;
import view.Ordering.RestaurantSelectionUI;

import javax.swing.*;
import java.util.ArrayList;

public class OrderController {
    private EndUser currentUser;
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel restaurantTableModel;
    private CartItemTableModel cartItemTableModel;
    private ArrayList<CartItem> cartItems;
    private ProductTableModel productTableModel;

    private JFrame ui;

    public OrderController(EndUser current) throws Exception {
        this.currentUser = current;

        createRestaurantList();

        // Setup values dependent on restaurant list
        this.restaurantTableModel = new RestaurantTableModel(theRestaurantList);

        this.ui = new RestaurantSelectionUI(this);

        // TODO: Function to cart items from item selection UI
        // cartItems = new ArrayList<>();
        // cartItems.add(new CartItem("name", "desc", 2000, 2));
        // cartItemTableModel = new CartItemTableModel(cartItems);
    }

    /**
     * Creates testable restaurants
     */
    private void createRestaurantList() {
        theRestaurantList = new ArrayList<>();
        Restaurant one = new Restaurant("McDonalds");
        theRestaurantList.add(one);

    }

    public void toRestaurantSelectionUI(){
        this.ui = new RestaurantSelectionUI(this);
    }

    public void toMenuUI(int selection){
        this.ui.setVisible(false);
        this.ui = new MenuUI(new ProductTableModel(theRestaurantList.get(selection)), this);
    }

    public void toCartUI(){
        ui.setVisible(false);
        ui = new CartView(this);
    }

    public RestaurantTableModel getTheTableModel() {
        return this.restaurantTableModel;
    }

    public CartItemTableModel getCartItemTableModel() {
        return cartItemTableModel;
    }

}
