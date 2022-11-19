package com.lsb.controller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;

public class EditorController {

    @FXML
    HTMLEditor htmlEditor;
    
    @FXML
    Button submitButton;

    @FXML
    private void initialize() {
    }

    @FXML
    private void save(ActionEvent e) {
        System.out.println(htmlEditor.getHtmlText());
    }

    public void setArticle (String html) {
        htmlEditor.setHtmlText(html);
    }
}