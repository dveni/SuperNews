package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DetailActivity extends AppCompatActivity {
    private List<String> comments;
    private static final int COMENTAR = 0;
    private static final int PUNTUAR = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        String body = extras.getString("body");
        String title = extras.getString("title");


        TextView titulo = (TextView) findViewById(R.id.Title);
        TextView cuerpo = (TextView) findViewById(R.id.Body);
        Button comentar = (Button) findViewById(R.id.Comentar);
        Button puntuar = (Button) findViewById(R.id.Puntuar);

        cuerpo.setText(body);
        titulo.setText(title);

        comments = new ArrayList<String>();

        ListView miListView = (ListView) findViewById(R.id.comentarios);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,comments);
        miListView.setAdapter(adapter);


        comentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Comenta por favor", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, ComentarActivity.class);
                startActivityForResult(intent,COMENTAR);
            }
        });

        puntuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Puntúa por favor", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, PuntuarActivity.class);
                startActivityForResult(intent,PUNTUAR);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK&&requestCode == COMENTAR){
            String comentario = data.getExtras().getString("comentario");
            comments.add(comentario);
        }else if(resultCode==RESULT_OK && requestCode==PUNTUAR){
            RatingBar puntuation = (RatingBar) findViewById(R.id.ratingBar2);
            float puntuacion = data.getExtras().getFloat("puntuacion");
            puntuation.setRating(puntuacion);

        } else{
            Toast.makeText(getBaseContext(), "Comentario cancelado", Toast.LENGTH_SHORT).show();
        }
    }
}

