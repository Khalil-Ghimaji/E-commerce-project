package HomePages;

import Product.Product;
import Product.ProductsFeatures.ProductWithDiscount;
import Product.productsCategories.*;
import Users.Customer;
import Users.CustomerAuthentification;
import Users.Manager;
import associatedComponents.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public class ManagerHomePage implements HomePage {
    private Scanner sc = new Scanner(System.in);
    private Manager manager;

    public ManagerHomePage(Manager manager) {
        this.manager = manager;
    }

    public void homePage() {
        while (true) {
            System.out.println("Welcome to Your E-Commerce Store!");
            System.out.println("1-Browse Products");
            System.out.println("2-view products with discount");
            System.out.println("3-View selling history");
            System.out.println("4-Logout");
            System.out.println("5-Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            // Consume the newline character
            sc.nextLine();

            switch (choice) {
                case 1:
                    browseProducts();
                    break;
                case 2:
                    viewDiscounts();
                    break;
                case 3:
                    for(Customer customer: CustomerAuthentification.getList()){
                        customer.displayOrderHistory();
                    }
                    break;
                case 4:
                    System.out.println("Logged out successfully !");
                    break;
                case 5:
                    System.out.println("Thank you for visiting. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }
            if (choice==4){
                break;
            }
            System.out.print("Press any button to continue:");
            sc.nextLine();
        }
    }


    private void viewDiscounts() {
        if(Inventory.getProductsWithDiscounts().isEmpty()){
            System.out.println("No products with discount were found");
            return;
        }
        Inventory.displayProductsWithDiscounts();
        System.out.println("1-Edit/remove discount");
        System.out.println("2-Go back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        switch(choice){
            case 1:
                editDiscount();
                break;
            case 2:
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                viewDiscounts();
                break;
        }
    }

    public void browseProducts() {
        System.out.println("1-Search product");
        System.out.println("2-Filter");
        System.out.println("3-edit product");
        System.out.println("4-Add new product");
        System.out.println("5-Add discount");
        System.out.println("6-Home");
        System.out.println("Available products:");
        Inventory.displayProducts();
        System.out.print("Enter your choice: ");
        int operation = sc.nextInt();
        sc.nextLine(); // Consume the newline character
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
                edit(products);
                break;
            case 4:
                addProduct();
                break;
            case 5:
                products = Inventory.getProducts();
                addDiscount(products);
                break;
            case 6:
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                browseProducts();
                break;
        }
        if(products==null){}
        else if (products.isEmpty()) {
            System.out.println("No products were found.");
        }
        else if (operation==1 || operation==2) {
            System.out.println("1-edit product");
            System.out.println("2-Add discount");
            System.out.println("3-Cancel");
            System.out.print("Enter your choice: ");
            int editOrDiscountInput = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            switch (editOrDiscountInput){
                case 1:
                    edit(products);
                    break;
                case 2:
                    addDiscount(products);
                    break;
                case 3:
                    browseProducts();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    browseProducts();
                    break;
            }
        }
    }

    private void addDiscount(ArrayList<Product> products) {
        System.out.print("Enter the product's reference : ");
        String reference = sc.nextLine();
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(reference)) {
                System.out.print("Enter the discount rate (%): ");
                int discountRate = sc.nextInt();
                sc.nextLine(); //consume the newline character
                Inventory.addDiscount(product, discountRate);
                System.out.println("Discount added successfully.");
                break;
            }
        }
    }

    private void addProduct() {
        Class<?>[] categories = {BabyAndKids.class,
                BeautyAndPersonalCare.class,
                JewelryAndAccessories.class,
                GourmetAndFood.class,
                HomeAndFurniture.class,
                HouseholdAppliances.class,
                PetSupplies.class,
                Electronics.class
        };
        System.out.println("1-Baby and kids");
        System.out.println("2-Beauty and personal care");
        System.out.println("3-Jewelry and accessories");
        System.out.println("4-Gourmet and food");
        System.out.println("5-Home and Furniture");
        System.out.println("6-Household appliances");
        System.out.println("7-Pet supplies");
        System.out.println("8-Electronics");

        System.out.print("Enter the product's category (1 to 8)");
        int categoryNumber = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter the product's name: ");
        String name = sc.nextLine();
        System.out.print("Enter the product's price: ");
        Double price = sc.nextDouble();
        sc.nextLine(); // Consume the newline character
        System.out.print("Enter the product's required quantity: ");
        int requiredQuantity = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        try {
            Inventory.addProduct((Product)categories[categoryNumber - 1].getDeclaredConstructor(String.class, double.class).newInstance(name, price), requiredQuantity);
            System.out.println("Product added successfully.");
        }
        catch(Exception e){
            System.out.println("Invalid category number.");
        }
    }
    private void edit(ArrayList<Product> products) {
        System.out.print("Enter the product's reference you want to edit: ");
        String reference = sc.nextLine();
        for (Product product : products) {
            if (product.getId().equalsIgnoreCase(reference)) {
                System.out.println(product);
                System.out.println("1-Edit price");
                System.out.println("2-Edit required stock");
                System.out.println("3-Remove product");
                System.out.println("4-Go back");
                System.out.print("Enter your choice: ");
                int editInput=sc.nextInt();
                sc.nextLine(); // Consume the newline character
                switch (editInput){
                    case 1:
                        System.out.print("Enter the new price: ");
                        double newPrice = sc.nextDouble();
                        sc.nextLine(); // Consume the newline character
                        product.setPrice(newPrice);
                        System.out.println("Price updated successfully.");
                        break;
                    case 2:
                        System.out.print("Enter the new required stock: ");
                        int newRequiredQuantity=sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        Inventory.updateRequiredStock(product,newRequiredQuantity);
                        Inventory.inventoryTracking(product);
                        System.out.println("Required Stock updated successfully.");
                        break;
                    case 3:
                        Inventory.removeItem(product);
                        System.out.println("Item removed successfully.");
                        break;
                    case 4:
                        browseProducts();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                        edit(products);
                        return;
                }
                break;
            }
        }
    }
    private void editDiscount(){
        System.out.print("Enter the product's reference: ");
        String reference = sc.nextLine();
        for (ProductWithDiscount product : Inventory.getProductsWithDiscounts()) {
            if (product.getId().equalsIgnoreCase(reference)) {
                System.out.println(product);
                System.out.println("1-Edit discount Rate");
                System.out.println("2-Remove discount");
                System.out.println("3-Cancel");
                System.out.print("Enter your choice: ");
                int editInput = sc.nextInt();
                sc.nextLine(); // Consume the newline character
                switch (editInput) {
                    case 1:
                        System.out.print("Enter the new discount rate (%): ");
                        int newDiscountRate = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        product.setDiscountRate(newDiscountRate);
                        System.out.println("Discount updated successfully.");
                        break;
                    case 2:
                        Inventory.removeDiscount(product);
                        System.out.println("Discount removed successfully.");
                        break;
                    case 3:
                        viewDiscounts();
                        break;
                }
            }
        }
    }
}
