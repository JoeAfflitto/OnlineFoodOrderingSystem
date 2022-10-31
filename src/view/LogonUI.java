package view;

import javax.swing.*;

public class LogonUI {
    private JLabel LoginLabel;
    private JTextField textField1;
    private JLabel uNameLabel;
    private JPasswordField passwordField1;
    private JPanel Main;

    public LogonUI(){
        JFrame frame = new JFrame("LogonUI");
        frame.setContentPane(this.Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
