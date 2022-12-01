package view.Managers;

import model.Restauraunts.Restaurant;
import model.Users.Manager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerPanel extends JFrame implements ActionListener {
    public static void main(String[] args) {
        ManagerPanel managerPanel = new ManagerPanel(new Manager("asdf","asdf", new Restaurant("Test")));
    }
    private Manager current;
    private JPanel actionPanel;
    private JButton btnStaffOptions;

    public ManagerPanel(Manager manager){
        this.current = manager;

        initComponents();
    }

    private void initComponents() {
        // Panel config
        this.actionPanel = new JPanel(new BorderLayout());

        // Action buttons configs
        btnStaffOptions = new JButton("Staff Options");
        actionPanel.add(btnStaffOptions);

        // Window Config
        BorderLayout layout = new BorderLayout();

        this.setContentPane(new JPanel(layout));
        this.getContentPane().add(actionPanel, BorderLayout.CENTER);
        //this.getContentPane().add(toolBar, BorderLayout.SOUTH);
        this.setTitle("Managerial View");
        this.setSize(500, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
