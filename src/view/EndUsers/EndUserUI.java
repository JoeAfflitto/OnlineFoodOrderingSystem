package view.EndUsers;

import model.Objects.EndUser;

/**
 * To be the JPanel underlying the end-user UI
 * Terminal-level functionality at moment
 */
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
