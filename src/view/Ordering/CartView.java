package view.Ordering;

import controller.OrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartView extends JFrame implements ActionListener {

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
        backBtn.addActionListener(this);
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(this);

        toolBar.add(backBtn);
        toolBar.add(checkoutBtn);

        // Window Config
        this.setContentPane(new JPanel(new BorderLayout()));

        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);

        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            // Back button logic for future
        }

        if(e.getSource() == checkoutBtn){
            ctl.toPaymentUI();
        }
    }
}
