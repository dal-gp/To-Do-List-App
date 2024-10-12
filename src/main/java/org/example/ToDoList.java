package org.example;

import java.util.Scanner;

public class ToDoList {
    private User user;
    private boolean isRunning;

    public ToDoList(User user) {
        this.user = user;
        isRunning = true;
        run();
    }
    public void run() {
        while(isRunning) {
            showMenu();
        }
    }

    private void showMenu() {
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

    private void handleMenu(int choice) {
        switch(choice) {
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
                System.out.println("Invalid Choice");
                showMenu();
        }
    }

    private void onShowAllItems() {
        // TODO
        int idx = 0;
        for(ToDoItem toDoItem : user.getToDoLists()){
            System.out.println((idx + 1) + ". " + (toDoItem.isDone() ? "[X]" : "[ ]") + toDoItem.getDescription());
            idx++;
        }
        System.out.println();
    }

    private void onAddItem() {
        System.out.print("Enter the description of the item:");
        Scanner scanner = new Scanner(System.in);
        String description = scanner.nextLine();
        ToDoItem toDoItem = new ToDoItem(description);
        user.getToDoLists().add(toDoItem);

    }

    private void onMarkAsDone() {
        /**
         * show items
         * ask which item to
         * store item idx
         * set the isDone to true for that item
         * show item
         */
        onShowAllItems();
        System.out.println("Which: ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        ToDoItem toDoItem = user.getToDoLists().get(choice);
        toDoItem.setDone(true);
        onShowAllItems();
    }

    private void onMarkAsUndone() {
        onShowAllItems();
        System.out.println("Which: ");
        Scanner scanner = new Scanner(System.in);

        int choice = scanner.nextInt();
        ToDoItem toDoItem = user.getToDoLists().get(choice);
        toDoItem.setDone(false);
        onShowAllItems();
    }

    private void onDeleteItem() {
        /**
         * show the list
         * ask which item to delete
         * store the iput
         * look for that item in the list
         * if found delete
         * show the list
         */
        onShowAllItems();
        System.out.print("Enter the number of the item to delete: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

            user.getToDoLists().remove(choice - 1);

        onShowAllItems();
    }
    private void onExit() {
        isRunning = false;
    }


}
