package com.lsb;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondaryController {
    @FXML
    Button secondaryButton;

    @FXML
    private void switchToPrimary() throws IOException {
        Stage stage = (Stage) secondaryButton.getScene().getWindow();
        stage.close();
    }
}