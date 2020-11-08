package com.example.n2_parte2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static int CADASTRO_SUCESSO = 12;
    public static int LISTAGEM_SUCESSO = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCadastrar(View view) {
        Intent intentCadastrar = new Intent(MainActivity.this, Cadastro.class);
        startActivityForResult(intentCadastrar, CADASTRO_SUCESSO);
    }

    public void onClickListar(View view) {
        Intent intentListar = new Intent(MainActivity.this, Agenda.class);
        startActivityForResult(intentListar, LISTAGEM_SUCESSO);
    }
}