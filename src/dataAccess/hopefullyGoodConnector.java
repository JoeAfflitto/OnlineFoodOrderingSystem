package dataAccess;

import model.UserObjects.Restaurant;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class hopefullyGoodConnector {

    private ArrayList<Restaurant> restaurantList;
    private Connection conn;
    private Statement st;
    private ResultSet rs;


    /*
           Returns ArrList of DB's restaurant objects
            */
    public ArrayList<Restaurant> getRestaurantList() throws SQLException, ClassNotFoundException, IOException {
        this.restaurantList = new ArrayList<>();

        conn = getConn();
        st = conn.createStatement();
        rs = st.executeQuery("SELECT object_value FROM main.java_objects");

        while(rs.next()){
            restaurantList.add((Restaurant) this.read(rs, 1));
        }
        return restaurantList;
    }

    /*
     Probably not functional
     */
    public Restaurant getRestaurant(int index) throws SQLException, IOException, ClassNotFoundException {
        st = conn.createStatement();
        rs = st.executeQuery("SELECT object_value FROM foodsystem.java_objects" +
                "WHERE id = " + index);
        return (Restaurant) this.read(rs, index);
    }
    // Uploading functions

    /*
       Uploads restaurant object to db at provided index
     */
    public void uploadRestaurant(Restaurant restaurant, int rowIndex) throws Exception {
        Connection conn = getConn();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO foodsystem.java_objects(id, object_value) values (?, ?)", Statement.RETURN_GENERATED_KEYS);

        // Set restaurant ID
        ps.setInt(1, rowIndex);

        // Set restaurant object_value
        ps.setBytes(2, toBlob(restaurant));

        ps.executeUpdate();

        Statement st = conn.createStatement();
        st.executeQuery("SELECT * FROM foodsystem.java_objects");
    }
    private byte[] toBlob(Object obj)
            throws SQLException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(baos);
        oout.writeObject(obj);
        oout.close();
        return baos.toByteArray();
    }

    private Connection getConn() throws ClassNotFoundException, SQLException {
       //  String filename = "~/sqlite/foodsys_object_db.sqlite";
        String filename = "/Users/psu/IdeaProjects/OnlineFoodOrderingSystemPull/resources/foodsys_object_db.sqlite";
        String url = "jdbc:sqlite:";

        return DriverManager.getConnection(url + filename);
    }

    /*
    Reads byte[] --> returns as object
     */
    private Object read(ResultSet rs, int col) throws SQLException, IOException, ClassNotFoundException {
        byte[] buf = rs.getBytes(col);
        if (buf != null) {
            ObjectInputStream objectIn = new ObjectInputStream(
                    new ByteArrayInputStream(buf));
            return objectIn.readObject();
        }
        return null;
    }

}
