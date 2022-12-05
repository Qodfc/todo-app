package com.lsb.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class Connector {
    public String Request(URL url, JSONObject obj) {
        String returnString = "";

        try {
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("x-access-token", Auth.getAuthToken());
            connection.setDoOutput(true);

            BufferedWriter req = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
            req.write(obj.toString());
            req.flush();
            req.close();

            BufferedReader res = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            returnString = res.readLine();
        }
        catch (IOException e) {
            System.err.println(e);
        }
        catch (JSONException e) {
            System.err.println(e);
        }

        return returnString;
    }
}
