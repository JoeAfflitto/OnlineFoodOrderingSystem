package view.EndUsers;

import controller.EndUseController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentView extends JFrame implements ActionListener {

    private JFrame frame;
    private JPanel payInfoPanel, namePanel, cardPanel, expPanel, payPanel;
    private JTextField nameField, cardField, expField;
    private JButton payButton;
    private JLabel header, cardLab, nameLab, expLab;
    EndUseController controller;



    public PaymentView(EndUseController ctl){
        this.controller = ctl;
        initComponents();
    }

    private void initComponents(){
        frame = new JFrame();
        frame.setSize(400, 300);

        payInfoPanel = new JPanel();

        namePanel = new JPanel();
        cardPanel = new JPanel();
        expPanel = new JPanel();
        payPanel = new JPanel();

        //payInfoPanel.setLayout(new BorderLayout());//GridBagLayout());


        header = new JLabel("Pay for Order");
        frame.add(header);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(250, 20));

        nameLab = new JLabel("Name on Card:");

        cardField = new JTextField();
        cardField.setPreferredSize(new Dimension(250, 20));
        cardLab = new JLabel("Card Number");

        expField = new JTextField();
        expField.setPreferredSize(new Dimension(250, 20));
        expLab = new JLabel("Expiration Date:");

        payButton = new JButton();
        payButton.setSize(new Dimension(50, 20));
        payButton.setText("Pay");

        namePanel.add(nameLab);
        namePanel.add(nameField);
        cardPanel.add(cardLab);
        cardPanel.add(cardField);
        expPanel.add(expLab);
        expPanel.add(expField);
        payPanel.add(payButton);

        payInfoPanel.add(namePanel);
        payInfoPanel.add(cardPanel);
        payInfoPanel.add(expPanel);
        payInfoPanel.add(payPanel);
        payButton.addActionListener(this);


        frame.add(payInfoPanel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == payButton){
            if(!nameField.getText().isEmpty() && !cardField.getText().isEmpty() && !expField.getText().isEmpty()) {
                this.setVisible(false);
                controller.toReceiptView();
            }
        }
    }
}
