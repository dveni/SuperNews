package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

public class ComentarActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = ComentarActivity.class.getName();
    EditText nuevoComentario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comentar);

        Button guardar = (Button) findViewById(R.id.SaveC);
        Button cancelar = (Button) findViewById(R.id.CancelC);
        TextView titulo = (TextView) findViewById(R.id.TitleComentar);
        TextView comentarioC = (TextView) findViewById(R.id.comentarioComentar);
        nuevoComentario = (EditText) findViewById(R.id.nuevoComentario);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SaveC: {
                try {
                    Toast.makeText(getBaseContext(), "Nuevo comentario", Toast.LENGTH_SHORT).show();
                    String comentario = nuevoComentario.getText().toString();
                    Intent i= getIntent();
                    i.putExtra("comentario",comentario);

                    setResult(RESULT_OK, i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }

            case R.id.CancelC: {
                Toast.makeText(getBaseContext(), "Comentario cancelado", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                finish();

            }
            default:
                Log.e(TAG, "...");
        }
    }
}

