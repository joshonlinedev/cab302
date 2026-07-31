To-Do List Console Application

A console-based Java application for managing personal to-do lists, featuring user authentication and full CRUD (Create, Read, Update, Delete) operations on list items. Built collaboratively using Git's feature branch workflow.

FEATURES

- User Authentication — Sign up and log in to access your personal to-do list
- Create — Add new to-do items
- Read — View all items in your to-do list
- Update — Mark items as complete/incomplete
- Delete — Remove items from your list
- Per-user item storage, so each account keeps its own separate list

PROJECT STRUCTURE

src/
  Main.java                  - Entry point; displays menu and handles login/signup flow
  User.java                  - Represents a user (username, password, to-do items)
  ToDoItem.java               - Represents a single to-do item (description, status)
  ToDoList.java               - Manages the collection of a user's to-do items
  IAuthenticationService.java - Interface defining authentication methods (login/signup)

GETTING STARTED

Prerequisites:
- Java Development Kit (JDK) installed
- IntelliJ IDEA (recommended) or another Java IDE

Running the Application:
1. Clone the repository: git clone <your-repository-url>
2. Open the project in IntelliJ IDEA (or your preferred IDE)
3. Run Main.java
4. Use the menu to sign up for a new account or log in with an existing one
   - A default test account is available - username: test, password: test

USAGE

Once logged in, you'll be presented with options to:
- View your current to-do list
- Add a new item
- Mark an item as complete
- Delete an item
- Log out / exit
