package com.example.semana9;

public class User {
    
    private int UserID;
    private String Username;
    private String Email;
    private String Password;
    
    public User(int userID, String username, String email, String password) {
        UserID = userID;
        Username = username;
        Email = email;
        Password = password;
    }
    public User( String username, String email, String password) {
        Username = username;
        Email = email;
        Password = password;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    

}
