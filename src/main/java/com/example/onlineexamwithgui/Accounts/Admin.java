package com.example.onlineexamwithgui.Accounts;
import com.example.onlineexamwithgui.Exams.*;

import com.example.onlineexamwithgui.Management.*;


import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends Account implements Case {


    public Admin(String name, String email, String password) {
        super(name, email, password);
    }


    public Admin(int ID,String name, String email, String password) {
        super(ID, name, email, password);
    }

    @Override
    public boolean useCase(int option) {
        Scanner scanner = new Scanner(System.in);
        switch (option) {
            case 0: return false;
            case 1:
                String title, category;
                int duration, questionsNumber;
                ArrayList<Question> examQuestions;
                System.out.print("Enter Exam Title: ");
                title = scanner.nextLine();
                System.out.print("Enter Exam Category: ");
                category = scanner.nextLine();
                System.out.print("Enter Exam Duration In Minutes: ");
                duration = scanner.nextInt();
                System.out.println("Enter Exam Questions Number: ");
                questionsNumber = scanner.nextInt();
                examQuestions = new ArrayList<>();
                for (int i = 0; i < questionsNumber; i++) {
                    Question question = Question.getQuestionFromUser(i);
                    examQuestions.add(question);
                }

                int totalMarks = 0;
                for (Question question : examQuestions) {
                    totalMarks += question.getMarks();
                }
                Exam exam = new Exam(title, new Category(category), duration, totalMarks, examQuestions);

                State.exams.add(exam);
                System.out.println("Exams.Exam Created Successfully!");
                break;
            case 2:
                System.out.println("Enter Exam ID: ");
                int examID = scanner.nextInt();
                Question question = Question.getQuestionFromUser();
                boolean questionAdded = false;
                for (Exam exam1 : State.exams){
                    if(exam1.getID() == examID){
                        exam1.addQuestion(question);
                        exam1.setTotalMarks(exam1.getTotalMarks() + question.getMarks());
                        questionAdded = true;
                    }
                }
                if(questionAdded)
                    System.out.println("Question Added");
                else
                    System.out.println("No Exam Found with that ID");
                break;
            case 3:
                System.out.print("Enter Exam ID: ");
                int examID1 = scanner.nextInt();
                System.out.print("Enter Question ID: ");
                int questionID = scanner.nextInt();
                Question question1 = Question.getQuestionFromUser();
                boolean questionUpdated = false;
                for (Exam exam1 : State.exams){
                    if(exam1.getID() == examID1){
                        for (int i = 0 ; i< exam1.getQuestions().size() ; i++){
                            if(exam1.getQuestions().get(i).getID() == questionID){
                                int marks = exam1.getQuestions().get(i).getMarks();
                                exam1.setTotalMarks(exam1.getTotalMarks() - marks);
                                exam1.updateQuestion(i , question1);
                                exam1.setTotalMarks(exam1.getTotalMarks() + question1.getMarks());
                                questionUpdated = true;
                            }
                        }
                    }
                }
                if(questionUpdated)
                    System.out.println("Question Updated");
                else
                    System.out.println("Didn't find question or the exam");
                break;

            case 4:
                System.out.print("Enter Student ID: ");
                int studentID = scanner.nextInt();
                for (Result result : State.results){
                    if(result.getStudentId() == studentID){
                        System.out.println(result);
                    }
                }
                break;

            case 5:
                System.out.print("Enter Exam ID: ");
                int examID2 = scanner.nextInt();
                ArrayList<Result> examResults = new ArrayList<>();
                for (Result result : State.results){
                    if(result.getExamId() == examID2){
                        examResults.add(result);
                    }
                }
                examResults.sort((o1, o2) -> (int) ((o1.getScore() - o2.getScore()) * 10000));
                if(examResults.size() < 3){
                    for (int i = examResults.size(); i>=0; i--) {
                        System.out.println(examResults.get(i));
                    }
                }
                else{
                    for (int i = 2 ; i >=0 ; i--){
                        System.out.println(examResults.get(i));
                    }
                }
                break;
        }
        return true;
    }
}
