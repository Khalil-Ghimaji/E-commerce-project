package associatedComponents;

import Users.User;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyProgram {
    private static Map<User, Integer> loyaltyCards = new HashMap<>();

    public static Map<User, Integer> getLoyaltyCards() {
        return loyaltyCards;
    }

    public static void earnPoints(User user, int points) {
        loyaltyCards.put(user, loyaltyCards.get(user) + points);
    }

    public static int getPoints(User user) {
        return loyaltyCards.get(user);
    }
}
