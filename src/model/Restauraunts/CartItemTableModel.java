package model.Restauraunts;

import model.Users.Product;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CartItemTableModel extends AbstractTableModel {
    private String[] colNames = {"Name", "Description", "Unit Price", "Quantity"};
    private ArrayList<CartItem> cartList;

    public CartItemTableModel(ArrayList<CartItem> selectionList){
        this.cartList = selectionList;
    }
    @Override
    public int getRowCount() {
        return cartList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        CartItem current = this.cartList.get(rowIndex);

       switch(columnIndex) {
           case 0:
               return current.getItemName();
           case 1:
               return current.getItemDesc();
           case 2:
               return Double.toString(current.getUnitPrice());
           case 3:
               return Integer.toString(current.getQuantity());
       }

       return null;
    }

    @Override
    public String getColumnName(int index){
        return colNames[index];
    }
}
