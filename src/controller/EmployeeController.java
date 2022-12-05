package controller;

import model.Cart.Cart;
import model.Cart.CartItem;
import model.Cart.EmplCartTableModel;
import model.Users.Employee;
import model.Users.EndUser;
import view.Employees.DetailsUI;
import view.Employees.EmplFrame;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Employee-user program controller
 */
public class EmployeeController {
    private Employee currentEmpl;
    private JFrame ui;
    private ArrayList<Cart> carts;
    private EmplCartTableModel tableModel;
    private ArrayList<Cart> fulfilled;

    /**
     * For use by login controller to perform employee tasks
     * @param e user who signed in; passed by login ctl
     */
    public EmployeeController(Employee e){
        currentEmpl = e;
        fulfilled = new ArrayList<>();
        carts = new ArrayList<>();
        insertFakeCarts();  // Insert fake orders for demo
        tableModel = new EmplCartTableModel(carts);

        this.ui = new EmplFrame(this); // Initialize employee interface mainframe
    }

    private void insertFakeCarts() {
        carts.add(new Cart(new EndUser("endUser","endPassword")));
        carts.get(0).addItem(new CartItem("Test Item I", "Desc", 20.00, 5));

        carts.add(new Cart(new EndUser("endUser2","endPassword2")));
        carts.get(1).addItem(new CartItem("Test Item II", "Desc", 21.00, 6));
    }

    public EmplCartTableModel getTheCartTableModel() {
        return this.tableModel;
    }

    public void toEmployeeFrame(){
        tableModel = new EmplCartTableModel(carts);
        this.ui = new EmplFrame(this);
    }

    public void toDetailsUI(int selection) {
        this.ui = new DetailsUI(carts.get(selection), this);
    }

    public void markComplete(Cart c){
        fulfilled.add(c);
        carts.remove(c);
    }
}
