/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekakhir;

import java.util.ArrayList;
import java.util.List;

public class userManager {
    private static userManager instance;
    
    private List<User> userList;

    public userManager() {
        this.userList = new ArrayList<>();
    }
    
    public static userManager getInstance() {
        if (instance == null) {
            synchronized (userManager.class) {
                if (instance == null) {
                    instance = new userManager();
                }
            }
        }
        return instance;
    }

    public boolean addUser(String username, String password) {
        if (findUserByUsername(username) != null) {
            return false; // User already exists
        }
        User newUser = new User(username, password);
        userList.add(newUser);
        return true;
    }

    public User findUserByUsername(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public boolean authenticateUser(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.checkPassword(password)) {
            return true;
        }
        return false;
    }

    public boolean removeUser(String username) {
        User userToRemove = findUserByUsername(username);
        if (userToRemove != null) {
            userList.remove(userToRemove);
            return true;
        }
        return false;
    }

    public List<User> getUserList() {
        return new ArrayList<>(userList); // Return a copy for encapsulation
    }
    
    public User getUserByUsername(String username) {
        return findUserByUsername(username);
    }
}
