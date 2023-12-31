package HomePages;

import Product.Product;
import Product.productsCategories.*;
import associatedComponents.Inventory;

import java.util.ArrayList;
import java.util.Scanner;

public interface HomePage {
    void homePage();
    void browseProducts();
    default public ArrayList<Product> productSearch() {
        Scanner sc=new Scanner(System.in);
        System.out.println("1-Search by name");
        System.out.println("2-Search by reference");
        System.out.println("3-Go back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Consume the newline character
        sc.nextLine();

        ArrayList<Product> products = new ArrayList<>();
        switch (choice) {
            case 1:
                System.out.print("Enter your product's name:");
                String name = sc.nextLine();
                products = Inventory.SearchName(name);
                for (Product product : products) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                System.out.print("Enter your product's reference:");
                String reference = sc.nextLine();
                products = Inventory.SearchId(reference);
                for (Product product : products) {
                    System.out.println(product.toString());
                }
                break;
            case 3:
                browseProducts();
                return null;
        }
        return products;
    }
    public default ArrayList<Product> productFilter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1-Filter by category");
        System.out.println("2-Filter by price");
        System.out.println("3-Go back");
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();

        // Consume the newline character
        sc.nextLine();

        ArrayList<Product> products = new ArrayList<>();
        switch (choice) {
            case 1:
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
                int categoryNumber = sc.nextInt();

                // Consume the newline character
                sc.nextLine();

                products = Inventory.categoryFilter(categories[categoryNumber - 1]);
                for (Product product : products) {
                    System.out.println(product.toString());
                }
                break;
            case 2:
                System.out.print("Enter the min price:");
                int minPrice = sc.nextInt();
                System.out.print("Enter the max price:");
                int maxPrice = sc.nextInt();

                // Consume the newline character
                sc.nextLine();

                products = Inventory.priceFilter(minPrice, maxPrice);
                for (Product product : products) {
                    System.out.println(product.toString());
                }
                break;
            case 3:
                browseProducts();
                return null;

        }
        return products;
    }
}
