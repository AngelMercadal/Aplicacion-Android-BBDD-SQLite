package com.example.debugging;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;



public class DbHelper extends SQLiteOpenHelper {

private static final int DATABASE_VERSION=1;

private static final String DATABASE_NAME="music.db";

public static final String TABLE_USERS="users";


    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_USERS+"(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "nombre_usuario TEXT NOT NULL UNIQUE, " +
                "contraseña TEXT NOT NULL, " +
                "email TEXT NOT NULL" +
                ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        //lo dejeamos vacio, no planificamos actualizar la base de datos por el momento

    }
}
