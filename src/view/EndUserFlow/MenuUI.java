package view.EndUserFlow;

import controller.OrderController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUI extends JFrame implements ActionListener {
    OrderController controller;
    JPanel mainPanel;


    public MenuUI(int index, OrderController orderController) {
        controller = orderController;
        initComponents();
    }

    public void initComponents(){
        mainPanel = new JPanel();


        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        // this.getContentPane().add(titlePanel, BorderLayout.NORTH);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        // his.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
