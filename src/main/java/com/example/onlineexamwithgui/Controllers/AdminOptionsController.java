package com.example.onlineexamwithgui.Controllers;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class AdminOptionsController {

    public Label helloMessage;
    public ToggleGroup AdminOption;
    public Label errorAdminOption;

    @FXML
    public void initialize(){
        helloMessage.setText("Hello! " + State.currentUser.getName());
    }


    public void onLogout(ActionEvent actionEvent) {

        State.currentUser = null;

        SceneController.changeScene(actionEvent , "login.fxml");
    }


    public void nextPage(ActionEvent actionEvent) {

       try {
           String id = ((RadioButton) AdminOption.getSelectedToggle()).getId();
           switch (id) {
               case "create":
                   SceneController.changeScene(actionEvent, "createExam.fxml");
                   break;
               case "add":
                   SceneController.changeScene(actionEvent, "addQuestion.fxml");
                   break;
               case "edit":
                   SceneController.changeScene(actionEvent, "editQuestion.fxml");
                   break;
               case "studentPerformance":
                   SceneController.changeScene(actionEvent, "performanceStudent.fxml");
                   break;
               case "topStudentsPerformance":
                   SceneController.changeScene(actionEvent, "performanceExamID.fxml");
                   break;
           }
       }catch (Exception _){
           errorAdminOption.setText("No Option Selected!");
       }
    }
}
