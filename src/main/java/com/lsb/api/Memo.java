package com.lsb.api;

import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lsb.Config;

public class Memo {
    private static JSONArray memos = new JSONArray();

    static Connector conn = new Connector();

    public static JSONArray Get() {
        return memos;
    }

    public static void Refresh() {
        try {
            URL url = new URL(Config.URL_GET_MEMO);
            JSONObject nullData = new JSONObject();

            memos = new JSONArray(conn.Request(url, nullData));
        }
        catch (MalformedURLException e) {
            System.err.println(e);
        }
        catch (JSONException e) {
            System.err.println(e);
        }
    }
}
