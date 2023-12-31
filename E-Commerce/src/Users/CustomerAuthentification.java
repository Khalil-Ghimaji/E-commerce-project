package Users;

import java.util.ArrayList;

public class CustomerAuthentification implements Authentification {
    private static ArrayList<Customer> list = new ArrayList<>();

    public static ArrayList<Customer> getList() {
        return list;
    }
    public boolean register(String username, String password) {
        for (Customer customer : list) {
            if (customer.username.equals(username)) {
                return false;
            }
        }
        list.add(new Customer(username, password));
        return true;
    }

    public Customer login(String username, String password) {
        for (Customer customer : list) {
            if (customer.username.equals(username) && customer.password.equals(password)) {
                return customer;
            }
        }
        return null;
    }
}
