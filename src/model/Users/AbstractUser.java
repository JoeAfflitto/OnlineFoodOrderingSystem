package model.Users;

import controller.OrderController;

public abstract class AbstractUser {


    public abstract void directController() throws Exception;


    public abstract String getUsername();


    public abstract String getPassword();

}
