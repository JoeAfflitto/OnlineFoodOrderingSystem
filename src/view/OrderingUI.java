package view;

import controller.OrderController;
import model.Objects.EndUser;
import model.Objects.Restaurant;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderingUI extends JFrame {
    private JPanel tablePanel;
    private JList<Restaurant> restaurantList;
    private OrderController controller;
    private JScrollPane tableScroller;

    public OrderingUI(OrderController ctl){
        controller = ctl;
        initComponents();
        setVisible(true);
    }
    public void initComponents(){
        JPanel titlePanel = new JPanel();
        JLabel header = new JLabel("Available Restaurants");
        titlePanel.add(header);

        tablePanel = new JPanel();
        restaurantList = new JList<>(controller.getListModel());

        restaurantList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        restaurantList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!e.getValueIsAdjusting()){
                    System.out.println(e.getFirstIndex());
                }
            }
        });

        tableScroller = new JScrollPane(restaurantList);

        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350,300));
        tablePanel.add(tableScroller);


        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(titlePanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new OrderingUI(new OrderController(new EndUser("jef","asdf")));
    }
}