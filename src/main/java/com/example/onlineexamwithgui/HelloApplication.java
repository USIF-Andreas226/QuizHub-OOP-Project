package com.example.onlineexamwithgui;
import com.example.onlineexamwithgui.Management.State;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 700);
        stage.setTitle("Online Exam");
        stage.getIcons().add(new Image("file:exam_icon.jpg"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        State.load();
        launch();
        State.save();
    }
}