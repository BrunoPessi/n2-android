package com.example.n2_http_brunopessiderzi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Index extends AppCompatActivity {

    private TextView nome;
    private TextView nomeDeUsuario;
    private TextView id;
    private TextView localizacao;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        GetUsuario getusuario = new GetUsuario();

        nome = (TextView)findViewById(R.id.nome);
        nomeDeUsuario = (TextView)findViewById(R.id.nomeDeUsuario);
        id = (TextView)findViewById(R.id.id);
        localizacao = (TextView)findViewById(R.id.localizacao);



        //Chama Async Task
        getusuario.execute();


    }

    private class GetUsuario extends AsyncTask<Void, Void, User> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(Index.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected User doInBackground(Void... params) {
            UserGit util = new UserGit();
            return util.getInformacao("https://api.github.com/users/" + getIntent().getStringExtra("NOME"));
        }

        @Override
        protected void onPostExecute(User usuario){
            nome.setText(usuario.getNome());
            nomeDeUsuario.setText(usuario.getNomeDeUsuario());
            id.setText(usuario.getId());
            localizacao.setText(usuario.getLocalizacao());
            load.dismiss(); //deleta o dialog
        }
    }

    public void onClick(View view) {
        Intent intent_nome = new Intent(Index.this, Seguidores.class);
        startActivity(intent_nome);
    }
}