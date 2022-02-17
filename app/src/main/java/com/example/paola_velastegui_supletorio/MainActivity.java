package com.example.paola_velastegui_supletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText correo,contraseña;
    String textCorreo,textContrasenia;
    Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        correo = findViewById(R.id.editText_correo);
        contraseña = findViewById(R.id.editText_contrasenia);
        aceptar = findViewById(R.id.button_iniciar_sesion);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textCorreo = correo.getText().toString();
                textContrasenia = contraseña.getText().toString();
                if(!Patterns.EMAIL_ADDRESS.matcher(textCorreo).matches()){
                    correo.setError("Verfifica que el correo esté bien escrito");
                    correo.requestFocus();
                }else if (textContrasenia.isEmpty()){
                    contraseña.setError("Intente ingresar su contraseña");
                    contraseña.requestFocus();
                }else{
                    IngresarFirebase(textCorreo,textContrasenia);
                }
            }


        });
    }

    private void IngresarFirebase(String correob,String contraseñab) {
        Toast.makeText(MainActivity.this, textCorreo+textContrasenia,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();
        UsuarioLogeado();
    }
    private void UsuarioLogeado(){
        if(true){
            //Toast.makeText(MenuPrincipal.this, "Usuario logeado", Toast.LENGTH_SHORT).show();
        }else{
            startActivity(new Intent(MainActivity.this,MainActivity2VLJP.class));
            finish();
        }
    }


}