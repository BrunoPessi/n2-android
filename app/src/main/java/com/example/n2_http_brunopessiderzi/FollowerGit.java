package com.example.n2_http_brunopessiderzi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Random;

public class FollowerGit {
    public Follower getInformacao(String apiString) {
        String jsonStr = ConexaoApi.getJsonFromApi(apiString);
        Follower resultado = parseJson(jsonStr);

        return resultado;
    }

    private Follower parseJson(String json) {
        try {
            Follower follower = new Follower();

            JSONArray jsonArr = new JSONArray(json);
            int randomIndex = new Random().nextInt(jsonArr.length());
            JSONObject jsonObj = jsonArr.getJSONObject(randomIndex);

            follower.setId(jsonObj.getString("login"));

            return follower;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}