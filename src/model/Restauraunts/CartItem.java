package model.Restauraunts;

public class CartItem {
    private String itemName;
    private String itemDesc;
    private double unitPrice;
    private int quantity;

    public CartItem(String name, String desc, double price, int count){
        itemName = name;
        itemDesc = desc;
        unitPrice = price;
        quantity = count;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
