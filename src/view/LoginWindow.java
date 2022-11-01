package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame implements ActionListener {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton enterButton;
    private JLabel tryAgainLabel;

    private LoginController ctl;

    public LoginWindow(LoginController ctl){
        this.ctl = ctl;
        this.setContentPane(panel1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    private void createUIComponents() {
        tryAgainLabel = new JLabel();
        tryAgainLabel.setVisible(false);

        this.enterButton = new JButton();

        enterButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        boolean valid = ctl.isLogin(textField1.getText(), String.valueOf(passwordField1.getPassword()));

        if (!valid){
            tryAgainLabel.setVisible(true);
            this.pack();
        }

        else this.setVisible(false);
    }
}
