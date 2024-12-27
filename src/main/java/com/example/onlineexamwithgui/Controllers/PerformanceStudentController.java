package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Accounts.Student;
import com.example.onlineexamwithgui.Exams.Exam;
import com.example.onlineexamwithgui.HelloApplication;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PerformanceStudentController {

    public Label errorPerformanceStudent;
    public TextField studentIDController;

    public void onShowPerformance(ActionEvent actionEvent) {

        if(!studentIDController.getText().isEmpty()){
            try {
                Student student = (Student) State.accounts.stream().filter(account -> account.getID() == Integer.parseInt(studentIDController.getText())).findFirst().get();
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("examsPerformanceStudent.fxml"));
                Parent root = loader.load();
                ((ExamsPerformanceStudentController) loader.getController()).initializeStudent(student.getID());
                stage.getScene().setRoot(root);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                errorPerformanceStudent.setText("No Student Found With That ID!");
            }
        }
        else{
            errorPerformanceStudent.setText("Please Enter Student ID!");
        }
    }

    public void onAdminOptions(ActionEvent actionEvent) {
        SceneController.changeScene(actionEvent, "AdminOptions.fxml");
    }
}
