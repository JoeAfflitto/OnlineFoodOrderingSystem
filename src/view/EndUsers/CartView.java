package view.EndUsers;

import controller.EndUseController;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class CartView extends JFrame implements ActionListener {

    // Table vars
    private JPanel tablePanel;
    private JTable table;
    private JScrollPane scrollPane1;

    // Controller var
    EndUseController ctl;

    // Toolbar
    JToolBar toolBar;
    JButton backBtn;
    JButton checkoutBtn;

    //Date picker
    UtilDateModel model;
    JDatePanelImpl datePanel;
    JDatePickerImpl datePicker;

    public CartView(EndUseController cont) {
        ctl = cont;
        this.initComponents();
        this.setVisible(true);


    }

    private void initComponents() {
        setTitle("Checkout View");

        // Table setup
        table = new JTable(ctl.getCartItemTableModel());
        tablePanel = new JPanel();
        tablePanel.add(new JLabel("Cart Items"), BorderLayout.NORTH);
        tablePanel.add(table);
        scrollPane1 = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane1);


        // Add order total
        double total = ctl.getTotal();
        DecimalFormat f = new DecimalFormat("##.00");
        JLabel orderTotal = new JLabel("Order Total: $" + f.format(total));
        tablePanel.add(orderTotal, BorderLayout.SOUTH);

        // Toolbar setup
        toolBar = new JToolBar();
        backBtn = new JButton("Back");
        backBtn.addActionListener(this);
        checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(this);

        toolBar.add(backBtn);
        toolBar.add(checkoutBtn);

        //Date Picker Setup
        model = new UtilDateModel();
        Properties properties = new Properties();

        properties.put("text.today", "Today");
        properties.put("text.month", "Month");
        properties.put("text.year", "Year");

        datePanel = new JDatePanelImpl(model, properties);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.getComponent(0).setPreferredSize(new Dimension(75, 20));
        datePicker.getComponent(1).setPreferredSize(new Dimension(50, 20));
        JLabel dateLabel = new JLabel();
        dateLabel.setText("Pick a date for the order:");
        toolBar.add(dateLabel);
        toolBar.add(datePicker);

        // Window Config
        this.setContentPane(new JPanel(new BorderLayout()));

        this.getContentPane().add(tablePanel, BorderLayout.CENTER);
        this.getContentPane().add(toolBar, BorderLayout.SOUTH);

        this.setSize(500, 550);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backBtn){
            // Back button logic for future
        }

        if(e.getSource() == checkoutBtn){
            ctl.toPaymentUI();
        }
    }

    class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {

        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) throws ParseException {
            if (value != null) {
                Calendar cal = (Calendar) value;
                return dateFormatter.format(cal.getTime());
            }

            return "";
        }

    }

}
