package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.HelloApplication;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {

    static void changeScene(Event actionEvent, String scene)  {
        try {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(HelloApplication.class.getResource(scene));
        stage.getScene().setRoot(root);
        }
        catch (IOException e){
            System.out.println("Couldn't change scene");
            System.out.println(e.getMessage());
        }
    }
}
