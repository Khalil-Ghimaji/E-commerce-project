package associatedComponents;

import Product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> cartItems;

    public ShoppingCart() {
        cartItems = new HashMap<>();
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<Product, Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public void addItem(Product product, int quantity) {
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    public void updateItem(Product product, int newQuantity) {
        cartItems.put(product, newQuantity);
    }

    public void removeItem(Product product) {
        cartItems.remove(product);
    }

    public void clear() {
        cartItems.clear();
    }

    public double totalPrice() {
        double totalPrice = 0;
        for (Map.Entry<Product, Integer> cartItem : cartItems.entrySet()) {
            Product product = cartItem.getKey();
            Integer quantity = cartItem.getValue();
            totalPrice += product.getPrice() * quantity;
        }
        return totalPrice;
    }

    public String toString() {
        String items = "";
        for (Map.Entry<Product, Integer> item : cartItems.entrySet()) {
            Product product = item.getKey();
            Integer quantity = item.getValue();
            items += (product.toString() + ", quantity:" + quantity + ", price:" + quantity * product.getPrice() + '\n');
        }
        items += "Total price:" + this.totalPrice() + " TND";
        return items;
    }

    public ArrayList<Product> getCartProducts() {
        return new ArrayList<>(cartItems.keySet());
    }
}
