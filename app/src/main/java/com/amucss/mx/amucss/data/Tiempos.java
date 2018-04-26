package com.amucss.mx.amucss.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.amucss.mx.amucss.entities.TiemposCollection;

/**
 * Created by Arturo Sg on 25/04/2018.
 */

public class Tiempos {

    private static SQLiteDatabase db = null;

    public static void Insert(Context context, com.amucss.mx.amucss.entities.Tiempos tiempos) {

        db = (new DBHelper(context)).getWritableDatabase();

        String insert = "INSERT INTO " + DBHelper.TABLE_TIEMPOLAYOUT
                            + "("
                                + DBHelper.COLUMN_CLAVE + ", "
                                + DBHelper.COLUMN_FECHA + ", "
                                + DBHelper.COLUMN_TEXTO
                            + ") VALUES ("
                                + "'" + tiempos.getClave() + "', "
                                + "'" + tiempos.getFecha() + "', "
                                + "'" + tiempos.getPantalla() + "');";
        db.execSQL(insert);

    }

    public static com.amucss.mx.amucss.entities.TiemposCollection tiempos(Context context, String clave) {
        db = (new DBHelper(context)).getWritableDatabase();
        com.amucss.mx.amucss.entities.TiemposCollection tiemposCollection = new TiemposCollection();

        String consulta = "SELECT "
                                + DBHelper.COLUMN_FECHA + ", "
                                + DBHelper.COLUMN_TEXTO
                                + " FROM " + DBHelper.TABLE_TIEMPOLAYOUT
                                + " WHERE " + DBHelper.COLUMN_CLAVE + " = '" + clave + "'";
        Cursor cursor = db.rawQuery(consulta, null);
        if(cursor.moveToFirst()) {
            do {
                com.amucss.mx.amucss.entities.Tiempos tiempos = new com.amucss.mx.amucss.entities.Tiempos();
                tiempos.setFecha(cursor.getString(0));
                tiempos.setPantalla(cursor.getString(1));
                tiemposCollection.add(tiempos);
            } while (cursor.moveToNext());
        }
        return tiemposCollection;
    }

}
