package view;

import controller.LoginController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow {
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton enterButton;

    private LoginController ctl;

    public LoginWindow(LoginController ctl){
        this.ctl = ctl;
        JFrame frame = new JFrame("LoginWindow");
        frame.setContentPane(this.panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private void createUIComponents() {
        this.enterButton = new JButton();

        enterButton.addActionListener(e -> {
            if(!ctl.isLogin(textField1.getText(), passwordField1.getPassword().toString())){

            }
        });
    }
}
