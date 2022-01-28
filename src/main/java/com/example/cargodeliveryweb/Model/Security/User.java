package com.example.cargodeliveryweb.Model.Security;

public class User {

    private int userId;
    private String email;
    private String role;
    private String password;

    public User(int userId, String email, String role, String password) {
        this.userId = userId;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public User(String email, String role, String password) {
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public int getUserId(){
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", password='" + password + '\'' +
                '}';
    }



}
