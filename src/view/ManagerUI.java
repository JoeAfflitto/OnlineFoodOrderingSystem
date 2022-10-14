package view;

import model.Manager;

import javax.swing.*;

/**
 * To be the JPanel underlying the end-user UI
 * Terminal-level functionality at moment
 */
public class ManagerUI {
    private Manager currentManager;

    public ManagerUI(Manager manager) {
        this.currentManager = manager;

        initComponents();
    }

    public void initComponents() {
        printSummary();
    }

    public void printSummary() {
        System.out.println("\nDaily Summary \n--------------- \nSales: 135\nGross Profit: $1,450\nHours of operation: 8");
    }
}