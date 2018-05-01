package com.amucss.mx.amucss;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.amucss.mx.amucss.entities.Tiempos;

import java.util.List;

public class Tiempos_List extends AppCompatActivity {
    ListView list_tiempos;
    Context context;
    String clave;
    com.amucss.mx.amucss.entities.Tiempos tiempos = new Tiempos();
    com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection;
    List<com.amucss.mx.amucss.entities.Tiempos> list_tiempo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempos__list);
        context = this;
        clave = getIntent().getStringExtra("clave");


        list_tiempos = (ListView)findViewById(R.id.list_tiempos);
        tiemposCollection = com.amucss.mx.amucss.business.Tiempos.tiempos(context,clave);
        list_tiempo = tiemposCollection;

        Adaptador_Tiempos adapter = new Adaptador_Tiempos(context, R.layout.list_tiempos, list_tiempo);
        list_tiempos.setAdapter(adapter);
    }
}
