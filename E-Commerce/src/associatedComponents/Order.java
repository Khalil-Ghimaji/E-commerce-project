package associatedComponents;

import PaymentFeature.Payment;
import ShippingFeature.Shipping;

public class Order {
    private ShoppingCart products;
    private double totalPrice;
    private String shippingAddress;
    private Shipping shippingMethod;
    private Payment paymentMethod;

    public Order(ShoppingCart products, Shipping shippingMethod, Payment paymentMethod) {
        this.products = products;
        this.shippingMethod = shippingMethod;
        this.paymentMethod = paymentMethod;
        this.totalPrice = products.totalPrice() + shippingMethod.fees();
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String toString() {
        return "Order{" +
                "products=" + products.toString() +
                ", shippingMethod=" + shippingMethod.toString() +
                ", paymentMethod=" + paymentMethod.toString() +
                ", totalPrice=" + totalPrice +
                '}';
    }
    // Getters and setters
}
