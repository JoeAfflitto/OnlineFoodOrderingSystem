package view.Managers;

import controller.EndUseController;
import controller.ManagerController;
import model.Restauraunts.Restaurant;
import model.Users.EndUser;
import model.Users.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPanel extends JFrame implements ActionListener {
    public static void main(String[] args) {
        // anagerPanel managerPanel = new ManagerPanel(new Manager("asdf","asdf", new Restaurant("Test")));
    }
    private ManagerController controller;
    private JPanel actionPanel;
    private JButton btnStaffOptions, btnStoreInfo;
    private JFrame ui;

    public ManagerPanel(ManagerController ctl){
        this.controller = ctl;

        initComponents();
    }

    private void initComponents() {
        // Panel config
        this.actionPanel = new JPanel(new BorderLayout());

        // Action buttons configs
        btnStaffOptions = new JButton("Staff Options");
        btnStoreInfo = new JButton("Store Info");
        btnStoreInfo.addActionListener(this);
        actionPanel.add(btnStaffOptions);
        JPanel secondPanel = new JPanel();
        secondPanel.add(btnStoreInfo);

        // Window Config
        BorderLayout layout = new BorderLayout();

        this.setContentPane(new JPanel(layout));
        this.getContentPane().add(actionPanel, BorderLayout.CENTER);
        this.getContentPane().add(secondPanel, BorderLayout.WEST);
        //this.getContentPane().add(toolBar, BorderLayout.SOUTH);
        this.setTitle("Managerial View");
        this.setSize(500, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStoreInfo){
            this.setVisible(false);
            try {
                this.ui = new StoreInfo();
            } catch (Exception exception) {
                exception.printStackTrace();
            }

        }
    }
}
