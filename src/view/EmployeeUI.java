package view;

import model.Employee;

public class EmployeeUI {
    Employee currentEmployee;

    public EmployeeUI(Employee employee){
        this.currentEmployee = employee;
        initComponents();
    }

    public void initComponents(){
        printCustomerData();
    }

    public void printCustomerData(){
        System.out.println("\nDaily Info\n--------------- \nWARNING: You have (2) orders awaiting fulfillment \nOrders fulfilled: 135\nOrders awaiting fulfillment: 2\nHours worked: 5.5");
    }
}
