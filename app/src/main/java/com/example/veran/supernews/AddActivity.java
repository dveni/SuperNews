package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = AddActivity.class.getName();
    EditText titulo;
    EditText cuerpo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        titulo = (EditText) findViewById(R.id.titleAdd);
        cuerpo = (EditText) findViewById(R.id.bodyAdd);
        Button guardar = (Button) findViewById(R.id.Save);
        Button cancelar = (Button) findViewById(R.id.Cancel);
        guardar.setOnClickListener(this);
        cancelar.setOnClickListener(this);

    }

    public void onClick(View v) {
        Log.d(TAG, "onClick");
        switch (v.getId()) {
            case R.id.Save: {
                try {
                    String title = titulo.getText().toString();
                    String body = cuerpo.getText().toString();
                    Intent i = getIntent();
                    i.putExtra("title",title);
                    i.putExtra("body",body);

                    setResult(RESULT_OK,i);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }

            case R.id.Cancel: {
                setResult(RESULT_CANCELED);
                finish();
            }
            default:
                Log.e(TAG, "Click en vista no esperado");
        }
    }
}
