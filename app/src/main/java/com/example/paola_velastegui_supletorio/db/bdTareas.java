package com.example.paola_velastegui_supletorio.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class bdTareas {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABSE_NOMBRE = "tareas_db";
    public static final String TABLE_TAREAS = "t_tareas";

    public bdTareas(@Nullable Context context) {
       // super(context, DATABSE_NOMBRE,null,DATABASE_VERSION);
    }

    /*@Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_TAREAS + "("+
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "CEDULA TEXT NOT NULL," +
                "CLAVE TEXT NOT NULL)");
    }

     */
/*
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_TAREAS);
        onCreate(sqLiteDatabase);
    }

 */
}
