package com.lsb.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.HTMLEditor;

public class EditorController {
    @FXML
    TextField titleEditor;

    @FXML
    HTMLEditor htmlEditor;

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

    public void setTitle (String text) {
        titleEditor.setText(text);
    }
}