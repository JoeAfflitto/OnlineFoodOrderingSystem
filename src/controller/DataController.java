package controller;

import model.Objects.Restaurant;
import model.TableModels.RestaurantTableModel;

import java.sql.*;
import java.util.ArrayList;

public class DataController {
    private ArrayList<Restaurant> theRestaurantList;
    private RestaurantTableModel tableModel;
    private Connection connection;

    public DataController(){
        this.theRestaurantList = new ArrayList<>();
        theRestaurantList.add(new Restaurant("Title I"));
        theRestaurantList.add(new Restaurant("Title II"));
        this.tableModel = new RestaurantTableModel(theRestaurantList);

    }

    public ArrayList<Restaurant> getTheRestaurantList() {
        return theRestaurantList;
    }

    public RestaurantTableModel getTheTableModel(){
        return this.tableModel;
    }

    private void connectServer(){
        String connectionUrl =
                "jdbc:sqlserver://yourserver.database.windows.net:1433;"
                        + "database=AdventureWorks;"
                        + "user=yourusername@yourserver;"
                        + "password=yourpassword;"
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (connection. DriverManager.getConnection(connectionUrl)) {
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
