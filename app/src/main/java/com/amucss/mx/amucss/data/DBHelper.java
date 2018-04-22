package com.amucss.mx.amucss.data;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.IDNA;

/**
 * Created by Arturo Sg on 21/04/2018.
 */

public class DBHelper extends SQLiteOpenHelper {

    public final Context context;
    private static final String DATABASE_NAME = "verificentros";
    public static final int DATABASE_VERSION = 1;

    // Tablas
    public static final String TABLE_USUARIOS = "Usuarios";
    public static final String TABLE_TIEMPOLAYOUT = "Tiempo_Layout";
    public static final String TABLE_AVISOPRIVACIDAD = "Aviso_Privacidad";
    public static final String TABLE_IDIOMA = "Idioma";
    public static final String TABLE_LOGS = "LOGS";
    // Columnas
    public static final String COLUMN_ID = "_Id";
    public static final String COLUMN_NOMBRE = "Nombre";
    public static final String COLUMN_APAT = "Apellido_Paterno";
    public static final String COLUMN_AMAT = "Apellido_Materno";
    public static final String COLUMN_CLAVE = "Clave";
    public static final String COLUMN_SEXO = "Sexo";
    public static final String COLUMN_TELEFONO = "Telefono";
    public static final String COLUMN_EDAD = "Edad";
    public static final String COLUMN_EMAIL = "Email";
    public static final String COLUMN_SOCIOSMB = "Socio_Smb";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        TablaUsuarios(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void TablaUsuarios(SQLiteDatabase db) {
        String Table_Usuarios =
                "CREATE TABLE IF NOT EXISTS " + TABLE_USUARIOS
                    + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_CLAVE + " INTEGER, "
                        + COLUMN_NOMBRE + " VARCHAR, "
                        + COLUMN_APAT + " VARCHAR, "
                        + COLUMN_AMAT + " VARCHAR, "
                        + COLUMN_SEXO + " INTEGER, "
                        + COLUMN_EDAD + " INTEGER, "
                        + COLUMN_TELEFONO + " INTEGER, "
                        + COLUMN_EMAIL + " VARCHAR, "
                        + COLUMN_SOCIOSMB + " INTEGER"
                    + ");";
        db.execSQL(Table_Usuarios);
    }

    public void TablaIdiomas(SQLiteDatabase db) {
        String Table_Idiomas =
                "CREATE TABLE IF NOT EXISTS " + TABLE_IDIOMA
                    + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + ");";
        db.execSQL(Table_Idiomas);
    }
}
