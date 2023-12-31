package Product.ProductsFeatures;

import Product.Product;

public class ProductWithDiscount extends Product implements Discount{
    private int discountRate;
    private double priceAfterDiscount;
    private Product product;

    public ProductWithDiscount(Product product, int discountRate) {
        super();
        this.product=product;
        this.discountRate = discountRate;
        this.priceAfterDiscount = applyDiscount(product.getPrice(), discountRate);
    }
    public String getId() {
        return product.getId();
    }

    public String getName() {
        return product.getName();
    }

    public ProductWithDiscount clone() {
        return new ProductWithDiscount(product.clone(),discountRate);
    }

    public double getPrice() {
        return priceAfterDiscount;
    }

    public String toString() {
        return (product.getId() + " " + product.getName() + ",original price:" + getOriginalPrice() + " TND (-"+discountRate+"%) = "+priceAfterDiscount+" TND");
    }

    public void setPrice(double price) {
        product.setPrice(price);
        priceAfterDiscount=applyDiscount(price,discountRate);
    }

    public void setDiscountRate(int discountRate) {
        this.discountRate = discountRate;
        priceAfterDiscount=applyDiscount(product.getPrice(), discountRate);
    }
    public double getOriginalPrice(){
        return product.getPrice();
    }

    public Product getOriginalProduct() {
        return product;
    }
}
