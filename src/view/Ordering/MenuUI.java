package view.Ordering;

import controller.OrderController;
import model.Restauraunts.ProductTableModel;
import model.Restauraunts.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener {
    OrderController controller;
    JPanel tablePanel;
    JTable table;
    JButton btnAddToCart;
    JButton btnGoCheckout;

    public MenuUI(ProductTableModel tableModel, OrderController orderController) {
        controller = orderController;
        table = new JTable(tableModel);
        initComponents();
    }

    public void initComponents(){
        setTitle("Menu View");
        tablePanel = new JPanel();
        tablePanel.add(table);

        // Button panel configs
        JPanel btnPanel = new JPanel();
        btnAddToCart = new JButton("Add to Cart");
        btnGoCheckout = new JButton("Checkout");

        btnGoCheckout.addActionListener(this);
        btnAddToCart.addActionListener(this);

        btnPanel.add(btnAddToCart);
        btnPanel.add(btnGoCheckout);

        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        // this.getContentPane().add(titlePanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(btnPanel, BorderLayout.SOUTH);

        // Display the frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnAddToCart){
            controller.addToCart(table.getSelectedRow(), 1);
        }

        if(e.getSource() == btnGoCheckout){
            controller.toCartUI();
        }
    }
}
