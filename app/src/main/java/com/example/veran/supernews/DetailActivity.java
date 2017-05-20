package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {
    private TextView body;
    private TextView newComment;
    private TextView newPuntuation;
    private TextView title;
    private static final int ADD = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        String body = extras.getString("body");
        String title = extras.getString("title");
        final String comentario = extras.getString("comentario");
        final String puntuacion = extras.getString("puntuación");

        TextView titulo = (TextView) findViewById(R.id.Title);
        TextView cuerpo = (TextView) findViewById(R.id.Body);
        Button comentar = (Button) findViewById(R.id.Comentar);
        Button puntuar = (Button) findViewById(R.id.Puntuar);
        TextView nuevoComentario = (TextView) findViewById(R.id.comentario) ;
        TextView nuevaPuntuacion = (TextView) findViewById(R.id.puntuación);

        cuerpo.setText(body);
        titulo.setText(title);
        nuevoComentario.setText(comentario);
        nuevaPuntuacion.setText(puntuacion);

        comentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Comenta por favor", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, ComentarActivity.class);
                startActivityForResult(intent,ADD);
            }
        });

        puntuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Puntúa por favor", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, PuntuarActivity.class);
                startActivityForResult(intent,ADD);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String comentario = data.getExtras().getString("comentario");
            String puntuacion = data.getExtras().getString("puntuación");
        } else {
            Toast.makeText(getBaseContext(), "Atrás", Toast.LENGTH_SHORT).show();
        }
    }
}

