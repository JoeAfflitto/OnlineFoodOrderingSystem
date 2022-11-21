package model.Cart;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class CartDetailTableModel extends AbstractTableModel {
    private String[] colNames = {"Item Title", "Description", "Quantity"};
    private ArrayList<CartItem> cartList;

    public CartDetailTableModel(ArrayList<CartItem> selectionList){
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
               return Integer.toString(current.getQuantity());
       }

       return null;
    }

    @Override
    public String getColumnName(int index){
        return colNames[index];
    }
}
