package com.example.onlineexamwithgui.Accounts;



import com.example.onlineexamwithgui.Management.Case;

import java.util.Random;

public abstract class Account implements Case {

    private int ID;
    private String name;
    private String email;
    private String password;


    @Override
    public String toString() {
        return ID + "," + name + ',' + email + ',' + password;
    }

    public Account(String name, String email, String password) {
        Random random = new Random();
        ID = random.nextInt(1000);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Account(int ID, String name, String email, String password) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
