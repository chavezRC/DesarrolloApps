package com.example.desarolloappsp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.android.material.button.MaterialButton;

public class DatosMain2 extends AppCompatActivity {

    EditText dfNumeroEjercicio,dfCuenta,dfNumeroCuentaCantidadBalance,dfDepartamento,dfResponsable;

    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_main2);

        dfNumeroEjercicio= findViewById(R.id.dfNumeroEjercicio);
        dfCuenta= findViewById(R.id.dfCuenta);
        dfNumeroCuentaCantidadBalance=findViewById(R.id.dfNumeroCuentaCantidadBalance);
        dfDepartamento=findViewById(R.id.dfDepartamento);
        dfResponsable=findViewById(R.id.dfResponsable);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.setColor(Color.RED);

        //MaterialButton btnEntrar = (MaterialButton) findViewById(R.id.btnEntrar);

        //btnEntrar.setOnClickListener(new View.OnClickListener() {

        MaterialButton dfbtnSalvar = (MaterialButton) findViewById(R.id.dfbtnSalvar);

        dfbtnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }

    private void changeActivity(){

        Intent intent = new Intent(this,Exito.class);
        startActivity(intent);

    }
}