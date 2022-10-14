package view;

import model.Employee;

public class EmployeeUI {
    Employee currentEmployee;

    public EmployeeUI(Employee employee){
        this.currentEmployee = employee;
        initComponents();
    }

    public void initComponents(){
        System.out.println(currentEmployee.showCustomerData());
    }
}
