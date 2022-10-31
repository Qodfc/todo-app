package com.lsb;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class PrimaryController {
    @FXML
    Label stateLabel;

    @FXML
    private void switchToSecondary() throws IOException {

        App.setRoot("secondary");
    }

    @FXML
    private void changeStateToLoggedIn(ActionEvent e) throws IOException {
        Scene scene = new Scene(loadFXML("secondary"));
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        //stateLabel.setText("Pressed");
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}
