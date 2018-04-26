package com.amucss.mx.amucss.business;

import android.content.Context;

/**
 * Created by Arturo Sg on 25/04/2018.
 */

public class Tiempos  {

    public static void Insert(Context context, com.amucss.mx.amucss.entities.Tiempos tiempos)throws Exception {

        if(tiempos == null) {
            throw new Exception("Objeto Tiempo No Referenciado");
        }

        com.amucss.mx.amucss.data.Tiempos.Insert(context, tiempos);

    }

    public static com.amucss.mx.amucss.entities.TiemposCollection tiempos(Context context, String clave) {

        com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection =  com.amucss.mx.amucss.data.Tiempos.tiempos(context,clave);

        return tiemposCollection;
    }
}
