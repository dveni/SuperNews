package com.example.veran.supernews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Noticia> news;
    private final int ADD = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        news = new ArrayList<Noticia>();
        generarNoticias();


        ListView miListView = (ListView) findViewById(R.id.ListView);
        ArrayAdapter<Noticia> adapter = new ArrayAdapter<Noticia>(this, android.R.layout.simple_list_item_1,news);
        miListView.setAdapter(adapter);
        miListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Noticia item = (Noticia) parent.getAdapter().getItem(position);
                String title = (String) item.getTitle();
                String body = (String) item.getBody();
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("body", body);
                startActivity(intent);

            }
        });


        Button boton = (Button) findViewById(R.id.Add);

        boton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Add", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent,ADD);
            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode==RESULT_OK){
            String title = data.getExtras().getString("title");
            String body = data.getExtras().getString("body");
            news.add(new Noticia(title, body));
        }else{
            Toast.makeText(getBaseContext(),"Accion cancelada", Toast.LENGTH_SHORT).show();
        }
    }
    private void generarNoticias(){
        Noticia n1 = new Noticia();
        Noticia n2 = new Noticia("\"TÚ, QUE ERES TAN LISTO, ¿QUÉ PUTO PROPONES?\", DECLARAN","Tus compañeros, cuyas ideas parece que son una mierda, estarán encantados de oír qué ideas tienes tú, informan tus compañeros");
        Noticia n3 = new Noticia("AAAAAAAAAA","aaaaaaaaaaaaaaaaaaaa");
        news.add(n1);
        news.add(n2);
        news.add(n3);

    }
}
