package com.example.myapplication.model;

public class UsersLogin {
    public String user;
    public String password;

    public UsersLogin(String usuario, String password) {
    this.user=usuario;
    this.password=password;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEmailValid() {
        return getUser().length()== 8;
    }


    public boolean isPasswordLengthGreaterThan5() {
        return getPassword().length() > 5;
    }
}
