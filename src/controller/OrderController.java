package controller;

import model.Restauraunts.*;
import model.Users.EndUser;
import model.Users.Product;
import view.Ordering.CartView;
import view.Ordering.MenuUI;
import view.Ordering.PaymentView;
import view.Ordering.RestaurantSelectionUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderController {
    private EndUser currentUser;
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel restaurantTableModel;
    private CartItemTableModel cartItemTableModel;
    private ArrayList<CartItem> cartItems;
    private ProductTableModel productTableModel;
    private Restaurant selectedRestaurant;

    private JFrame ui;

    // Order total
    double total = 0;

    public OrderController(EndUser current) throws Exception {
        this.currentUser = current;
        cartItems = new ArrayList<>();

        // Import restaurant objects
        createRestaurantList();

        // Setup values dependent on restaurant list
        this.restaurantTableModel = new RestaurantTableModel(theRestaurantList);

        // Load first UI frame for end-user flow
        this.ui = new RestaurantSelectionUI(this);

    }

    /**
     * Creates testable restaurants
     */



    private void createRestaurantList() {
        theRestaurantList = new ArrayList<>();
        Restaurant one = new Restaurant("McDonalds");
        theRestaurantList.add(one);
        Restaurant two = new Restaurant("Chipotle");
        theRestaurantList.add(two);

        // Can continue adding/updating restaurants

    }

    /**
     * To switch current UI
     */
    public void toRestaurantSelectionUI(){
        this.ui = new RestaurantSelectionUI(this);
    }
    public void toMenuUI(int selection){
        selectedRestaurant = theRestaurantList.get(selection);
        this.ui.setVisible(false);
        this.ui = new MenuUI(new ProductTableModel(theRestaurantList.get(selection)), this);
    }

    public void toCartUI(){
        cartItemTableModel = new CartItemTableModel(cartItems);
        ui.setVisible(false);
        ui = new CartView(this);
    }

    public void toPaymentUI(){
        ui.setVisible(false);
        ui = new PaymentView();
    }

    /**
     * To get table models
     */
    public RestaurantTableModel getTheTableModel() {
        return this.restaurantTableModel;
    }

    public CartItemTableModel getCartItemTableModel() {
        return cartItemTableModel;
    }

    /**
     * Cart methods
     */
    public void addToCart(int index, int quantity){
        Product selectedItem = selectedRestaurant.getTheProductList().get(index);
        boolean isFound = false;

        // First check if any of item is already in cart
        for(CartItem c: cartItems){
            if(c.getItemName().equals(selectedItem.getName())) {
                if (c.getItemDesc().equals(selectedItem.getDesc())) {
                    c.setQuantity(c.getQuantity() + 1);
                    isFound = true;
                    total = total + selectedItem.getPrice();
                }
            }
        }
        if(!isFound) {
            cartItems.add(selectedItem.toCartItem(quantity));
            total = total + selectedItem.getPrice();
        }
    }

    public double getTotal(){
        return total;
    }


}
