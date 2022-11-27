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
                    String title = "" + i;
                    String article = "<p>Hi, " + i + "</p>";
                    String id = String.format("content-%s", i);

                    Element content = document.createElement("div");
                    content.setAttribute("id", id);
                    content.setAttribute("class", "content-item");

                    Element contentTitle = document.createElement("div");
                    contentTitle.setAttribute("id", id + "-title");
                    contentTitle.setAttribute("class", "content-item-title");

                    Element contentArticle = document.createElement("div");
                    contentArticle.setAttribute("id", id + "-article");
                    contentArticle.setAttribute("class", "content-item-article");

                    Element hr = document.createElement("hr");
                    
                    content.appendChild(contentTitle);
                    content.appendChild(hr);
                    content.appendChild(contentArticle);

                    board.appendChild(content);
                    
                    engine.executeScript(
                        "document.getElementById('" + id + "-title')"
                        + ".innerHTML = '" + title + "';"
                        +
                        "document.getElementById('" + id + "-article')"
                        + ".innerHTML = '" + article + "';"
                    );

                    content.setAttribute("onclick", "app.click(this.querySelector('.content-item-title').innerText, this.querySelector('.content-item-article').innerHTML)");
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
        public void click(String title, String article) throws IOException {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/lsb/editor.fxml"));     

                Parent root = (Parent)fxmlLoader.load();          
                EditorController controller = fxmlLoader.<EditorController>getController();
                
                controller.setTitle(title);
                controller.setArticle(article);

                Scene scene = new Scene(root); 
                Stage stage = new Stage();

                stage.setScene(scene);    
                stage.show();  
            }
            catch (Exception e) {
                System.err.println(e);
            }
             
        }
    }
}