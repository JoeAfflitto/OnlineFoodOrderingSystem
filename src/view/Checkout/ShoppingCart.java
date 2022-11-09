package view.Checkout;

import javax.swing.*;

public class ShoppingCart extends JFrame {
    private JLabel titleLabel;
    private JPanel Main;
    private JToolBar toolBar;

    public ShoppingCart(){
        this.setContentPane(Main);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        JButton checkoutButton = new JButton("Checkout");
        toolBar = new JToolBar();
        toolBar.add(checkoutButton);

    }
}
