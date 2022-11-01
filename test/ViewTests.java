import controller.LoginController;
import controller.OrderController;
import model.Objects.EndUser;
import org.junit.jupiter.api.Test;
import view.LoginWindow;
import view.MenuUI;
import view.RestaurantSelectionUI;

/**
 * Just methods to directly run each interface for testing purposes
 */
public class ViewTests {

    /*
    Just runs an instance of the login window
     */
    @Test
    public void runLoginUI(){
        LoginWindow lw = new LoginWindow(new LoginController());
    }

    /*
     Runs the restaurant selection window
     */
    @Test
    public void runSelectionUI(){
        RestaurantSelectionUI rs = new RestaurantSelectionUI(
                new OrderController(new EndUser("user","pass")));
    }

    /*
    Displays a menu interface
     */
    @Test
    public void runMenuUI(){
        MenuUI menuUI = new MenuUI(new OrderController(new EndUser("user","pass")));
    }
}
