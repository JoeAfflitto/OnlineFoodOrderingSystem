package dataAccess;

/*
 * mysql> CREATE TABLE java_objects (
 * id INT AUTO_INCREMENT,
 * name varchar(128),
 * object_value BLOB,
 * primary key (id));
 **/

public class OGdbConnector { /*
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;

    public DataConnector() throws Exception {

        loadRestaurantsFromDB("restaurants");
    }

    public void testDataPopulation() throws Exception {
        for(int i = 0; i < 5; i++){
            uploadRestaurant(new Restaurant("Restaurant " + i), i+1);
        }
    }

    public RestaurantList loadRestaurantsFromDB(String ln) throws SQLException, IOException, ClassNotFoundException {

        Statement st = connection.createStatement();
        rs = st.executeQuery("SELECT * FROM foodsystem.java_objects");

        while(rs.next()){
            Restaurant r = (Restaurant) read(rs, "object_value");
            System.out.println(r);
            lo.add(r);
        }

        return lo;
    }

    public ResultSet uploadRestaurant(Restaurant restaurant, int rowIndex) throws Exception {
        ps = connection.prepareStatement("INSERT INTO foodsystem.java_objects(id, object_value) values (?, ?)", Statement.RETURN_GENERATED_KEYS);

        ps.setInt(1, rowIndex);

        ps.setBytes(2, toBlob(restaurant));

        ps.executeUpdate();

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM foodsystem.java_objects");
        return rs;
    }

    public byte[] toBlob(Restaurant obj)
            throws SQLException, IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oout = new ObjectOutputStream(baos);
        oout.writeObject(obj);
        oout.close();
        return baos.toByteArray();
    }

    private static Object read(ResultSet rs, String column) throws SQLException,
            IOException, ClassNotFoundException {

        byte[] buf = rs.getBytes(column);
        if (buf != null) {
            ObjectInputStream objectIn = new ObjectInputStream(
                    new ByteArrayInputStream(buf));
            return objectIn.readObject();
        }
        return null;
    } */
}
