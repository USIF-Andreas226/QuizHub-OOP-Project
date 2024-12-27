package com.example.onlineexamwithgui.Exams;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Exam {

    private int ID;
    private String title;
    private Category category;
    private int duration;
    private int totalMarks;
    private List<Question> questions;


    public Exam(int ID, String title, Category category, int duration, int totalMarks, ArrayList<Question> questions) {
        this.ID = ID;
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.totalMarks = totalMarks;
        this.questions = questions;
    }

    public Exam(String title, Category category, int duration, int totalMarks, List<Question> questions) {
        ID = new Random().nextInt(1000);
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.totalMarks = totalMarks;
        this.questions = questions;
    }


    public void addQuestion(Question question){
        questions.add(question);
    }

    public void updateQuestion(int index, Question question){
        questions.set(index , question);
    }


    public Result returnResult(int studentID, List<Integer> selectedOptions){
        int resultMark = 0;
        for (int i = 0 ; i< questions.size() ; i++){
            if(selectedOptions.get(i) != null && questions.get(i).getCorrectAnswer() == selectedOptions.get(i))
                resultMark += questions.get(i).getMarks();
        }
        float score = (float) resultMark / totalMarks;
        String grade;
        if(score > 0.8)
            grade = "A";
        else if(score > .5)
            grade = "B";
        else
            grade = "F";
        Result result = new Result(ID , studentID , score , grade , score> 0.5f);

        return result;
    }


    @Override
    public String toString() {
        return ID + "," + title +',' + category.toString() + ',' + String.valueOf(duration) + ',' + String.valueOf(totalMarks);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(int totalMarks) {
        this.totalMarks = totalMarks;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
