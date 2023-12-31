package Users;

import PaymentFeature.Payment;
import Product.Product;
import ShippingFeature.Shipping;
import associatedComponents.Inventory;
import associatedComponents.LoyaltyProgram;
import associatedComponents.Order;
import associatedComponents.ShoppingCart;

import java.util.ArrayList;
import java.util.Map;

public class Customer extends User {
    private ShoppingCart shoppingCart;
    private ArrayList<Order> orderHistory;

    public Customer(String username, String password) {
        super(username, password);
        this.shoppingCart = new ShoppingCart();
        this.orderHistory = new ArrayList<>();
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void displayShoppingCart() {
        System.out.println("Your cart contains:");
        System.out.println(shoppingCart.toString());
    }

    public void addItemToCart(Product product, int quantity) {
        shoppingCart.addItem(product, quantity);
    }

    public void updateShoppingCart(Product product, int newQuantity) {
        shoppingCart.updateItem(product, newQuantity);
    }

    public void removeItemFromShoppingCart(Product product) {
        shoppingCart.removeItem(product);
    }

    public void clearShoppingCart() {
        shoppingCart.clear();
    }

    public void displayOrderHistory() {
        for (Order order : orderHistory)
            System.out.println(order.toString());
    }

    public void checkout(Shipping shippingMethod, Payment paymentMethod) {
        ShoppingCart orderCart = new ShoppingCart();
        for (Map.Entry<Product, Integer> cartItem : shoppingCart.getCartItems().entrySet()) {
            Product product = cartItem.getKey();
            int quantity = cartItem.getValue();
            orderCart.addItem(product.clone(), quantity);
            Inventory.removeQuantity(product, quantity);
            Inventory.inventoryTracking(product);
        }
        Order order = new Order(orderCart, shippingMethod, paymentMethod);
        paymentMethod.processPayment(order.getTotalPrice());
        orderHistory.add(order);
        clearShoppingCart();
    }
}
