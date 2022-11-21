package view.Employees;

import controller.EmployeeController;
import model.Cart.Cart;
import model.Cart.CartDetailTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailsUI extends JFrame implements ActionListener {
    JPanel panel;
    CartDetailTableModel itemTableModel;
    JTable itemTable;
    JScrollPane scrollPane;
    private JButton markAsDone;
    private JButton backBtn;
    private EmplFrame previousFrame;
    private EmployeeController controller;
    private Cart cart;

    public DetailsUI(Cart cart, EmployeeController controller) {
        itemTableModel = new CartDetailTableModel(cart.getCartItems());
        this.controller = controller;
        this.cart = cart;
        initComponents();
    }

    private void initComponents(){
        panel = new JPanel();
        JLabel titleLabel = new JLabel("Order Details");

        itemTable = new JTable(itemTableModel);
        scrollPane = new JScrollPane(itemTable);
        scrollPane.setPreferredSize(new Dimension(350,300));
        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Button panel
        JPanel buttons = new JPanel();
        markAsDone = new JButton("Mark as fulfilled");
        backBtn = new JButton("Back");
        buttons.add(backBtn);
        buttons.add(markAsDone);
        backBtn.addActionListener(this);
        markAsDone.addActionListener(this);

        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(panel, BorderLayout.CENTER);
        this.getContentPane().add(buttons, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            this.setVisible(false);
            controller.toEmployeeFrame();
        }

        else if(e.getSource() == markAsDone) {
            controller.markComplete(cart);
            this.setVisible(false);
            controller.toEmployeeFrame();
        }
    }
}
