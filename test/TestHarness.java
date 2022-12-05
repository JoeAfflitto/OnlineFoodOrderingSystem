import controller.EmployeeController;
import controller.EndUseController;
import controller.LoginController;
import model.Restauraunts.Restaurant;
import model.Users.Employee;
import model.Users.EndUser;


/**
 * Original TestHarness class
 */
public class TestHarness {
    public static void main(String[] args) throws Exception {
        // Valid credential: username / password):
        // End-user:  endUser / endPassword
        // Employee:  empUser / empPassword
        // Manager:  managerUser / managerPassword

        LoginController lc = new LoginController();

        // EndUseController controller = new EndUseController(new EndUser("asdf","asdf"));
    }
}