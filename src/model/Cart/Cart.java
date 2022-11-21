package model.Cart;

import model.Users.EndUser;

import java.util.ArrayList;

public class Cart {
    private ArrayList<CartItem> cartItems;
    private EndUser cartUser;

    public Cart(EndUser u){
        this.cartUser = u;
        this.cartItems = new ArrayList<>();
    }

    public ArrayList<CartItem> getCartItems(){
        return this.cartItems;
    }

    public void addItem(CartItem toCartItem) {
        this.cartItems.add(toCartItem);
    }

    public EndUser getCartUser(){
        return this.cartUser;
    }

    public int getItemCount(){
        int count = 0;
        for(CartItem i: cartItems){
            count += i.getQuantity();
        }
        return count;
    }
}
