package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class GourmetAndFood extends Product {
    private static int identifier = 0;

    private static final ArrayList<GourmetAndFood> list = new ArrayList<>();
    public GourmetAndFood(Product product){
        super(product);
    }
    public GourmetAndFood clone() {
        return new GourmetAndFood(this);
    }
    public GourmetAndFood(String name, double price) {
        super(name, price);
        identifier++;
        id = "GF" + identifier;
    }

}
