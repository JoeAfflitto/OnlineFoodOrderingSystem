package view.EndUsers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptView extends JFrame implements ActionListener {
    private JPanel headerPanel, bodyPanel, buttonPanel;
    private JButton btnOkay;

    public ReceiptView(){
        this.initComponents();
    }

    private void initComponents(){
        headerPanel = new JPanel();
        bodyPanel = new JPanel();
        buttonPanel = new JPanel();

        btnOkay = new JButton("Okay");

        buttonPanel.add(btnOkay);

        // Window config
        this.setTitle("Receipt View");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setContentPane(new JPanel(new BorderLayout()));
        this.getContentPane().add(headerPanel, BorderLayout.NORTH);
        this.getContentPane().add(bodyPanel, BorderLayout.CENTER);
        this.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnOkay)
            System.exit(0);
    }
}
