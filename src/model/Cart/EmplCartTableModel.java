package model.Cart;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class EmplCartTableModel extends AbstractTableModel {
    ArrayList<Cart> carts;
    String[] colNames = {"Order Number", "Customer Name", "Item Count"};

    public EmplCartTableModel(ArrayList<Cart> toFulfill){
        this.carts = toFulfill;
    }

    @Override
    public int getRowCount() {
        return carts.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        Cart current = carts.get(rowIndex);
        switch (columnIndex){
            case 0:
                return Integer.toString(rowIndex);
            case 1:
                return current.getCartUser().getUsername();
            case 2:
                return Integer.toString(current.getItemCount());
        }
        return null;
    }

    @Override
    public String getColumnName(int index){
        return colNames[index];
    }
}
