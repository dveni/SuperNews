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
        Intent intent = getIntent();


        Button comentar = (Button) findViewById(R.id.Comentar);
        Button puntuar = (Button) findViewById(R.id.Puntuar);

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

