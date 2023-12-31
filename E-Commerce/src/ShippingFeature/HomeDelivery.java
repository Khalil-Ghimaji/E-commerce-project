package ShippingFeature;

public class HomeDelivery implements Shipping {
    private final String shippingAdress;

    public HomeDelivery(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public double fees() {
        return 7;
    }

    public String toString() {
        return "delivery to " + shippingAdress + ", delivery fees= 7 TND";
    }
}
