package com.example.myapplication.model;

public class Login_Poo {
    public String email;
    public String paswword;

    public Login_Poo(String email, String paswword) {
        this.email = email;
        this.paswword = paswword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPaswword() {
        return paswword;
    }

    public void setPaswword(String paswword) {
        this.paswword = paswword;
    }
}
