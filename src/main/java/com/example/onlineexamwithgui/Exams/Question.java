package com.example.onlineexamwithgui.Exams;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Question {
    private int ID;
    private String text;
    private ArrayList<String> options;
    private int correctAnswer;
    private int marks;


    public Question(int ID,String text, ArrayList<String> options, int correctAnswer, int marks) {
        this.ID = ID;
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }

    public Question(String text, ArrayList<String> options, int correctAnswer, int marks) {
        ID = new Random().nextInt(1000);
        this.text = text;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.marks = marks;
    }



    public static Question getQuestionFromUser(){
        Scanner scanner = new Scanner(System.in);
        String text;
        ArrayList<String> options = new ArrayList<>();
        int correctAnswer, marks;
        System.out.print("Enter Exams.Question Text: ");
        text = scanner.nextLine();
        System.out.print("Enter Exams.Question Marks: ");
        marks = scanner.nextInt();

        for (int j = 0; j < 4; j++) {
            System.out.print("Enter Option #" + j + ":");
            options.add(scanner.nextLine());
        }
        System.out.print("Enter Exams.Question Correct Answer Index: ");
        correctAnswer = scanner.nextInt();

        Question question = new Question(text, options, correctAnswer, marks);
        return question;
    }

    public static Question getQuestionFromUser(int i){
        Scanner scanner = new Scanner(System.in);
        String text;
        ArrayList<String> options = new ArrayList<>();
        int correctAnswer, marks;
        System.out.print("Enter Exams.Question #" + i + " Text: ");
        text = scanner.nextLine();

        for (int j = 0; j < 4; j++) {
            System.out.print("Enter Option #" + j + ": ");
            options.add(scanner.nextLine());
        }
        System.out.print("Enter Exams.Question #" + i + " Correct Answer Index: ");
        correctAnswer = scanner.nextInt();

        System.out.print("Enter Exams.Question #" + i + " Marks: ");
        marks = scanner.nextInt();

        Question question = new Question(text, options, correctAnswer, marks);
        return question;
    }

    @Override
    public String toString() {
        return ID + "," + text + ',' + options.get(0) + ',' + options.get(1) + ',' + options.get(2) + ',' + options.get(3) + ',' + String.valueOf(correctAnswer) + ',' + String.valueOf(marks);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }
}
