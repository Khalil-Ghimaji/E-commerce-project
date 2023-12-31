package ShippingFeature;

public class InStorePickup implements Shipping {
    public double fees() {
        return 0;
    }

    public String toString() {
        return "In store pickup";
    }
}
