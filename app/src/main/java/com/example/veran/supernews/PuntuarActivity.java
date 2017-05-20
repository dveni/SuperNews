package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class PuntuarActivity extends AppCompatActivity implements View.OnClickListener {

    RatingBar nuevaPuntuacion;
    private static final String TAG = ComentarActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuar);

        Button guardar = (Button) findViewById(R.id.Save);
        Button cancelar = (Button) findViewById(R.id.CancelP);
        TextView titulo = (TextView) findViewById(R.id.TitlePuntuar);
        nuevaPuntuacion = (RatingBar) findViewById(R.id.nuevaPuntuacion);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);
    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Save: {
                try {
                    Log.d(TAG,"Nueva puntuación");
                    Toast.makeText(getBaseContext(), "Nueva Puntuacion", Toast.LENGTH_SHORT).show();
                    int puntuacion = nuevaPuntuacion.getNumStars();
                    Intent i= getIntent();
                    i.putExtra("puntuación",puntuacion);

                    setResult(RESULT_OK, i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }

            case R.id.CancelP: {
                Log.d(TAG, "Puntuación cancelada");
                Toast.makeText(getBaseContext(), "Puntuacion cancelada", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                finish();

            }
            default:
                Log.e(TAG, "...");
        }
    }
}


