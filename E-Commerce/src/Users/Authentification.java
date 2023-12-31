package Users;

import java.util.Scanner;

public interface Authentification {
    default public User login(){
        User user=null;
        Scanner sc=new Scanner(System.in);
        String username, password;
        for(int i=0;i<3;i++){
            System.out.print("username :");
            username = sc.nextLine();
            System.out.print("password :");
            password = sc.nextLine();
            user=this.login(username,password);
            if(user!=null) {
                break;
            }
            else {
                System.out.println("Wrong username or password. You have "+(2-i)+" attempt(s) remaining");
            }
        }
        return user;
    }
    default public void register(){
        String username, password;
        Scanner sc=new Scanner(System.in);
        boolean success;
        do {
            System.out.print("username :");
            username = sc.nextLine();
            System.out.print("password :");
            password = sc.nextLine();
            success=this.register(username,password);
        } while (!success);
    }
    default public User authentificate(){
        Scanner sc=new Scanner(System.in);
        User user = null;
        System.out.println("1-Login");
        System.out.println("2-Register");
        System.out.println("3-Go back");
        System.out.print("Enter your choice: ");
        int input = sc.nextInt();

        // Consume the newline character
        sc.nextLine();

        switch (input){
            case 1:
                user = login();
                break;
            case 2:
                register();
                System.out.println("You have been successfully registered. You can login now");
                user = authentificate();
                break;
            case 3:
                break;
            default:
                System.out.println("Invalid choice. Please enter a number between 1 and 3.");
                user = authentificate();
                break;
        }
        return user;
    }
    User login(String username, String password);

    boolean register(String username, String password);
}
