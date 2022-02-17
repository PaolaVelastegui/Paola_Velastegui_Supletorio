package com.example.paola_velastegui_supletorio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.paola_velastegui_supletorio.db.usuarios;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText cedula,contraseña;
    String textCedula,textContrasenia;
    Button aceptar, registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cedula = findViewById(R.id.editText_correo);
        contraseña = findViewById(R.id.editText_contrasenia);
        aceptar = findViewById(R.id.button_iniciar_sesion);
        registro = findViewById(R.id.button_registrarse);


        aceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textCedula = cedula.getText().toString();
                textContrasenia = contraseña.getText().toString();

                if(!verificarCedVLJP(textCedula)){
                    cedula.setError("Cedula Incorrecta");
                    cedula.requestFocus();
                }else if (textContrasenia.isEmpty()){
                    contraseña.setError("Contraseña incorrecta contraseña");
                    contraseña.requestFocus();
                }else{
                    Intent intentTarea = new Intent(MainActivity.this, MainActivity2.class);
                    startActivity(intentTarea);
                }
            }

        });

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textCedula = cedula.getText().toString();
                textContrasenia = contraseña.getText().toString();

                if(!verificarCedVLJP(textCedula)) {
                    cedula.setError("Cedula Incorrecta");
                    cedula.requestFocus();
                }else if (textContrasenia.isEmpty()) {
                    contraseña.setError("Ingrese contraseña");
                    contraseña.requestFocus();
                }else if(!validarClave(textContrasenia)){
                    contraseña.setError("Intente ingresar su contraseña");
                    contraseña.requestFocus();
                }else{
                     try{
                         usuarios dbUsers = new usuarios(MainActivity.this);
                         long id = dbUsers.insertarContactos(textCedula,textContrasenia);
                         if(id != 0){
                             Toast.makeText(MainActivity.this, "Registro Guardado",Toast.LENGTH_LONG).show();
                             Intent intentTarea = new Intent(MainActivity.this, MainActivity2.class);
                             startActivity(intentTarea);
                         }else{
                             Toast.makeText(MainActivity.this,"NO se guardo el registro", Toast.LENGTH_LONG).show();
                         }
                     }catch (Exception e){
                         Toast.makeText(MainActivity.this,"NO se guardo el registro", Toast.LENGTH_LONG).show();
                     }


                }

            }
        });

    }

    private void IngresarFirebase(String correob,String contraseñab) {
        Toast.makeText(MainActivity.this, textCedula+textContrasenia,
                Toast.LENGTH_SHORT).show();
    }

    public boolean validarClave(String clave) {
        boolean valida;

        String[] claveSeparada = clave.split("");


        Pattern pat = Pattern.compile("[a-z]");
        Pattern pat2 = Pattern.compile("[A-Z]");
        Pattern pat3 = Pattern.compile("[0-9]");
        Pattern pat4 = Pattern.compile("[./';:&^%$@!~`|_{}()=+*<>#]");


        Matcher mat = pat.matcher(clave);
        Matcher mat2 = pat2.matcher(clave);
        Matcher mat3 = pat3.matcher(clave);
        Matcher mat4 = pat4.matcher(clave);

        if(claveSeparada.length >= 4){
            if(mat.find() && mat2.find() && mat3.find() && mat4.find()){
                valida = true;
            }else{
                valida = false;
            }
        }else{
            valida = false;
        }
        return valida;
    }

    public boolean verificarContraseñaVLJP(String dato){
        return  dato.matches("^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{6,10}$"); //Validar contraseña
    }
    public boolean verificarCedVLJP(String x){
        int suma = 0;
        if (x.length() == 9) {

            return false;
        } else {
            int a[] = new int[x.length() / 2];
            int b[] = new int[(x.length() / 2)];
            int c = 0;
            int d = 1;
            for (int i = 0; i < x.length() / 2; i++) {
                a[i] = Integer.parseInt(String.valueOf(x.charAt(c)));
                c = c + 2;
                if (i < (x.length() / 2) - 1) {
                    b[i] = Integer.parseInt(String.valueOf(x.charAt(d)));
                    d = d + 2;
                }
            }
            for (int i = 0; i < a.length; i++) {
                a[i] = a[i] * 2;
                if (a[i] > 9) {
                    a[i] = a[i] - 9;
                }
                suma = suma + a[i] + b[i];
            }
            int aux = suma / 10;
            int dec = (aux + 1) * 10;
            if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length() - 1))))
                return true;
            else if (suma % 10 == 0 && x.charAt(x.length() - 1) == '0') {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        UsuarioLogeado();
    }

    private void UsuarioLogeado(){
        //if(true){
            //Toast.makeText(MenuPrincipal.this, "Usuario logeado", Toast.LENGTH_SHORT).show();
       // }else{
            //startActivity(new Intent(MainActivity.this,MainActivity2.class));
            //finish();
        //}
    }


}