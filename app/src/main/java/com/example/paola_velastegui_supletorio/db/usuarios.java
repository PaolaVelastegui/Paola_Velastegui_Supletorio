package com.example.paola_velastegui_supletorio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.paola_velastegui_supletorio.entidades.Usuario;

import java.util.ArrayList;

public class usuarios extends base{

    Context context;
    public usuarios(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContactos(String cedula, String clave){
        long id = 0;
        try {
            base dbHelper = new base(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("CEDULA",cedula);
            values.put("CLAVE",clave);

            id = db.insert(TABLE_USUARIOS, null, values);
        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }

    public ArrayList<Usuario> showContacts(){
        base dbHelper = new base(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Usuario> listContacts = new ArrayList<>();
        Usuario contacto = null;
        Cursor cursorContact =  null;

        cursorContact = db.rawQuery("SELECT * FROM "+TABLE_USUARIOS,null);
        if(cursorContact.moveToFirst()){
            do{
                contacto = new Usuario();
                contacto.setId(cursorContact.getInt(0));
                contacto.setCedula(cursorContact.getString(1));
                contacto.setClave(cursorContact.getString(2));
            }while(cursorContact.moveToNext());
        }
        cursorContact.close();
        return listContacts;
    }

    public ArrayList<Usuario> buscarUsuario(String usuario, String clave){
        base dbHelper = new base(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Usuario> listContacts = new ArrayList<>();
        Usuario contacto = null;
        Cursor cursorContact =  null;
        cursorContact = db.rawQuery("SELECT * FROM "+TABLE_USUARIOS,null);
        if(cursorContact.moveToFirst()){
            do{
                if(usuario.equals(cursorContact.getString(1))){
                    contacto = new Usuario();
                    contacto.setId(cursorContact.getInt(0));
                    contacto.setCedula(cursorContact.getString(1));
                    contacto.setClave(cursorContact.getString(2));
                    listContacts.add(contacto);
                }
            }while(cursorContact.moveToNext());
        }
        cursorContact.close();
        return listContacts;

    }

}
