package com.example.onlineexamwithgui.Management;
import com.example.onlineexamwithgui.Accounts.*;
import com.example.onlineexamwithgui.Exams.*;


import java.util.ArrayList;

public class State {

    public static ArrayList<Account> accounts = new ArrayList<>();

    public static ArrayList<Exam> exams = new ArrayList<>();

    public static ArrayList<Result> results = new ArrayList<>();

    public static Account currentUser;


    public static void load(){
        ArrayList<String> adminsLines = FileHandler.readFile("admins.txt");
        ArrayList<String> studentsLines = FileHandler.readFile("students.txt");
        ArrayList<String> examsLines = FileHandler.readFile("exams.txt");
        ArrayList<String> resultsLines = FileHandler.readFile("results.txt");

        for(String adminLine: adminsLines){
            String[] s = adminLine.split(",");
            Admin admin = new Admin(Integer.parseInt(s[0]) , s[1] , s[2] , s[3]);
            accounts.add(admin);
        }
        for(String studentLine: studentsLines){
            String[] s = studentLine.split(",");
            Student student = new Student(Integer.parseInt(s[0]), s[1] , s[2] , s[3]);
            accounts.add(student);
        }

        for(String examLine: examsLines){
            String[] s = examLine.split(",");

            String examID = s[0];
            ArrayList<Question> examQuestions= new ArrayList<>();
            ArrayList<String> questionsLines = FileHandler.readFile("exam_" +examID+"_questions.txt");

            for(String questionLine: questionsLines){
                String[] s1 = questionLine.split(",");
                ArrayList<String> options = new ArrayList<>();
                options.add(s1[2]);
                options.add(s1[3]);
                options.add(s1[4]);
                options.add(s1[5]);
                Question question = new Question(Integer.parseInt(s1[0]), s1[1] ,options  , Integer.parseInt(s1[6]) , Integer.parseInt(s1[7]));
                examQuestions.add(question);
            }
            Exam exam = new Exam(Integer.parseInt(s[0]),s[1] ,new Category(s[2]) ,Integer.parseInt(s[3]) , Integer.parseInt(s[4]) , examQuestions);
            exams.add(exam);
        }

        for(String resultLine: resultsLines){
            String[] s = resultLine.split(",");
            Result result = new Result(Integer.parseInt(s[0]) ,Integer.parseInt(s[1]) , Float.parseFloat(s[2]) , s[3] , Boolean.parseBoolean(s[4]));
            results.add(result);
        }
    }

    public static void save(){
        ArrayList<String> adminsLines = new ArrayList<>();
        ArrayList<String> studentsLines = new ArrayList<>();
        ArrayList<String> examsLines = new ArrayList<>();
        ArrayList<String> resultsLines = new ArrayList<>();

        for(Account account : accounts){
            if(account instanceof Admin){
                adminsLines.add(account.toString());
            }
            else{
                studentsLines.add(account.toString());
            }
        }
        for (Exam exam : exams){
            examsLines.add(exam.toString());

            ArrayList<String> questionsLines = new ArrayList<>();
            for(Question question : exam.getQuestions()){
                questionsLines.add(question.toString());
            }
            FileHandler.writeFile("exam_"+exam.getID()+"_questions.txt" , questionsLines);

        }


        for(Result result : results){
            resultsLines.add(result.toString());
        }
        FileHandler.writeFile("exams.txt" , examsLines);

        FileHandler.writeFile("admins.txt" , adminsLines);
        FileHandler.writeFile("students.txt" , studentsLines);

        FileHandler.writeFile("results.txt" , resultsLines);

    }
}
