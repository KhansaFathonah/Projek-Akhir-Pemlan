/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.projekakhir;

public class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password; 
    }

    public String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password); 
    }

    public void changePassword(String newPassword) {
        if (newPassword == null || newPassword.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = newPassword;
    }
}

