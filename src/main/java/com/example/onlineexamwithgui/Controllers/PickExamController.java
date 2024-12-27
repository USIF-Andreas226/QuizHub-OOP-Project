package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.HelloApplication;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PickExamController {

    public Label errorPickExam;
    @FXML
    private ChoiceBox<String> examChoice;

    List<String> examTitles ;

    @FXML
    public void initialize(){
        examTitles = State.exams.stream().map(Exam::getTitle).toList();
        String[] examTitlesArray = new String[examTitles.size()];
        examTitlesArray = examTitles.toArray(examTitlesArray);
        examChoice.getItems().addAll(examTitlesArray);
    }


    public void onSelectExam(ActionEvent actionEvent)throws IOException {

        try {
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("exam.fxml"));
            Parent root = loader.load();
            ((ExamController) loader.getController()).initializeExam(State.exams.get(examTitles.indexOf(examChoice.getValue())));
            stage.getScene().setRoot(root);
        } catch (Exception e) {
            errorPickExam.setText("No Exam Selected!");
        }
    }
}
