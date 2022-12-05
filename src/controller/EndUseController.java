package controller;

import model.Cart.CartItem;
import model.Restauraunts.*;
import model.Cart.Cart;
import model.Users.EndUser;
import model.Users.Product;
import model.Users.User;
import view.EndUsers.*;

import javax.swing.*;
import java.util.ArrayList;

/**
 * End-user program controller
 */
public class EndUseController {
    private RestaurantData rd;
    private EndUser currentUser;
    private RestaurantTableModel restaurantTableModel;
    private CartItemTableModel cartItemTableModel;
    private ArrayList<CartItem> cartItems;
    private Cart cart;
    private ProductTableModel productTableModel;
    private Restaurant selectedRestaurant;

    private JFrame ui;

    // Order total
    private double total;

    public EndUseController(EndUser current) {
        this.currentUser = current;
        this.rd = new RestaurantData();
        cart = new Cart(this.currentUser);
        this.restaurantTableModel = rd.getRestaurantTableModel();
        this.ui = new RestaurantSelectionUI(this);

    }

    public EndUseController(LoginController controller) throws Exception {
        this.rd = new RestaurantData();
        User current = controller.users.get(0);
        EndUser test = new EndUser(current.getUsername(), current.getPassword());
        this.currentUser = test;

        cart = new Cart(this.currentUser);

        // Setup values dependent on restaurant list
        this.restaurantTableModel = new RestaurantTableModel(rd.getTheRestaurantList());

    }

    /**
     * To switch current UI
     */
    public void toRestaurantSelectionUI(){
        this.ui = new RestaurantSelectionUI(this);
    }
    public void toMenuUI(int selection){
        selectedRestaurant = rd.getRestaurant(selection);
        this.ui.setVisible(false);
        this.ui = new MenuUI(new ProductTableModel(rd.getRestaurant(selection)), this);
    }

    public Restaurant getRestaurant(int selection){
        selectedRestaurant = rd.getRestaurant(selection);
        return rd.getRestaurant(selection);
    }

    public void toCartUI(){
        cartItemTableModel = new CartItemTableModel(cart.getCartItems());
        ui.setVisible(false);
        ui = new CartView(this);
    }

    public void toPaymentUI(){
        ui.setVisible(false);
        ui = new PaymentView(this);
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

    public void toReceiptView() {
        this.ui = new ReceiptView();
    }
}
