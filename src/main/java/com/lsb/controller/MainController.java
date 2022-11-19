package com.lsb.controller;

import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

import com.lsb.util.Loader;

public class MainController{
    @FXML
    Button btn;

    @FXML
    WebView webView;

    private JSBridge jsBridge;

    @FXML
    public void initialize() {
        final WebEngine engine = webView.getEngine();

        engine.setJavaScriptEnabled(true);
        engine.setUserStyleSheetLocation(getClass().getResource("/com/lsb/mainView.css").toString());
        engine.documentProperty().addListener((v, o, n) -> {
            if (n != null) {
                Document document = engine.getDocument();
                Element board = document.getElementById("container");

                jsBridge = new JSBridge();
                
                for (int i = 0; i < 30; i++) {
                    String el = "<h2>Hi, " + i + "</h2>";
                    String id = String.format("content-%s", i);
                    String cl = "content-item";
                    Element content = document.createElement("div");
                    content.setAttribute("id", id);
                    content.setAttribute("class", cl);

                    board.appendChild(content);
                    
                    engine.executeScript(
                        "document.getElementById('" + id + "')"
                        + ".innerHTML = '" + el + "';"
                    );

                    content.setAttribute("onclick", "app.click(this.innerHTML)");
                }

                System.out.println("Ready");
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("app", jsBridge);

                //Firebug debugging
                //engine.executeScript("var firebug=document.createElement('script');firebug.setAttribute('src','https://lupatec.eu/getfirebug/firebug-lite-compressed.js');document.body.appendChild(firebug);(function(){if(window.firebug.version){firebug.init();}else{setTimeout(arguments.callee);}})();void(firebug);");
            }
        });
        
        engine.loadContent("<html>"
            + "<body><div id='container' onclick='\"java.click()\"'></div></body>"
            + "</html>");
    }

    public class JSBridge {
        public void click(String html) throws IOException {
            System.out.println(html);
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/lsb/editor.fxml"));     

            Parent root = (Parent)fxmlLoader.load();          
            EditorController controller = fxmlLoader.<EditorController>getController();
            controller.setArticle(html);

            Scene scene = new Scene(root); 
            Stage stage = new Stage();

            stage.setScene(scene);    
            stage.show();   
        }
    }
}