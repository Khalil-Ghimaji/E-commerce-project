package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class BeautyAndPersonalCare extends Product {
    private static int identifier = 0;
    private static final ArrayList<BeautyAndPersonalCare> list = new ArrayList<>();
    public BeautyAndPersonalCare(Product product){
        super(product);
    }
    public BeautyAndPersonalCare clone( ) {
        return new BeautyAndPersonalCare(this);
    }
    public BeautyAndPersonalCare(String name, double price) {
        super(name, price);
        identifier++;
        id = "BP" + identifier;
    }

}
