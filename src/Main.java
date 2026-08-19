import java.util.Scanner;

public class Main {
    private static final AuthService authService = new AuthService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the To-Do List App!");
        while (true) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            switch (choice) {
                case 1:
                    onRegister();
                    break;
                case 2:
                    onLogIn();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void onRegister() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = authService.register(username, password);
        if (user != null) {
            System.out.println("Registration successful! Welcome, " + user.getUsername() + "!");
        } else {
            System.out.println("Registration failed. Username may already exist.");
        }
    }

    public static void onLogIn() {
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if (user == null) {
            System.out.println("Invalid credentials.");
            return;
        }
        System.out.println("Welcome, " + user.getUsername() + "!");
        ToDoList toDoList = new ToDoList(user);
        toDoList.run();   // starts the interactive to-do list
        System.out.println("Returning to main menu.");
    }
}

//Test Commit for Aryan