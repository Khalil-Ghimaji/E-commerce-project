package Product.productsCategories;

import Product.Product;

import java.util.ArrayList;

public class HomeAndFurniture extends Product {
    private static int identifier = 0;

    private static final ArrayList<HomeAndFurniture> list = new ArrayList<>();
    public HomeAndFurniture(Product product){
        super(product);
    }
    public HomeAndFurniture clone() {
        return new HomeAndFurniture(this);
    }
    public HomeAndFurniture(String name, double price) {
        super(name, price);
        identifier++;
        id = "HF" + identifier;
    }

}
