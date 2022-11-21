package view.EndUsers;

import controller.EndUseController;
import model.Users.EndUser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantSelectionUI extends JFrame implements ActionListener {
    private JPanel tablePanel;
    private JTable table;
    private EndUseController controller;
    private JScrollPane tableScroller;
    private JPanel buttonPanel;
    private JButton btnSelect;


    public RestaurantSelectionUI(EndUseController ctl){
        controller = ctl;
        initComponents();
    }

    public void initComponents(){
        // Mainframe configuration
        // mainframe = new JFrame();

        // Title panel configuration
        JPanel titlePanel = new JPanel();
        JLabel header = new JLabel("Available Restaurants");
        titlePanel.add(header);

        // Table panel configuration
        tablePanel = new JPanel();
        table = new JTable(controller.getTheTableModel());

        // Scroller configuration
        tableScroller = new JScrollPane(table);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tableScroller.setPreferredSize(new Dimension(350,300));
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
        this.getContentPane().add(titlePanel, BorderLayout.NORTH);
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // Display the frame
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSelect){
            controller.toMenuUI(table.getSelectedRow());
        }
    }

    public static void main(String[] args) throws Exception {
        RestaurantSelectionUI ui = new RestaurantSelectionUI(new EndUseController(new EndUser("endUser", "endPassword")));
    }
}