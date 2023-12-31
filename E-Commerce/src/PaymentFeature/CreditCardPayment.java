package PaymentFeature;

import java.util.Scanner;

public class CreditCardPayment implements Payment {
    private String name;
    private String cardNumber;
    private String expirationDate;
    private int cvv;

    public CreditCardPayment() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        this.name = sc.nextLine();
        System.out.print("Card number: ");
        this.cardNumber = sc.nextLine();
        System.out.print("Expiration date: ");
        this.expirationDate = sc.nextLine();
        System.out.print("cvv: ");
        this.cvv = sc.nextInt();
        sc.nextLine(); // Consume the newline character
    }

    public String toString() {
        if (cardNumber.length() >= 4) {
            return "CreditCard{" + "cardNumber=" + cardNumber.substring(0, 2) + "*".repeat((cardNumber.length() - 4)) + cardNumber.substring(cardNumber.length() - 2) + "}";
        } else {
            return "CreditCard{" + "cardNumber=" + cardNumber + "}";
        }
    }
    public void processPayment(double amount) {
        System.out.println("Payment successful: " + amount + "TND received. Thank you for your payment by " + this + ".");
    }
}
