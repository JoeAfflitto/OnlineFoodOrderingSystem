package view.Employees;

import controller.EmployeeController;
import controller.LoginController;
import view.LogonUI;
import view.Universal.LoginUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmplFrame extends JFrame implements ActionListener {
    private JPanel tablePanel;
    private EmployeeController controller;
    private JScrollPane tableScroller;
    private JTable table;
    private JButton detailsButton;
    private JButton logoutBtn;

    public EmplFrame(EmployeeController ctl){
        this.controller = ctl;
        initComponents();

    }

    private void initComponents(){
        // Table panel configuration
        tablePanel = new JPanel();
        JLabel title = new JLabel("Orders Awaiting Fulfillment");
        tablePanel.add(title, BorderLayout.NORTH);
        table = new JTable(controller.getTheCartTableModel());

        // Scroller configuration
        tableScroller = new JScrollPane(table);
        tableScroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
        table.setFillsViewportHeight(true);
        tableScroller.setPreferredSize(new Dimension(350,300));
        tablePanel.add(tableScroller, BorderLayout.CENTER);

        // Button panel
        JPanel buttonPanel = new JPanel();
        detailsButton = new JButton("Details");
        detailsButton.addActionListener(this);
        logoutBtn = new JButton("Logout");
        logoutBtn.addActionListener(this);
        buttonPanel.add(detailsButton);
        buttonPanel.add(logoutBtn);

        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == detailsButton) {
            this.setVisible(false);
            controller.toDetailsUI(table.getSelectedRow());
        }

        else if(e.getSource() == logoutBtn) {
            this.setVisible(false);
            new LoginController();
        }
    }
}
