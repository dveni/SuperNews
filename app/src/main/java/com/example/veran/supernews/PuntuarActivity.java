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
    private static final String TAG = PuntuarActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntuar);

        Button guardar = (Button) findViewById(R.id.Save);
        Button cancelar = (Button) findViewById(R.id.CancelP);
        nuevaPuntuacion = (RatingBar) findViewById(R.id.nuevaPuntuacion);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

        TextView titulo = (TextView) findViewById(R.id.TitlePuntuar);
        titulo.setText(getIntent().getExtras().getString("title"));
    }
    public void onClick(View v) {
        Log.d(TAG, "onClick");
        switch (v.getId()) {
            case R.id.Save: {
                try {
                    Toast.makeText(getBaseContext(), "Nueva Puntuacion", Toast.LENGTH_SHORT).show();
                    float puntuacion = nuevaPuntuacion.getRating();
                    Intent i= getIntent();
                    i.putExtra("puntuacion",puntuacion);

                    setResult(RESULT_OK, i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }

            case R.id.CancelP: {
                Toast.makeText(getBaseContext(), "Puntuacion cancelada", Toast.LENGTH_SHORT).show();
                setResult(RESULT_CANCELED);
                finish();

            }
            default:
                Log.e(TAG, "Resultado no esperado");
        }
    }
}


