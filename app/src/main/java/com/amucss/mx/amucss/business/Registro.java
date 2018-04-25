package com.amucss.mx.amucss.business;

import android.content.Context;

import java.util.concurrent.ExecutionException;

/**
 * Created by Arturo Sg on 24/04/2018.
 */

public class Registro {

    public static void Insert(Context context, com.amucss.mx.amucss.entities.Registro registro) throws Exception{

        if(registro == null) {
            throw new Exception("Objeto Registro No Referenciado");
        }

        com.amucss.mx.amucss.data.Registro.Insert(context,registro);

    }

    public static com.amucss.mx.amucss.entities.Registro ConfirmClave(Context context, String clave) throws Exception {

        com.amucss.mx.amucss.entities.Registro registro;
        if(clave.equals("") || clave.equals(null)) {
            throw new Exception("Clave Vacía");
        }

        registro = com.amucss.mx.amucss.data.Registro.ConfirmClave(context, clave);

        return registro;
    }

}
