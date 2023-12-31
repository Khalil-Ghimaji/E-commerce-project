package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class HouseholdAppliances extends Product {
    private static int identifier = 0;

    private static final ArrayList<HouseholdAppliances> list = new ArrayList<>();
    public HouseholdAppliances(Product product){
        super(product);
    }
    public HouseholdAppliances clone() {
        return new HouseholdAppliances(this);
    }
    public HouseholdAppliances(String name, double price) {
        super(name, price);
        identifier++;
        id = "HA" + identifier;
    }

}
