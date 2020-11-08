package com.example.n2_http_brunopessiderzi;

import android.graphics.Bitmap;

public class User {
    private String nome;
    private String nomeDeUsuario;
    private String id;
    private String localizacao;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Bitmap foto;

    public String getNomeDeUsuario() {
        return nomeDeUsuario;
    }

    public void setNomeDeUsuario(String nomeDeUsuario) {
        this.nomeDeUsuario = nomeDeUsuario;
    }

    public Bitmap getFoto() {
        return foto;
    }

    public void setFoto(Bitmap foto) {
        this.foto = foto;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}