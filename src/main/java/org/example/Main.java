package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<User> users = new ArrayList<User>();

    private static IAuthenticationService authService = new IAuthenticationService() {

        @Override
        public User signUp(String username, String password) {
            return null;
        }

        @Override
        public User logIn(String username, String password) {
            return users.get(0);
        }
    };

    private static boolean isRunning = true;

    public static void main(String[] args) {
        users.add(new User("test", "test"));
        while(isRunning) {
            showMenu();
        }
    }
    public static void showMenu() {
        System.out.println("Welcome to the To-Do List Application");
        System.out.println("1. Log on");
        System.out.println("2. Sign up");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        handleMenu(choice);
    }
    public static void handleMenu(int choice) {
        switch (choice){
            case 1:
                onLogIn();
                break;
            case 2:
                onSignUp();
                break;
            case 3:
                onExit();
                break;
            default:
                System.out.println("Invalid choice!");
                showMenu();
        }
    }
    public static void onLogIn() {
        System.out.print("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.logIn(username, password);
        if(user != null){
            System.out.println("Welcome, " + user.getUsername() + "!");
            ToDoList toDoList = new ToDoList(user);
            toDoList.run();
        } else {
            System.out.println("Something went wrong!");
        }

    }

    public static void onSignUp() {
        System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        User user = authService.signUp(username, password);
        if(user != null) {
            System.out.println("Successfully signed-up!");
        }
    }

    public static void onExit() {
        isRunning = false;
    }
}