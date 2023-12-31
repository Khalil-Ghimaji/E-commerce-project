package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class PetSupplies extends Product {
    private static int identifier = 0;

    private static final ArrayList<PetSupplies> list = new ArrayList<>();
    public PetSupplies(Product product){
        super(product);
    }
    public PetSupplies clone() {
        return new PetSupplies(this);
    }
    public PetSupplies(String name, double price) {
        super(name, price);
        identifier++;
        id = "PS" + identifier;
    }
}
