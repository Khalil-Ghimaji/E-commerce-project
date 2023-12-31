import HomePages.CustomerHomePage;
import HomePages.ManagerHomePage;
import Users.*;
import associatedComponents.Inventory;

import java.util.Scanner;

public class Main {
    private static Authentification roles[]={new CustomerAuthentification(), new ManagerAuthentification()};
    private static Scanner sc = new Scanner(System.in);
    private static User user;
    public static void main(String[] args) {
        new Inventory();

        int roleInput;
        while (true) {
            //login and register
            do {
                System.out.println("1-customer");
                System.out.println("2-Manager");
                System.out.println("3-exit");
                System.out.print("Enter your choice: ");
                roleInput = sc.nextInt();
                sc.nextLine(); // Consume the newline character
            } while (roleInput != 1 && roleInput != 2 && roleInput!=3);
            if (roleInput==3){
                System.out.println("Thanks for visiting !");
                System.exit(0);
            }
            Authentification role = roles[roleInput - 1];
            user = role.authentificate();
            //Home page
            if (user!=null) {
                switch (roleInput) {
                    case 1:
                        CustomerHomePage customerHomePage = new CustomerHomePage((Customer) user);
                        customerHomePage.homePage();
                        break;
                    case 2:
                        ManagerHomePage managerHomePage = new ManagerHomePage((Manager) user);
                        managerHomePage.homePage();
                        break;
                }
            }
        }
    }
}