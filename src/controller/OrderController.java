package controller;

import model.Objects.EndUser;
import view.OrderingUI;

public class OrderController {
    private EndUser currentUser;
    private OrderingUI ui;

    public OrderController(EndUser current){
        this.currentUser = current;
        this.ui = new OrderingUI();
    }

}
