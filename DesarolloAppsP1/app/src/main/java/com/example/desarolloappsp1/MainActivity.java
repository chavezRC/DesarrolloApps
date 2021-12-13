package com.example.desarolloappsp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

   


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        TextView usuario = (TextView)findViewById(R.id.usuario);
        TextView contrasena = (TextView)findViewById(R.id.contrasena);


        MaterialButton btnEntrar = (MaterialButton) findViewById(R.id.btnEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (usuario.getText().toString().equals("Ricardo") && contrasena.getText().equals("3nt3r4pp")){


                Toast.makeText(MainActivity.this, "Usuario Correcto", Toast.LENGTH_SHORT).show();

                changeActivity();
            }else{
                    Toast.makeText(MainActivity.this, "Datos incorrectos", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void changeActivity(){
        Intent intent = new Intent(this,Datos.class);
        startActivity(intent);

    }
}