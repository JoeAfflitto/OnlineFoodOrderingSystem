package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Not yet implemented in actual program
 * To be improved Login window
 */
public class LogonUI extends JFrame implements ActionListener {
    JLabel nameLabel;
    JLabel passLabel;
    JTextField nameField;
    JPasswordField passField;
    JPanel credentialPanel;
    JButton enterButton;


    public LogonUI(){
        initComponents();
    }

    private void initComponents(){
        credentialPanel = new JPanel();
        GridLayout layout = new GridLayout(2,2);
        layout.setVgap(0);
        layout.setHgap(-200);
        credentialPanel.setLayout(layout);

        nameLabel = new JLabel("Username:");
        nameField = new JTextField("");

        passLabel = new JLabel("Password:");
        passField = new JPasswordField("");

        credentialPanel.add(nameLabel);
        credentialPanel.add(nameField);
        credentialPanel.add(passLabel);
        credentialPanel.add(passField);

        // Button panel Configs
        JPanel buttons = new JPanel();
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        buttons.add(enterButton);

        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(credentialPanel, BorderLayout.CENTER);
         this.getContentPane().add(buttons, BorderLayout.SOUTH);
        // this.getContentPane().add(menuPanel, BorderLayout.NORTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        LogonUI ui = new LogonUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
