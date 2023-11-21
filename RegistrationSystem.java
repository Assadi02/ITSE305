import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RegistrationSystem {
    // List to store user information (each element is a String in the format "username:password")
    private List<String> userDatabase;

    public RegistrationSystem() {
        this.userDatabase = new ArrayList<>();
    }

    /**
     * Registers a new user with the provided username and password.
     * @param username The username of the new user.
     * @param password The password of the new user.
     * @return True if registration is successful, false if username already exists.
     */
    public boolean registerUser(String username, String password) {
        for (String user : userDatabase) {
            String[] userInfo = user.split(":");
            if (userInfo[0].equals(username)) {
                System.out.println("Username already exists. Please choose a different username.");
                return false;
            }
        }
        userDatabase.add(username + ":" + password);
        return true;
    }

    /**
     * Checks if a given username and password combination is valid.
     * @param username The username to be checked.
     * @param password The corresponding password.
     * @return True if the combination is valid, false otherwise.
     */
    public boolean validateUser(String username, String password) {
        for (String user : userDatabase) {
            String[] userInfo = user.split(":");
            if (userInfo[0].equals(username) && userInfo[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method for testing the RegistrationSystem class.
     */
    public static void main(String[] args) {

        
        RegistrationSystem registrationSystem = new RegistrationSystem();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome!");

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        boolean registrationSuccess = registrationSystem.registerUser(username, password);

        if (registrationSuccess) {
            boolean validationSuccess = registrationSystem.validateUser(username, password);

            if (validationSuccess) {
                System.out.println("You have successfully logged in.");
            } else {
                System.out.println("Login unsuccessful.");
            }
        } else {
            System.out.println("Registration failed. Please try again.");
        }

        scanner.close();
    }
}