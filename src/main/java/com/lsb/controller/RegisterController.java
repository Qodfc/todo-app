package com.lsb.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;

import com.lsb.api.Auth;

public class RegisterController {
    @FXML
    TextField idInput, nameInput;

    @FXML
    PasswordField passwordInput;

    @FXML
    Button submitButton;

    @FXML
    private void submit() {
        final String id = idInput.getText();
        final String password = passwordInput.getText();
        final String name = nameInput.getText();

        try {
            Auth.Register(id, password, name);

        }
        catch (Exception e) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Sign up error");
            alert.setHeaderText("Could not sign up");
            alert.setContentText("There was an error while signing up. Please try again later.");
            alert.showAndWait();
        }
    }
}
