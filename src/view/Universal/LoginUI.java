package view.Universal;

import controller.LoginController;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    // General panels & buttons
    private JPanel mainPanel;
    private JPanel credentialPanel;
    private JButton loginButton;

    // Credential-related
    private JPasswordField passwordField;
    private JLabel passwordLabel;
    private JTextField nameField;
    private JLabel nameLabel;

    // Other
    private LoginController controller;

    /**
     * Main constructor
     * @param ctl controller which instantiated the instance
     */
    public LoginUI(LoginController ctl){
        this.controller = ctl;
        initComponents();
    }

    public void initComponents(){
        setTitle("Logon Portal");
        mainPanel = new JPanel();
        loginButton = new JButton("Login");

        // Credential region configs
        credentialPanel = new JPanel();
        nameLabel = new JLabel("Username:");
        passwordLabel = new JLabel("Password:");
        nameField = new JTextField();
        passwordField = new JPasswordField();


        // Insertion
        mainPanel.add(loginButton, BorderLayout.SOUTH);
        this.setContentPane(mainPanel);

        // Window Configs
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
