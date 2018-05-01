package com.amucss.mx.amucss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arturo Sg on 26/04/2018.
 */

public class Adaptador_Tiempos extends BaseAdapter {
    private Context context;
    private int layout;
    private List<com.amucss.mx.amucss.entities.Tiempos> tiemposList;

    public Adaptador_Tiempos(Context context, int layout, List<com.amucss.mx.amucss.entities.Tiempos> tiemposList) {
        this.context = context;
        this.layout = layout;
        this.tiemposList = tiemposList;
    }

    @Override
    public int getCount() {
        return this.tiemposList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tiemposList.get(position);
    }

    @Override
    public long getItemId(int Id) {
        return Id;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View v = view;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.list_tiempos, null);
        com.amucss.mx.amucss.entities.Tiempos tiempos = tiemposList.get(position);

        TextView txt_pantalla = (TextView)v.findViewById(R.id.txt_pantalla);
        TextView txt_tiempo = (TextView)v.findViewById(R.id.txt_tiempo);

        txt_pantalla.setText(tiempos.getPantalla() + " - " + tiempos.getFoco());
        txt_tiempo.setText(tiempos.getFecha());

        return v;
    }
}
