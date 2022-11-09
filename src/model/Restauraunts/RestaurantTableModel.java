package model.Restauraunts;

import model.Restauraunts.Restaurant;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RestaurantTableModel extends AbstractTableModel {
    private ArrayList<Restaurant> restaurantList;
    private String[] colNames = {"Restaurant Name"};

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
    public String getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return restaurantList.get(rowIndex).getBusinessName();
        }
        return null;
    }

    @Override
    public String getColumnName(int columnIndex){
        return colNames[columnIndex];
    }
}
