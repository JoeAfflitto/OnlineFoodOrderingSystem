package model.TableModels;

import model.Objects.Restaurant;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RestaurantTableModel extends AbstractTableModel {
    private ArrayList<Restaurant> restaurantList;
    private String[] colNames = {"Col 1"};

    public RestaurantTableModel(ArrayList<Restaurant> restaurantArrayList){
        this.restaurantList = restaurantArrayList;
    }

    @Override
    public int getRowCount() {
        return restaurantList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return restaurantList.get(rowIndex);
    }

    @Override
    public String getColumnName(int columnIndex){
        return colNames[columnIndex];
    }
}
