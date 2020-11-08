package com.example.n2_http_brunopessiderzi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Seguidores extends AppCompatActivity {

    private TextView nome;
    private TextView nomeDeUsuario;
    private TextView id;
    private TextView localizacao;
    private ProgressDialog load;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_followers);

        GetUsuario getusuario = new GetUsuario();

        nome = (TextView)findViewById(R.id.nome);
        nomeDeUsuario = (TextView)findViewById(R.id.nomeDeUsuario);
        id = (TextView)findViewById(R.id.id);
        localizacao = (TextView)findViewById(R.id.localizacao);



        //Chama Async Task
        getusuario.execute();


    }

    private class GetUsuario extends AsyncTask<Void, Void, Follower> {

        @Override
        protected void onPreExecute(){
            //inicia o dialog
            load = ProgressDialog.show(Seguidores.this,
                    "Aguarde ...", "Obtendo Informações...");
        }

        @Override
        protected Follower doInBackground(Void... params) {
            FollowerGit util = new FollowerGit();
            return util.getInformacao("https://api.github.com/users/brunopessi/followers");
        }

        @Override
        protected void onPostExecute(Follower usuario){
            nome.setText(usuario.getNome());
            id.setText(usuario.getId());
            load.dismiss(); //deleta o dialog
        }
    }
}