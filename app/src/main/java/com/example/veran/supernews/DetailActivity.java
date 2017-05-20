package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;


public class DetailActivity extends AppCompatActivity {
    private TextView body;
    private TextView newComment;
    private TextView newPuntuation;

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

        comentar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "A comentar pavo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, ComentarActivity.class);
                startActivity(intent);
            }
        });

        puntuar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"A puntuar pavo", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DetailActivity.this, PuntuarActivity.class);
                startActivity(intent);
            }
        });
    }
}

