package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Accounts.Admin;
import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.Exams.Result;
import com.example.onlineexamwithgui.Exams.ResultRow;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.List;

public class ExamsPerformanceStudentController {

    @FXML
    private TableView<ResultRow> resultsTable;
    public Label score;
    public Label grade;
    @FXML
    private TableColumn<ResultRow, String> examTitle;
    @FXML
    private TableColumn<ResultRow, String> examCategory;
    @FXML
    private TableColumn<ResultRow, Integer> examScore;
    @FXML
    private TableColumn<ResultRow, String> examGrade;


    @FXML
    public void initialize(){
        resultsTable.setColumnResizePolicy(resizeFeatures -> false);

        examTitle.setCellValueFactory(data -> data.getValue().examTitleProperty());
        examCategory.setCellValueFactory(data -> data.getValue().examCategoryProperty());
        examScore.setCellValueFactory(data -> data.getValue().examScoreProperty().asObject());
        examGrade.setCellValueFactory(data -> data.getValue().examGradeProperty());
    }

    public void initializeStudent(int studentID){
        initializeResults(State.results.stream().filter(result -> result.getStudentId() == studentID).toList());

    }


    public void initializeResults (List<Result> results){
        float totalScores = 0;
        for(Result result :results){
            Exam exam = State.exams.stream().filter(exam1 -> exam1.getID() == result.getExamId()).toList().getFirst();
            resultsTable.getItems().add(new ResultRow(exam.getTitle() , exam.getCategory().getCategory() , (int)(result.getScore() * 100) , result.getGrade()));
            totalScores += result.getScore();
        }


        score.setText(totalScores / resultsTable.getItems().size() * 100 + "%");
        if(totalScores / resultsTable.getItems().size() > .8){
            grade.setText("A");
        }else if(totalScores / resultsTable.getItems().size() > .5){
            grade.setText("B");
        }else{
            grade.setText("F");
        }
    }

    public void onStudentOptions(ActionEvent actionEvent) {
        if(State.currentUser instanceof Admin){
            SceneController.changeScene(actionEvent, "AdminOptions.fxml");
        }else{
            SceneController.changeScene(actionEvent, "studentOptions.fxml");

        }
    }
}
