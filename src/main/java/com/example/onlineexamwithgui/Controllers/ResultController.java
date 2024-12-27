package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Exams.Result;
import com.example.onlineexamwithgui.HelloApplication;
import com.sun.tools.javac.Main;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ResultController {


    public ImageView image;
    public Label score;
    public Label grade;
    public Label message;

    public void initResult(Result result){
        score.setText(((int) (result.getScore() * 100)) + "%");
        grade.setText(String.valueOf(result.getGrade()));
        Image imageSrc;
        if(result.isPassed()) {
            message.setText("You Passed!");

            imageSrc = new Image(HelloApplication.class.getResourceAsStream("Success_Exam.png"));
        }else{
            imageSrc = new Image(HelloApplication.class.getResourceAsStream("failing.png"));
            message.setText("Better Luck Next Time");
        }
        image.setImage(imageSrc);

    }

    public void onStudentOption(ActionEvent actionEvent) {

        SceneController.changeScene(actionEvent , "studentOptions.fxml");
    }
}
