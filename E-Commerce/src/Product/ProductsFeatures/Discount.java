package Product.ProductsFeatures;

public interface Discount {
    default double applyDiscount(double price,int discounRate){
        return price*(100-discounRate)/100;
    }
}
