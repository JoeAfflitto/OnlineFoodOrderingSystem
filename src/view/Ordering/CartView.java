package view.Ordering;

import controller.OrderController;

import javax.swing.*;
import java.awt.*;

public class CartView extends JFrame {

    // Table vars
    private JPanel tablePanel;
    private JTable table;
    private JScrollPane scrollPane1;

    // Controller var
    OrderController ctl;

    // Toolbar
    JToolBar toolBar;
    JButton backBtn;
    JButton checkoutBtn;

    public CartView(OrderController cont) {
        ctl = cont;
        this.initComponents();
        this.setVisible(true);
    }

    private void initComponents() {
        setTitle("Checkout View");

        // Table setup
        table = new JTable(ctl.getCartItemTableModel());
        tablePanel = new JPanel();
        tablePanel.add(new JLabel("Cart Items"), BorderLayout.NORTH);
        tablePanel.add(table);
        scrollPane1 = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane1);

        // Toolbar setup
        toolBar = new JToolBar();
        backBtn = new JButton("Back");
        checkoutBtn = new JButton("Checkout");

        toolBar.add(backBtn);
        toolBar.add(checkoutBtn);

        // Window Config
        this.setContentPane(new JPanel(new BorderLayout()));

        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);

        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }
}
