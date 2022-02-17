package com.example.paola_velastegui_supletorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.UUID;

public class AgregarTareas extends AppCompatActivity {


    private Spinner spinner_elemento;
    private EditText titulo,descripcion;
    private Button agregar, cancelar;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_tareas);
        spinner_elemento = findViewById(R.id.spinner);
        titulo = findViewById(R.id.editTextTitulo);
        descripcion = findViewById(R.id.editTextTextdescripcion);
        agregar = findViewById(R.id.Agregar_button);
        cancelar = findViewById(R.id.cancelar_boton);
        String [] tipos ={ "Personal","Business"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,tipos);
        spinner_elemento.setAdapter(adapter);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregartarea();
            }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void agregartarea() {

        Tarea tarea = new Tarea();
        tarea.setTitulo(titulo.getText().toString());
        tarea.setDescripcion(descripcion.getText().toString());
        tarea.setUid(UUID.randomUUID().toString());
        tarea.setCompletado(false);
        String selecion = spinner_elemento.getSelectedItem().toString();
        if(selecion.equals("Personal")){
            tarea.setTipo("p");
        }else{
            tarea.setTipo("b");
        }
        //FirebaseUser user = mAuth.getCurrentUser();
        //databaseReference.child(user.getUid()).child("Tareas").child(tarea.getUid()).setValue(tarea);
        finish();
    }


}