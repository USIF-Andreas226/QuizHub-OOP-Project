package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.HelloApplication;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class StudentOptionsController {
    public Label helloMessage;
    public ToggleGroup StudentOption;
    public Label errorStudentOption;

    @FXML
    public void initialize() {
        helloMessage.setText("Hello! "+ State.currentUser.getName());
    }


    public void onLogout(ActionEvent actionEvent) {

        State.currentUser = null;

        SceneController.changeScene(actionEvent , "login.fxml");
    }
    public void nextPage(ActionEvent actionEvent) throws IOException {

        try {
            String id = ((RadioButton) StudentOption.getSelectedToggle()).getId();
            if (id.equals("pick")) {
                SceneController.changeScene(actionEvent, "pickExam.fxml");
            } else if (id.equals("performance")) {
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("examsPerformanceStudent.fxml"));
                Parent root = loader.load();
                ((ExamsPerformanceStudentController) loader.getController()).initializeStudent(State.currentUser.getID());
                stage.getScene().setRoot(root);
            }
        }catch (Exception e){
            errorStudentOption.setText("No Option Selected!");
        }
    }

}
