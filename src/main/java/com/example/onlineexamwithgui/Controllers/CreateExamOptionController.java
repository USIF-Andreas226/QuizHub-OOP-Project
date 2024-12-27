package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.HelloApplication;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateExamOptionController {
    public TextField title;
    public TextField category;
    public TextField duration;
    public TextField questionsNumber;
    public Label errorCreateExam;

    public void nextPageCreateQuestion(ActionEvent actionEvent)throws IOException {

        if(!title.getText().isEmpty() && !title.getText().isEmpty()&&
        !title.getText().isEmpty() && !title.getText().isEmpty()){
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("createQuestions.fxml"));
            Parent root = loader.load();
            ((CreateQuestionsController) loader.getController()).initExamsQuestions(title.getText() , category.getText() , Integer.parseInt(duration.getText()) , Integer.parseInt(questionsNumber.getText()));
            stage.getScene().setRoot(root);
        }
        else{
            errorCreateExam.setText("Please Enter Exam Information!");
        }
    }

    public void onAdminOptions(ActionEvent actionEvent) {
        SceneController.changeScene(actionEvent, "AdminOptions.fxml");
    }
}
