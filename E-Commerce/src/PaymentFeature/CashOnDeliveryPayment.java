package PaymentFeature;

public class CashOnDeliveryPayment implements Payment {
    public String toString() {
        return "Cash on delivery";
    }

    public void processPayment(double amount) {
        System.out.println("Thank you for choosing Cash on Delivery. Your order with a total amount of " + amount + " TND will be delivered, and payment will be collected upon receipt.");
    }
}
