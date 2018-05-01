package com.amucss.mx.amucss;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

import com.amucss.mx.amucss.entities.Tiempos;

public class Modulo_tres extends AppCompatActivity {

    VideoView video_press;
    Button bt_ver;
    String clave;
    String pantalla;
    String date;
    Context context;
    com.amucss.mx.amucss.entities.Tiempos tiempos = new Tiempos();
    com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulo_tres);
        context = this;
        clave = getIntent().getStringExtra("clave");
        date = String.valueOf(android.text.format.DateFormat.format("dd-MM-yyyy HH:mm:ss", new java.util.Date()));
        pantalla = "Modulo 2";
        tiempos.setClave(clave);
        tiempos.setFecha(date);
        tiempos.setPantalla(pantalla);

        try {
            tiempos.setFoco("Entrada");
            com.amucss.mx.amucss.business.Tiempos.Insert(context, tiempos);

        } catch (Exception e) {
            e.getMessage();
        }

        video_press = (VideoView)findViewById(R.id.video_press);
        bt_ver = (Button)findViewById(R.id.bt_ver);

        bt_ver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videourl = "/mnt/sdcard/Download/Abc.mp4";
                Uri uri = Uri.parse(videourl);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                intent.setDataAndType(uri, "video/mp4");
                startActivity(intent);
            }
        });

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
