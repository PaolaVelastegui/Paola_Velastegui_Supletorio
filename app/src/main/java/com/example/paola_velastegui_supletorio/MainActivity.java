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

    EditText cedula,contraseña;
    String textCedula,textContrasenia;
    Button aceptar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        cedula = findViewById(R.id.editText_correo);
        contraseña = findViewById(R.id.editText_contrasenia);
        aceptar = findViewById(R.id.button_iniciar_sesion);

        aceptar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                textCedula = cedula.getText().toString();
                textContrasenia = contraseña.getText().toString();


                if(!verificarCedVLJP(textCedula)){
                    cedula.setError("Cedula Incorrecta");
                    cedula.requestFocus();
                }else if (textContrasenia.isEmpty()){
                    contraseña.setError("Intente ingresar su contraseña");
                    contraseña.requestFocus();
                }else{
                    IngresarFirebase(textCedula,textContrasenia);
                }
            }
        });
    }

    private void IngresarFirebase(String correob,String contraseñab) {
        Toast.makeText(MainActivity.this, textCedula+textContrasenia,
                Toast.LENGTH_SHORT).show();
    }

    private boolean verificarCedVLJP(String cedula){
        byte sum = 0;
        Toast.makeText(MainActivity.this, String.valueOf(cedula.trim().length()),
                Toast.LENGTH_SHORT).show();
        try {
            if (cedula.trim().length() != 10){
                return false;}
            String[] data = cedula.split("");
            byte verifier = Byte.parseByte(data[0] + data[1]);
            if (verifier < 1 || verifier > 24){
                return false;}
            byte[] digits = new byte[data.length];
            for (byte i = 0; i < digits.length; i++){
                digits[i] = Byte.parseByte(data[i]);}
            if (digits[2] > 6){
                return false;}
            for (byte i = 0; i < digits.length - 1; i++) {
                if (i % 2 == 0) {
                    verifier = (byte) (digits[i] * 2);
                    if (verifier > 9)
                        verifier = (byte) (verifier - 9);
                } else
                    verifier = (byte) (digits[i] * 1);
                sum = (byte) (sum + verifier);
            }
            if ((sum - (sum % 10) + 10 - sum) == digits[9]){

                return true;}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
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
           // startActivity(new Intent(MainActivity.this,MainActivity2.class));
            //finish();
        //}
    }


}