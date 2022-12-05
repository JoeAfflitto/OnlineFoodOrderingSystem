package view.EndUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptView extends JFrame implements ActionListener {
    private JPanel headerPanel, bodyPanel, buttonPanel;
    private JButton btnOkay;
    private JLabel confirmField;

    public ReceiptView(){
        this.initComponents();
    }

    private void initComponents(){
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        buttonPanel = new JPanel();

        btnOkay = new JButton("Okay");
        btnOkay.addActionListener(this);

        buttonPanel.add(btnOkay);

        confirmField = new JLabel("Order Placed Successfully -- Ready for pickup in [20 Minutes]", SwingConstants.CENTER);


        // Window config
        this.setTitle("Receipt View");
        this.setSize(600, 300);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.getContentPane().add(bodyPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.getContentPane().add(confirmField, BorderLayout.CENTER);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnOkay)
            System.exit(0);
    }
}
