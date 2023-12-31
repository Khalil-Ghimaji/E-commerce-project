package Users;

import java.util.ArrayList;

public class ManagerAuthentification implements Authentification {
    private ArrayList<Manager> list = new ArrayList();

    public ArrayList<Manager> getList() {
        return list;
    }

    public Manager login(String username, String password) {
        for (Manager manager : list) {
            if (manager.username.equals(username) && manager.password.equals(password)) {
                return manager;
            }
        }
        return null;
    }

    public boolean register(String username, String password) {
        for (Manager manager : list) {
            if (manager.username.equals(username)) {
                return false;
            }
        }
        list.add(new Manager(username, password));
        return true;
    }
}
