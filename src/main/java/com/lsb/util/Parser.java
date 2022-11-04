package com.lsb.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javafx.scene.text.*;;

public class Parser {
    public TextFlow parse(String s) {
        TextFlow flow = new TextFlow();

        Pattern p = Pattern.compile("\\<\\$([a-z])\\>(.*?)\\<\\/\\$([a-z])\\>"); //<$c>
        Matcher m = p.matcher(s);

        String str;
        int begin = 0;
        int end = 0;

        while(m.find()) {
            begin = m.start();
            end = m.end();
            str = m.group();
            int indicator = str.charAt(2);

            System.out.print("Start index: " + m.start());
            System.out.print(" End index: " + m.end());
            System.out.println(" Found: " + m.group()); //debugging

            Text normalText = new Text(); // normal text
            flow.getChildren().add(normalText);

            Text styledText = new Text(s.substring(begin + 3, end - 3));

            if (indicator == 'i') styledText.setStyle("-fx-font-weight: italic");
            if (indicator == 'b') styledText.setStyle("-fx-font-weight: bold");

            flow.getChildren().add(styledText);
        }

        Text lastText = new Text(s.substring(end, s.length()));
        flow.getChildren().add(lastText);

        return flow;
    }
}
