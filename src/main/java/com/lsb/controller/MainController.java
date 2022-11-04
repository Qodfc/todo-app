package com.lsb.controller;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import com.lsb.util.Parser;

public class MainController {
    @FXML
    Button btn;

    @FXML
    WebView webView;

    final String cssPath = "/main/resources";
    

    @FXML
    private void initialize() {
        final WebEngine engine = webView.getEngine();

        engine.setUserStyleSheetLocation(getClass().getResource(cssPath + "mainView.css").toString());

        engine.loadContent("<html>"
            + "<body><div id='container'></div></body>"
            + "</html>");

        engine.documentProperty().addListener((v, o, n) -> {
            if (n != null) {
                Document document = engine.getDocument();
                Element board = document.getElementById("container");

                for (int i = 0; i < 3; i++) {
                    String el = "<h1>hi</h1>";
                    String id = String.format("content-%s", i);
                    Element content = document.createElement("div");
                    content.setAttribute("id", id);
                    board.appendChild(content);
                    
                    engine.executeScript(
                        "document.getElementById('" + id + "')"
                        + ".innerHTML = '" + el + "';"
                    );
                }
            }
        });
    }

    @FXML
    private void switchToPrimary() throws IOException {
        //Stage stage = (Stage) secondaryButton.getScene().getWindow();
        //stage.close();
    }
}