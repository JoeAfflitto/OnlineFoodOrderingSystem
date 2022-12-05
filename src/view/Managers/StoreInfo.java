package view.Managers;

import controller.EndUseController;
import controller.LoginController;
import model.Restauraunts.Restaurant;
import model.Users.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class StoreInfo extends JFrame implements ActionListener {
    private JPanel tablePanel, buttonPanel, salesPanel;
    private JTable table;
    private EndUseController controller;
    private JScrollPane tableScroller;
    private JButton btnSelect;
    private HashMap<String, String> salesForRest;
    private JLabel restSales;

    public StoreInfo() throws Exception {
        controller = new EndUseController(new LoginController(false));
        initComponents();

    }

    public void initComponents() {
        salesForRest = new HashMap<>();
        salesForRest.put("Mcdonalds", "$10,000");
        salesForRest.put("Chipotle", "$25,000");

        // Mainframe configuration
        // mainframe = new JFrame();

        //Sales Panel
        JLabel salesForRestLabel = new JLabel("Sales:");
        restSales = new JLabel("");
        salesPanel = new JPanel();
        salesPanel.add(salesForRestLabel);

        // Table panel configuration
        tablePanel = new JPanel();
        table = new JTable(controller.getTheTableModel());

        // Scroller configuration
        tableScroller = new JScrollPane(table);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(250, 300));
        tablePanel.add(tableScroller);

        // Button configs
        buttonPanel = new JPanel();

        btnSelect = new JButton("Select");
        btnSelect.addActionListener(this);
        buttonPanel.add(btnSelect);


        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(salesPanel, BorderLayout.WEST);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Display the frame
        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSelect){
            table.getSelectedRow();
            Restaurant selected = controller.getRestaurant((table.getSelectedRow()));
            restSales.setText(selected.getBusinessName() + ": " + salesForRest.get(selected.getBusinessName()));
        }
    }
}
