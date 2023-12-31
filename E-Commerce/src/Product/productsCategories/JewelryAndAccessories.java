package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class JewelryAndAccessories extends Product {
    private static int identifier = 0;

    private static final ArrayList<JewelryAndAccessories> list = new ArrayList<>();
    public JewelryAndAccessories(Product product){
        super(product);
    }
    public JewelryAndAccessories clone() {
        return new JewelryAndAccessories(this);
    }
    public JewelryAndAccessories(String name, double price) {
        super(name, price);
        identifier++;
        id = "JA" + identifier;
    }
}
