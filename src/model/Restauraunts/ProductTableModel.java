package model.Restauraunts;

import model.Users.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ProductTableModel extends AbstractTableModel {
    ArrayList<Product> loadedProductList;
    String[] colNames = {"Name", "Description", "Price"};

    public ProductTableModel(Restaurant rest){
        loadedProductList = rest.getTheProductList();
    }

    @Override
    public int getRowCount() {
        return loadedProductList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product current = loadedProductList.get(rowIndex);
        switch(columnIndex){
            case 0: return current.getName();
            case 1: return current.getDesc();
            case 2: return current.getPrice();
        }
        return null;
    }

    @Override
    public String getColumnName(int colIndex){
        return colNames[colIndex];
    }
}
