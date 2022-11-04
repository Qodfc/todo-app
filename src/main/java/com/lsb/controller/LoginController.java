package com.lsb.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import com.lsb.App;

public class LoginController {

    @FXML
    Label stateLabel;
    
    @FXML
    Button loginButton;

    @FXML
    private void changeStateToLoggedIn(ActionEvent e) throws IOException {
        Scene scene = new Scene(loadFXML("main"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage currentStage = (Stage) loginButton.getScene().getWindow();
        currentStage.close();
        //stateLabel.setText("Pressed");
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
