package controller;

import model.Cart.CartItem;
import model.Restauraunts.*;
import model.Cart.Cart;
import model.Users.EndUser;
import model.Users.Product;
import view.EndUsers.CartView;
import view.EndUsers.MenuUI;
import view.EndUsers.PaymentView;
import view.EndUsers.RestaurantSelectionUI;

import javax.swing.*;
import java.util.ArrayList;

public class EndUseController {
    private EndUser currentUser;
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel restaurantTableModel;
    private CartItemTableModel cartItemTableModel;
    private ArrayList<CartItem> cartItems;
    private Cart cart;
    private ProductTableModel productTableModel;
    private Restaurant selectedRestaurant;

    private JFrame ui;

    // Order total
    private double total;

    public EndUseController(EndUser current) throws Exception {
        this.currentUser = current;

        cart = new Cart(this.currentUser);
        // cartItems = new ArrayList<>();

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
        cartItemTableModel = new CartItemTableModel(cart.getCartItems());
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
        for(CartItem c: cart.getCartItems()){
            if(c.getItemName().equals(selectedItem.getName())) {
                if (c.getItemDesc().equals(selectedItem.getDesc())) {
                    c.setQuantity(c.getQuantity() + 1);
                    isFound = true;
                    total = total + selectedItem.getPrice();
                }
            }
        }
        if(!isFound) {
            cart.addItem(selectedItem.toCartItem(quantity));
            total = total + selectedItem.getPrice();
        }
    }

    public double getTotal(){
        return total;
    }

}
