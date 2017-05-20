package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class ComentarActivity extends AppCompatActivity {

    private static final String TAG = ComentarActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentar);

        Button guardar = (Button) findViewById(R.id.SaveC);
        Button cancelar = (Button) findViewById(R.id.CancelC);
        TextView titulo = (TextView) findViewById(R.id.TitleComentar);
        TextView comentarioC = (TextView) findViewById(R.id.comentarioComentar) ;
        EditText comment = (EditText) findViewById(R.id.editText);


        final String dato = comment.getText().toString();


        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Nuevo comentario", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ComentarActivity.this, DetailActivity.class);
                intent.putExtra("comentario", dato);
                startActivity(intent);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Comentario cancelado", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ComentarActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }

}
