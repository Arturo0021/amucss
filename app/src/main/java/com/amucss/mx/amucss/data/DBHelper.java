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
    public static final String COLUMN_ACTIVO = "Activo";
    public static final String COLUMN_FECHA = "Fecha";
    public static final String COLUMN_TEXTO = "Texto";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        TablaUsuarios(sqLiteDatabase);
        TablaIdiomas(sqLiteDatabase);
        Tiempo_Usuario(sqLiteDatabase);
        Table_Privacidad(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TIEMPOLAYOUT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_AVISOPRIVACIDAD);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_IDIOMA);
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
                        + COLUMN_NOMBRE + " VARCHAR, "
                        + COLUMN_ACTIVO + " INTEGER "
                    + ");";
        db.execSQL(Table_Idiomas);
    }

    public void Tiempo_Usuario(SQLiteDatabase db) {
        String Table_Usuarios =
                "CREATE TABLE IF NOT EXISTS " + TABLE_TIEMPOLAYOUT
                    + "("
                        + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + COLUMN_CLAVE + " INTEGER, "
                        + COLUMN_FECHA + " VARCHAR, "
                        + COLUMN_TEXTO + " VARCHAR "
                    + ");";
        db.execSQL(Table_Usuarios);
    }

    public void Table_Privacidad(SQLiteDatabase db) {
        String Table_Privacidad =
                "CREATE TABLE IF NOT EXISTS " + TABLE_AVISOPRIVACIDAD
                + "("
                    + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_TEXTO + " VARCHAR, "
                    + COLUMN_ACTIVO + " INTEGER"
                + ");";
        db.execSQL(Table_Privacidad);
    }
}
