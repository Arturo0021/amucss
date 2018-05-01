package com.amucss.mx.amucss;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.amucss.mx.amucss.entities.Tiempos;

import java.sql.Date;
import java.sql.Time;
import java.util.Locale;

public class Lobby_Activity extends AppCompatActivity {

    ImageView imageView2;
    ImageView modulo1;
    ImageView modulo2;
    String clave;
    String pantalla;
    String date;
    Context context;
    com.amucss.mx.amucss.entities.Tiempos tiempos = new Tiempos();
    com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection;
    Button botonsito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby_);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Rota horizontal
        context = this;
        clave = getIntent().getStringExtra("clave");
        pantalla = "Lobby";
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        modulo1 = (ImageView) findViewById(R.id.modulo1);
        modulo2 = (ImageView) findViewById(R.id.modulo2);
        botonsito = (Button)findViewById(R.id.botonsito);
        date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
        tiempos.setClave(clave);
        tiempos.setFecha(date);
        tiempos.setPantalla(pantalla);

        try {
            tiempos.setFoco("Entrada");
            com.amucss.mx.amucss.business.Tiempos.Insert(context, tiempos);

        } catch (Exception e) {
            e.getMessage();
        }

        botonsito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Lobby_Activity.this, Tiempos_List.class);
                intent.putExtra("clave", clave);
                startActivity(intent);
                //Toast.makeText(context, "" + tiemposCollection.get(0).Fecha, Toast.LENGTH_SHORT).show();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*try {
                    date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
                    tiempos.setFecha(date);
                    tiempos.setFoco("Salida");
                    com.amucss.mx.amucss.business.Tiempos.Insert(context, tiempos);

                } catch (Exception e) {
                    e.getMessage();
                }*/

                Intent i = new Intent(Lobby_Activity.this, Pregunta_Activity.class);
                i.putExtra("clave", clave);
                startActivity(i);
            }
        });

        modulo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Lobby_Activity.this, Modulo_dos.class);
                i.putExtra("clave", clave);
                startActivity(i);
            }
        });

        modulo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Lobby_Activity.this, Modulo_tres.class);
                i.putExtra("clave", clave);
                startActivity(i);
            }
        });

    }
}
