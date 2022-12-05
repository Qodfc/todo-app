package com.lsb.api;

import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import com.lsb.Config;

public class Auth {
    private static String authToken;

    static Connector conn = new Connector();

    public static String getAuthToken() {
        return authToken;
    }

    public static void Login(String id, String password) {
        try {
            URL url = new URL(Config.URL_LOGIN);
            JSONObject LoginData = createLoginData(id, password);

            authToken = new JSONObject(conn.Request(url, LoginData)).getString("authToken");
        }
        catch (MalformedURLException e) {
            System.err.println(e);
        }
    }

    public static void Register(String id, String password, String name) {
        try {
            URL url = new URL(Config.URL_REGISTER);
            JSONObject RegisterData = createRegisterData(id, password, name);

            authToken = new JSONObject(conn.Request(url, RegisterData)).getString("authToken");
        }
        catch (MalformedURLException e) {
            System.err.println(e);
        }
    }

    static JSONObject createLoginData(String id, String password) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("password", password);

        return obj;
    }

    static JSONObject createRegisterData(String id, String password, String name) {
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("password", password);
        obj.put("name", name);

        return obj;
    }
}
