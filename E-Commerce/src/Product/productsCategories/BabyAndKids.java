package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class BabyAndKids extends Product {
    private static final ArrayList<BabyAndKids> list = new ArrayList<>();
    private static int identifier = 0;
    public BabyAndKids(Product product){
        super(product);
    }
    public BabyAndKids clone() {
        return new BabyAndKids(this);
    }
    public BabyAndKids(String name, double price) {
        super(name, price);
        identifier++;
        id = "BK" + identifier;
    }
}
