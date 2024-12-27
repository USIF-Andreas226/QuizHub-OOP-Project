package com.example.onlineexamwithgui.Management;


import com.example.onlineexamwithgui.Accounts.*;

import java.util.Scanner;

public class Authorization {

    public static boolean signUp(String name, String email, String password){
        try {
            State.currentUser = new Student(name, email, password);
            State.accounts.add(State.currentUser);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public static String login(String email , String password){
        try {
            for (Account account : State.accounts){
                if(email.equals(account.getEmail()) && password.equals(account.getPassword())){
                    State.currentUser = account;
                    return "Success";
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return e.getMessage();
        }
        return "Wrong email or password!";
    }
}
