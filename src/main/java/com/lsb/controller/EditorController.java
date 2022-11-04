package com.lsb.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;
import javafx.stage.Stage;

import com.lsb.App;

public class EditorController {

    @FXML
    HTMLEditor htmlEditor;
    
    @FXML
    Button submitButton;

    @FXML
    private void save(ActionEvent e) throws IOException {
        System.out.println(htmlEditor.getHtmlText());
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
}