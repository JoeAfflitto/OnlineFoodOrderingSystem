package model.Restauraunts;

import javax.swing.table.AbstractTableModel;

public class InfoTableModel extends AbstractTableModel {
    private RestaurantData rd;
    private String[] colNames = {"Name", "..."};

    public InfoTableModel(){
        rd = new RestaurantData();
    }

    @Override
    public int getRowCount() {
        return rd.getTheRestaurantList().size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getValueAt(int rowIndex, int columnIndex) {
        switch (rowIndex) {
            case 0:
                rd.getTheRestaurantList().get(rowIndex).getBusinessName();
        }
        return null;
    }
}
