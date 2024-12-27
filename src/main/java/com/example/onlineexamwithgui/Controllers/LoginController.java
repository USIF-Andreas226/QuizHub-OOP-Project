package com.example.onlineexamwithgui.Controllers;
import com.example.onlineexamwithgui.Accounts.Admin;
import com.example.onlineexamwithgui.Management.Authorization;
import com.example.onlineexamwithgui.Management.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {
    public TextField emailController;
    public TextField passwordController;
    public TextField passwordVisibleController;
    public CheckBox showPassword;
    @FXML
    private Label error;
    public void onLogin(ActionEvent actionEvent) {
        String password;
        if(showPassword.isSelected()){
            password = passwordVisibleController.getText();
        }else{
            password = passwordController.getText();
        }
        if(!emailController.getText().isEmpty() && !password.isEmpty()) {
            String login = Authorization.login(emailController.getText(),password);
            if (login.equals("Success")) {

                if (State.currentUser instanceof Admin) {
                    SceneController.changeScene(actionEvent, "AdminOptions.fxml");
                } else {
                    SceneController.changeScene(actionEvent, "studentOptions.fxml");
                }
            }
            else{
                error.setText(login);
            }
        }
    }
    public void onSignUp(MouseEvent actionEvent) {
        SceneController.changeScene(actionEvent, "signUp.fxml");
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
