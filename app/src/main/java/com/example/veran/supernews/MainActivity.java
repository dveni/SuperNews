package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    int a;
        Button boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Change", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
            }
        });

    }
}
