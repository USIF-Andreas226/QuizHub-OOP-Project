package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Accounts.Account;
import com.example.onlineexamwithgui.Accounts.Student;
import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.Exams.Result;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.Optional;

public class TopThreeStudentsController {

    public Label firstStudent;
    public Label secondStudent;
    public Label thirdStudent;
    public Label scoreFirstStudent;
    public Label scoreSecondStudent;
    public Label scoreThirdStudent;


    Label[] nameLabels;
    Label[] scoreLabels;


    public void initializeExam(Exam exam){
        nameLabels = new Label[]{firstStudent, secondStudent,thirdStudent };
        scoreLabels = new Label[]{scoreFirstStudent, scoreSecondStudent,scoreThirdStudent };
        ArrayList<Result> examResults = new ArrayList<>();
        for (Result result : State.results){
            if(result.getExamId() == exam.getID()){
                examResults.add(result);
            }
        }
        examResults.sort((o1, o2) -> (int) ((o1.getScore() - o2.getScore()) * 10000));
        int length = 3;
        if(examResults.size() < 3) length = examResults.size();
        for(int i = 0; i< length ; i++){
            int finalI = i;
            Optional<Account> student = State.accounts.stream().filter(account -> account.getID() == examResults.get(finalI).getStudentId()).findFirst();
            if(student.isPresent()){
                nameLabels[i].setText(student.get().getName());
                scoreLabels[i].setText((int) examResults.get(i).getScore() * 100 + "%");
            }
        }
    }


    public void onAdminOptions(ActionEvent actionEvent) {
        SceneController.changeScene(actionEvent, "AdminOptions.fxml");
    }
}
