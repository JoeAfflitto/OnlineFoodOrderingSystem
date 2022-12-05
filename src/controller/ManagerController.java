package controller;

import model.Restauraunts.InfoTableModel;
import model.Users.Manager;
import view.Managers.ManagerPanel;

import javax.swing.*;

/**
 * Manager program controller
 */
public class ManagerController {
    private JFrame ui;
    private InfoTableModel infoTableModel;

    public ManagerController(Manager manager){
        this.infoTableModel = new InfoTableModel();
        this.ui = new ManagerPanel(this);
    }

    public InfoTableModel getInfoTableModel() {
        return infoTableModel;
    }
}
