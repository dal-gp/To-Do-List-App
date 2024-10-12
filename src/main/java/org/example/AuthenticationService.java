package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class AuthenticationService implements IAuthenticationService{
    private ArrayList<User> users;

    public AuthenticationService() {
        this.users = new ArrayList<>();
        users.add(new User("test", "test"));
        users.add(new User("demo", "demo"));
    }

    @Override
    public User signUp(String username, String password) {
        Iterator<User> i = users.iterator();
        while(i.hasNext()){
            User user = i.next();
            if(user.getUsername().equals(username)){
                return null;
            }
        }
        User newUser = new User(username, password);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        Iterator<User> iterator = users.iterator();
        while(iterator.hasNext()) {
            User user = iterator.next();
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
