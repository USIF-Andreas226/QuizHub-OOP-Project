package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class HelloController {


    public void onSignUp(ActionEvent actionEvent) {
        SceneController.changeScene(actionEvent , "signUp.fxml");

    }


    public void onLogin(ActionEvent actionEvent) {
        SceneController.changeScene(actionEvent , "login.fxml");
    }
}