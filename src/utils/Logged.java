package utils;

import model.User;

public class Logged {
    private static volatile User user = null;

    public static void login(User newUser) {
        user = newUser; // Assign the new user to the static field
    }

    public static void logout() {
        user = null; // Clear the logged-in user
    }

    public static User getLoggedUser() {
        return user; // Return the current logged-in user
    }
}
