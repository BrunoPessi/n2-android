package com.example.n2_http_brunopessiderzi;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


public class UserGit {
    public User getInformacao(String end){
        String json = ConexaoApi.getJsonFromApi(end);
        User retorno = parseJson(json);
        return retorno;
    }

    private User parseJson(String json){
        try {
            User usuario = new User();

            JSONObject jsonObj = new JSONObject(json);

            usuario.setNome(jsonObj.getString("name"));
            usuario.setNomeDeUsuario(jsonObj.getString("login"));
            usuario.setId(jsonObj.getString("id"));
            usuario.setLocalizacao(jsonObj.getString("location"));
            usuario.setFoto(baixarImagem(jsonObj.getString("avatar_url")));

            return usuario;
        }catch (JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    private Bitmap baixarImagem(String url) {
        try {
            URL endereco = new URL(url);
            InputStream inputStream = endereco.openStream();
            Bitmap imagem = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return imagem;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}