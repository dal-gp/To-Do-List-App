package org.example;

import java.util.ArrayList;

public class User
{
    private String username;
    private String password;
    private ArrayList<ToDoItem> toDoLists;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        toDoLists = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<ToDoItem> getToDoLists() {
        return toDoLists;
    }
}
