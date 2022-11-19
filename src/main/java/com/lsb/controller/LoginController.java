package com.lsb.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.lsb.util.Loader;

public class LoginController {

    @FXML
    Label stateLabel;
    
    @FXML
    Button loginButton;

    @FXML
    private void changeStateToLoggedIn(ActionEvent e) throws IOException {
        Scene scene = new Scene(Loader.loadFXML("main"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.close();
        //stateLabel.setText("Pressed");
    }
}
