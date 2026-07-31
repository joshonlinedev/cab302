import java.util.Scanner;

public class ToDoList {
    private User user;
    private boolean isRunning;

    public ToDoList(User user) {
        this.user = user;
        this.isRunning = true;
    }

    private void showMenu() {
        System.out.println("\n--- To-Do List ---");
        System.out.println("1. Show all items");
        System.out.println("2. Add an item");
        System.out.println("3. Mark an item as done");
        System.out.println("4. Mark an item as undone");
        System.out.println("5. Delete an item");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }

    public void run() {
        while (isRunning) {
            showMenu();
        }
    }

    public void handleMenu(int choice) {
        switch (choice) {
            case 1:
                onShowAllItems();
                break;
            case 2:
                onAddItem();
                break;
            case 3:
                onMarkAsDone();
                break;
            case 4:
                onMarkAsUndone();
                break;
            case 5:
                onDeleteItem();
                break;
            case 6:
                onExit();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
                // No recursive call – the loop will show the menu again
        }
    }

    public void onShowAllItems() {
        var items = user.getToDoItems();
        if (items.isEmpty()) {
            System.out.println("Your to-do list is empty.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            ToDoItem item = items.get(i);
            String status = item.isDone() ? "[X]" : "[ ]";
            System.out.println(i + ". " + status + " " + item.getDescription());
        }
    }

    public void onAddItem() {
        System.out.print("Enter the description of the item: ");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        user.getToDoItems().add(new ToDoItem(description));
        System.out.println("Item added successfully.");
    }

    public void onMarkAsDone() {
        onShowAllItems();
        if (user.getToDoItems().isEmpty()) return;
        System.out.print("Enter the number of the item to mark as done: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (isValidIndex(itemNumber)) {
            user.getToDoItems().get(itemNumber).setDone(true);
            System.out.println("Item marked as done.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public void onMarkAsUndone() {
        onShowAllItems();
        if (user.getToDoItems().isEmpty()) return;
        System.out.print("Enter the number of the item to mark as undone: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (isValidIndex(itemNumber)) {
            user.getToDoItems().get(itemNumber).setDone(false);
            System.out.println("Item marked as undone.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public void onDeleteItem() {
        onShowAllItems();
        if (user.getToDoItems().isEmpty()) return;
        System.out.print("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int itemNumber = scanner.nextInt();
        if (isValidIndex(itemNumber)) {
            user.getToDoItems().remove(itemNumber);
            System.out.println("Item deleted.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public void onExit() {
        isRunning = false;
        System.out.println("Exiting to-do list.");
    }

    // Helper to check index bounds
    private boolean isValidIndex(int index) {
        return index >= 0 && index < user.getToDoItems().size();
    }
}