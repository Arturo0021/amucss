package com.amucss.mx.amucss;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

import com.amucss.mx.amucss.entities.Tiempos;

public class Pregunta_Activity extends AppCompatActivity {
    String clave;
    String pantalla;
    String date;
    Context context;
    com.amucss.mx.amucss.entities.Tiempos tiempos = new Tiempos();
    com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // Rota horizontal
        context = this;
        clave = getIntent().getStringExtra("clave");
        date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
        pantalla = "Introduccion";

        tiempos.setClave(clave);
        tiempos.setFecha(date);
        tiempos.setPantalla(pantalla);

        try {
            tiempos.setFoco("Entrada");
            com.amucss.mx.amucss.business.Tiempos.Insert(context, tiempos);

        } catch (Exception e) {
            e.getMessage();
        }

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK) {
            try {
                date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
                tiempos.setFecha(date);
                tiempos.setFoco("Salida");
                com.amucss.mx.amucss.business.Tiempos.Insert(context, tiempos);

            } catch (Exception e) {
                e.getMessage();
            }
        }
        return super.onKeyDown(keyCode, event);
    }

}
