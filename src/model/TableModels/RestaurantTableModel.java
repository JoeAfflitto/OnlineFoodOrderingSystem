package model.TableModels;

import model.Objects.Restaurant;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class RestaurantTableModel extends AbstractTableModel {
    private String[] colNames;
    private ArrayList<Restaurant> restaurants;

    public RestaurantTableModel(ArrayList<Restaurant> rest){
        colNames = new String[]{"Name"};
        restaurants = rest;
    }

    @Override
    public int getRowCount() {
        return 2;
    }

    @Override
    public int getColumnCount() {
        return restaurants.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return (Object) restaurants.get(rowIndex).getName();
    }
}
