package model.Objects;

public class Product {
    private String name;
    private double price;
    private String desc;

    public Product(String n, double p, String d){
        this.name = n;
        this.price = p;
        this.desc = d;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
