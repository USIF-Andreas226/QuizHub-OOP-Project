package com.example.onlineexamwithgui.Controllers;

import com.example.onlineexamwithgui.Management.Authorization;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;

public class SignUpController {
    public TextField nameController;
    public TextField emailController;
    public TextField passwordController;
    public TextField passwordVisibleController;
    public CheckBox showPassword;

    public void onSignUp(ActionEvent actionEvent) {
        String password;
        if(showPassword.isSelected()){
            password = passwordVisibleController.getText();
        }else{
            password = passwordController.getText();
        }
        if(!nameController.getText().isEmpty() && !emailController.getText().isEmpty() && !password.isEmpty()) {
            if(Authorization.signUp(nameController.getText() , emailController.getText() , password)){
                SceneController.changeScene(actionEvent, "studentOptions.fxml");
            }
        }
    }

    public void onLogin(MouseEvent actionEvent) {
        SceneController.changeScene(actionEvent , "login.fxml");
    }

    public void showPassword(ActionEvent actionEvent) {
        if(showPassword.isSelected()){
            passwordVisibleController.setText(passwordController.getText());
            passwordVisibleController.setDisable(false);
            passwordVisibleController.setVisible(true);
            passwordController.setDisable(true);
            passwordController.setVisible(false);
        }else{
            passwordController.setText(passwordVisibleController.getText());
            passwordController.setDisable(false);
            passwordController.setVisible(true);
            passwordVisibleController.setDisable(true);
            passwordVisibleController.setVisible(false);
        }
    }
}
