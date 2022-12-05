package com.lsb.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.lsb.api.Auth;
import com.lsb.util.Loader;

public class LoginController {
    @FXML
    TextField idInput;

    @FXML
    PasswordField passwordInput;

    @FXML
    Label stateLabel;
    
    @FXML
    Button loginButton;
    
    @FXML
    Button registerButton;

    @FXML
    private void Login(ActionEvent e) throws IOException {
        String id = idInput.getText();
        String password = passwordInput.getText();

        try {
            Auth.Login(id, password);
            Scene scene = new Scene(Loader.loadFXML("main"));
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage currentStage = (Stage) loginButton.getScene().getWindow();
            currentStage.close();
        }
        catch (Exception err) {
            stateLabel.setText("Could not sign in.");
            System.err.println(err);
        }
    }
    
    @FXML
    private void OpenRegisterWindow(ActionEvent e) throws IOException {
        Scene scene = new Scene(Loader.loadFXML("register"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}
