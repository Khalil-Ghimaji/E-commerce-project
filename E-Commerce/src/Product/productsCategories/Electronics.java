package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class Electronics extends Product {
    private static int identifier = 0;

    private static final ArrayList<Electronics> list = new ArrayList<>();
    public Electronics(Product product){
        super(product);
    }
    public Electronics clone() {
        return new Electronics(this);
    }
    public Electronics(String name, double price) {
        super(name, price);
        identifier++;
        id = "EL" + identifier;
    }

}
