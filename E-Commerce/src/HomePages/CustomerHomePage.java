package HomePages;

import PaymentFeature.CashOnDeliveryPayment;
import PaymentFeature.CreditCardPayment;
import PaymentFeature.Payment;
import Product.Product;
import ShippingFeature.HomeDelivery;
import ShippingFeature.InStorePickup;
import ShippingFeature.Shipping;
import Users.Customer;
import associatedComponents.Inventory;
import associatedComponents.LoyaltyProgram;
import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerHomePage implements HomePage {
    private Scanner sc = new Scanner(System.in);
    private Customer customer;

    public CustomerHomePage(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void browseProducts() {
        System.out.println("1-Search product");
        System.out.println("2-Filter");
        System.out.println("3-Purchase");
        System.out.println("4-Home");
        System.out.println("Available products:");
        Inventory.displayProducts();
        System.out.print("Enter your choice: ");
        int operation = sc.nextInt();

        // Consume the newline character
        sc.nextLine();

        ArrayList<Product> products = null;
        switch (operation) {
            case 1:
                products = productSearch();
                break;
            case 2:
                products = productFilter();
                break;
            case 3:
                products = Inventory.getProducts();
                break;
            case 4:
                return;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                browseProducts();
                return;
        }
        if (products == null) {
        } else if (!products.isEmpty()) {
            purchase(products);
        } else {
            System.out.println("No products were found !");
        }
    }

    private void purchase(ArrayList<Product> products) {
        System.out.print("Enter the product's reference you want to purchase: ");
        String reference = sc.nextLine();
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(reference)) {
                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                customer.addItemToCart(product, quantity);
                System.out.println("Product added to cart sucessfully !");
                break;
            }
        }
    }
    public void homePage() {
        Shipping inStorePickup = new InStorePickup();
        Payment cashOnDelivery = new CashOnDeliveryPayment();
        while (true) {
            boolean isLoyal=LoyaltyProgram.getLoyaltyCards().containsKey(customer);
            System.out.println("Welcome to Our E-Commerce Store!");
            System.out.println("1-Browse Products");
            System.out.println("2-View Cart");
            System.out.println("3-Checkout");
            System.out.println("4-View order History");
            if (isLoyal){
                System.out.println("5-View loyalty card");
            }
            else{
                System.out.println("5-Join loyalty program");
            }
            System.out.println("6-Logout");
            System.out.println("7-Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // Consume the newline character
            sc.nextLine();

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    customer.displayShoppingCart();

                    System.out.println("1-update product");
                    System.out.println("2-remove product");
                    System.out.println("3-Go back");
                    System.out.print("Enter your choice: ");
                    int cartInput = sc.nextInt();

                    // Consume the newline character
                    sc.nextLine();

                    String reference;
                    switch (cartInput) {
                        case 1:
                            System.out.print("Enter the product's reference you want to update: ");
                            reference = sc.nextLine();
                            for (Product product : customer.getShoppingCart().getCartProducts()) {
                                if (product.getId().equalsIgnoreCase(reference)) {
                                    System.out.print("Quantity: ");
                                    int quantity = sc.nextInt();
                                    sc.nextLine(); // Consume the newline character
                                    customer.updateShoppingCart(product, quantity);
                                    System.out.println("Product updated sucessfully !");
                                    break;
                                }
                            }
                            break;
                        case 2:
                            System.out.print("Enter the product's reference you want to remove: ");
                            reference = sc.nextLine();
                            for (Product product : customer.getShoppingCart().getCartProducts()) {
                                if (product.getId().equalsIgnoreCase(reference)) {
                                    customer.removeItemFromShoppingCart(product);
                                    System.out.println("Product removed from cart sucessfully !");
                                    break;
                                }
                            }
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                            break;
                    }
                    break;
                case 3:
                    customer.displayShoppingCart();

                    Shipping shippingMethod;
                    System.out.println("Choose your shipping method");
                    System.out.println("1-Home delivery(7 TND)");
                    System.out.println("2-In store pickup");
                    System.out.println("3-Cancel");
                    System.out.print("Enter your choice: ");
                    int shippingInput = sc.nextInt();
                    sc.nextLine(); //consume the newline character

                    switch (shippingInput) {
                        case 1:
                            System.out.print("Enter your adress please:");
                            String adress = sc.nextLine();
                            shippingMethod = new HomeDelivery(adress);
                            break;
                        case 2:
                            shippingMethod = inStorePickup;
                            break;
                        default:
                            continue;
                    }

                    Payment paymentMethod;
                    System.out.println("Choose your mean of payment");
                    System.out.println("1-Credit card");
                    System.out.println("2-Cash on delivery");
                    System.out.println("3-Cancel");
                    System.out.print("Enter your choice: ");
                    int paymentInput = sc.nextInt();
                    sc.nextLine(); //consume the newline character

                    switch (paymentInput) {
                        case 1:
                            paymentMethod = new CreditCardPayment();
                            break;
                        case 2:
                            paymentMethod = cashOnDelivery;
                            break;
                        default:
                            continue;
                    }
                    if(isLoyal){
                        int points = (int)customer.getShoppingCart().totalPrice();
                        LoyaltyProgram.earnPoints(customer,points);
                        System.out.println(points+" points have been added to your loyalty card");
                    }
                    customer.checkout(shippingMethod, paymentMethod);
                    break;
                case 4:
                    System.out.println("Your orders:");
                    customer.displayOrderHistory();
                    break;
                case 5:
                    if(isLoyal){
                        System.out.println("you have "+LoyaltyProgram.getPoints(customer)+" points");
                        System.out.println("1-Convert to money (1 TND/100 points)");
                        System.out.println("2-Home");
                        System.out.print("Enter your choice: ");
                        int loyaltyInput = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        switch(loyaltyInput){
                            case 1:
                                CreditCardPayment creditCard= new CreditCardPayment();
                                LoyaltyProgram.getLoyaltyCards().put(customer,0);
                                System.out.println("Your points has been successfully converted ! "+(float)LoyaltyProgram.getPoints(customer)/100+" TND has been added to your "+creditCard.toString());
                                break;
                            case 2:
                                break;
                        }
                    }
                    else{
                        LoyaltyProgram.getLoyaltyCards().put(customer,0);
                        System.out.println("you have been successfully added to the loyalty program. 1 TND -> 1 point and 100 points -> 1 TND !");
                    }
                    break;
                case 6:
                    System.out.println("Logged out successfully !");
                    break;
                case 7:
                    System.out.println("Thank you for visiting. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                    break;
            }
            if (choice==6){
                break;
            }
            System.out.print("Press any button to continue:");
            sc.nextLine();
        }
    }
}
