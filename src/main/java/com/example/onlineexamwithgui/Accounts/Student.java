package com.example.onlineexamwithgui.Accounts;

import com.example.onlineexamwithgui.Exams.*;
import com.example.onlineexamwithgui.Management.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Student extends Account implements Case {

    private ArrayList<Result> results;

    public Student(String name, String email, String password) {
        super(name, email, password);
    }

    public Student(int ID,String name, String email, String password) {
        super(ID, name, email, password);
    }


    public ArrayList<Result> getResults() {
        return results;
    }

    public void setResults(ArrayList<Result> results) {
        this.results = results;
    }

    @Override
    public boolean useCase(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option){
            case 0: return false;
            case 1:
                System.out.println("Pick an exam");
                for (int i = 0; i< State.exams.size() ; i++){
                    System.out.println(i + ": " + State.exams.get(i).getTitle());
                }
                int examIndex = scanner.nextInt();
                if(examIndex < State.exams.size() && examIndex >= 0){
//                    Result result =  State.exams.get(examIndex).takeExam(State.currentUser.getID());
//                    State.results.add(result);
                }else {
                    System.out.println("Enter a valid number");
                }
                break;

            case 2:
                for (Result result : State.results){
                    if(result.getStudentId() == State.currentUser.getID()){
                        System.out.println(result);
                    }
                }
                break;
        }
        return true;
    }
}
