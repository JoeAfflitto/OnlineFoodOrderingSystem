package view.EndUserFlow;

import javax.swing.*;
import java.awt.*;

public class PaymentUI extends JFrame {
    private JPanel mainPanel;

    public PaymentUI(){

    }

    public void initComponents(){
        mainPanel = new JPanel();


        // General window configurations
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        // this.getContentPane().add(titlePanel, BorderLayout.NORTH);
        this.getContentPane().add(mainPanel, BorderLayout.CENTER);
        // his.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        // Display the frame
        this.setVisible(true);
    }
}
