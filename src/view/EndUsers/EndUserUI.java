package view.EndUsers;

import model.EndUser;

import javax.swing.*;
import java.util.ArrayList;

public class EndUserUI {
    EndUser endUser;
    public EndUserUI(EndUser user){
        this.endUser = user;
        initComponents();
    }

    private void initComponents() {
        new MenuPanel(endUser);
    }

}
