import java.util.ArrayList;
import java.util.List;

public class AuthService {
    private List<User> users = new ArrayList<>(); // In-memory storage

    public User register(String username, String password) {
        // Check if username already exists
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return null; // registration failed
            }
        }
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    public User logIn(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null; // invalid credentials
    }
}