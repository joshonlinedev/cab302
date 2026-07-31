public class Main {
    public static void onSignUp() {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);

        if (user != null) {
            System.out.println("User " + username + " has been created successfully!");
        }
        else
            System.out.println("The username is already taken!");
        // TODO Now: Show a message based on the result of the signUp method:
        // - If the user is not null, show "User <username> has been created successfully!"
        // - If the user is null, show "The username is already taken!"
    }
}