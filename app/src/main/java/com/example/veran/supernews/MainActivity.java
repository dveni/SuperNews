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
        Noticia n1 = new Noticia("El virus “Despacito” que ha afectado a la industria musical global podría tener su origen en Puerto Rico","Hacía más de 20 años que no ocurría una desgracia similar, desde que en 1996 el virus “La Macarena” logró infectar las listas de éxitos de todo el mundo. “Despacito” ha alcanzado esta semana el número uno en Estados Unidos, donde encabeza la lista Hot 100 de Billboard. Los expertos atribuyen su autoría a un cantante puertorriqueño llamado Luis Fonsi, aunque Europol señaló este martes que es pronto para saberlo con certeza.\n" +
                "\n" +
                "“Despacito” habría ido infectando poco a poco varias emisoras hasta corromper a Justin Bieber, mutando en una versión que disparó su propagación en tiempo récord. Las compañías discográficas reconocen que es pronto para decir si Puerto Rico estuvo involucrado en el ataque, que se ha convertido en una de las campañas musicales de más rápida propagación en la historia.\n" +
                "\n" +
                "A la cantidad de mentes de todo el mundo afectadas por el virus, hay que sumar la cantidad de listas Billboard latinas en las que “Despacito” también ha irrumpido sin piedad, pues por decimoquinta semana consecutiva está en cabeza de la lista Hot Latin Songs, seguida de El Amante, de Nicky Jam, y Chantaje, de Shakira junto a Maluma.\n" +
                "\n" +
                "Funcionarios de seguridad de Estados Unidos y Europa dijeron a Reuters bajo condición de anonimato que aún es demasiado pronto para determinar quién podría estar detrás de este ataque, pero no dudaban al señalar a Fonsi como uno de los principales sospechosos.");
        Noticia n2 = new Noticia("Una vaca hipocondríaca cree que debe de estar muy enferma por la cantidad de antibióticos que le están dando","\"MADRE DEL AMOR HERMOSO, DEBO DE ESTAR EN LAS ÚLTIMAS\", SE DICE");
        news.add(n1);
        news.add(n2);

    }
}
