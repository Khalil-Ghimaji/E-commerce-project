package Product;

import java.util.ArrayList;

public abstract class Product {
    protected static ArrayList<Product> list;
    protected String id;
    protected String name;
    protected double price;
    public Product(){}
    public Product(Product clone){
        this.name=clone.getName();
        this.price=clone.getPrice();
        this.id=clone.getId();
    }
    abstract public Product clone();
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        return (id + " " + name + ",unit price:" + price + " TND");
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
