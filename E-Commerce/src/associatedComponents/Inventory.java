package associatedComponents;

import Product.Product;
import Product.ProductsFeatures.ProductWithDiscount;
import Product.productsCategories.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private static Map<Product, Integer> stock = new HashMap<>();
    private static Map<Product, Integer> requiredStock = new HashMap<>();


    public Inventory() {
        BabyAndKids babyProduct = new BabyAndKids("Baby Product", 20.0);
        BeautyAndPersonalCare beautyProduct = new BeautyAndPersonalCare("Beauty Product", 15.0);
        JewelryAndAccessories jewelryProduct = new JewelryAndAccessories("Necklace", 50.0);
        GourmetAndFood foodProduct = new GourmetAndFood("Chocolate", 5.0);
        HomeAndFurniture furnitureProduct = new HomeAndFurniture("Chair", 100.0);
        HouseholdAppliances applianceProduct = new HouseholdAppliances("Blender", 70.0);
        PetSupplies petProduct = new PetSupplies("Dog Food", 15.0);
        Electronics electronicProduct = new Electronics("Laptop", 800.0);
        addProduct(babyProduct, 50);
        addProduct(beautyProduct, 30);
        addProduct(jewelryProduct, 15);
        addProduct(foodProduct, 100);
        addProduct(furnitureProduct, 20);
        addProduct(applianceProduct, 25);
        addProduct(petProduct, 40);
        addProduct(electronicProduct, 10);
    }
    public static void inventoryTracking(Product product){
        if (stock.get(product)<=requiredStock.get(product)*0.6) {
            stock.put(product,requiredStock.get(product));
        }
    }
    public static void addDiscount(Product product,int discountRate){
        int quantity=stock.get(product);
        ProductWithDiscount productWithDiscount = new ProductWithDiscount(product,discountRate);
        stock.remove(product);
        stock.put(productWithDiscount,discountRate);
        requiredStock.remove(product);
        requiredStock.put(productWithDiscount,discountRate);
    }
    public static void removeDiscount(ProductWithDiscount productWithDiscount) {
        int quantity=stock.get(productWithDiscount);
        stock.put(productWithDiscount.getOriginalProduct(),quantity);
        stock.remove(productWithDiscount);
    }
    public static void addProduct(Product product, int requiredQuantity) {
        stock.put(product, requiredQuantity);
        requiredStock.put(product, requiredQuantity);
    }

    public static void removeQuantity(Product product, int quantity) {
        stock.put(product, stock.get(product) - quantity);
    }

    public static void updateRequiredStock(Product product, int quantity) {
        requiredStock.put(product, quantity);
    }

    public static void removeItem(Product product) {
        stock.remove(product);
        requiredStock.remove(product);
    }

    public static void clear() {
        stock.clear();
    }

    public static Map<Product, Integer> getStock() {
        return stock;
    }

    public static void displayProducts() {
        for (Product product : stock.keySet()) {
            System.out.println(product.toString());
        }
    }
    public static ArrayList<ProductWithDiscount> getProductsWithDiscounts(){
        ArrayList<ProductWithDiscount> products=new ArrayList<>();
        for (Product product : stock.keySet()) {
            if (product instanceof ProductWithDiscount) {
                products.add((ProductWithDiscount) product);
            }
        }
        return products;
    }
    public static void displayProductsWithDiscounts(){
        for (Product product : getProductsWithDiscounts()) {
            System.out.println(product.toString());
        }
    }

    public static ArrayList<Product> getProducts() {
        return new ArrayList<>(stock.keySet());
    }

    public static ArrayList<Product> SearchName(String name) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : stock.keySet()) {
            if (product.getName().toLowerCase().contains(name.toLowerCase())) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public static ArrayList<Product> SearchId(String reference) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : stock.keySet()) {
            if (product.getId().toLowerCase().contains(reference.toLowerCase())) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public static ArrayList<Product> categoryFilter(Class<?> category) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : stock.keySet()) {
            if (category.isInstance(product)) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }

    public static ArrayList<Product> priceFilter(int minPrice, int maxPrice) {
        ArrayList<Product> searchedProducts = new ArrayList<>();
        for (Product product : stock.keySet()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                searchedProducts.add(product);
            }
        }
        return searchedProducts;
    }
}
