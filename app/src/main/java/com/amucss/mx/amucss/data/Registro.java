package com.amucss.mx.amucss.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Arturo Sg on 24/04/2018.
 */

public class Registro {

    private static SQLiteDatabase db = null;

    public static void Insert(Context context, com.amucss.mx.amucss.entities.Registro registro) {

        db = (new DBHelper(context)).getWritableDatabase();

        String consulta = "INSERT INTO " + DBHelper.TABLE_USUARIOS
                                            + "("
                                                + DBHelper.COLUMN_NOMBRE + ", "
                                                + DBHelper.COLUMN_APAT + ", "
                                                + DBHelper.COLUMN_AMAT + ", "
                                                + DBHelper.COLUMN_SEXO + ", "
                                                + DBHelper.COLUMN_TELEFONO + ", "
                                                + DBHelper.COLUMN_EDAD + ", "
                                                + DBHelper.COLUMN_EMAIL + ", "
                                                + DBHelper.COLUMN_SOCIOSMB + ", "
                                                + DBHelper.COLUMN_CLAVE
                                            + ") VALUES ("
                                                + "'" + registro.getNombre() + "', "
                                                + "'" + registro.getApat() + "', "
                                                + "'" + registro.getAmat() + "', "
                                                + registro.getSexo() + ", "
                                                + registro.getTelefono() + ", "
                                                + registro.getEdad() + ", "
                                                + "'" + registro.getEmail() + "', "
                                                + registro.getSocio() + ", "
                                                + "'" + registro.getClave() + "');";
        db.execSQL(consulta);

    }

    public static com.amucss.mx.amucss.entities.Registro ConfirmClave(Context context, String clave) {
        db = (new DBHelper(context)).getWritableDatabase();

        com.amucss.mx.amucss.entities.Registro reg = new com.amucss.mx.amucss.entities.Registro();
        String consulta = "SELECT * FROM " + DBHelper.TABLE_USUARIOS
                                + " WHERE " + DBHelper.COLUMN_CLAVE + " = '" + clave + "';";


        Cursor cursor = db.rawQuery(consulta, null);

        if(cursor.moveToFirst()) {
            do {

                reg.setId(cursor.getInt(0));
                reg.setClave(cursor.getString(1));
                reg.setNombre(cursor.getString(2));
                reg.setApat(cursor.getString(3));
                reg.setAmat(cursor.getString(4));
                reg.setSexo(cursor.getInt(5));
                reg.setEdad(cursor.getInt(6));
                reg.setTelefono(cursor.getString(7));
                reg.setEmail(cursor.getString(8));
                reg.setSocio(cursor.getInt(9));

            }while (cursor.moveToNext());
        }
        return reg;
    }

}
