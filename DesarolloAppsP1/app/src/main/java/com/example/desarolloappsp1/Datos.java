package com.example.desarolloappsp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class Datos extends AppCompatActivity {


    EditText dfnombreAuditor,dfEmpresa,dfCantidad,dfActivos,dfCantidadBalance,dfEjercicioTotal;
    Button dfbtnConfirmar;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);


        dfnombreAuditor = findViewById(R.id.dfnombre);
        dfEmpresa=findViewById(R.id.dftelefono);
        dfCantidad=findViewById(R.id.dfCantidad);
        dfActivos=findViewById(R.id.dfCantidadBalance);
        dfCantidadBalance=findViewById(R.id.dfpasscrear);
        dfbtnConfirmar=findViewById(R.id.dfbtnConfirmar);
        dfEjercicioTotal=findViewById(R.id.dfEjercicioTotal);



        //validacion

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.setColor(Color.RED);

        //agregar validacones para nombre

        awesomeValidation.addValidation(this,R.id.dfnombreAuditor, RegexTemplate.NOT_EMPTY,R.string.nombre_ivalido);
        //Valida valida
        awesomeValidation.addValidation(this,R.id.dfEmpresa,RegexTemplate.NOT_EMPTY,R.string.nombreEmpresaInvalido);
        //valida
        awesomeValidation.addValidation(this,R.id.dfCantidad, Patterns.EMAIL_ADDRESS, R.string.correoInvalido);
        //valida
        awesomeValidation.addValidation(this,R.id.dfActivos,".{6,}",R.string.passwordInvalido);





        dfbtnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (awesomeValidation.validate()){
                    Toast.makeText(getApplicationContext(), "Validacion correcta", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Validacion ha fallado", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void changeAcit(){
        Intent intent = new Intent(this,DatosMain2.class);
        startActivity(intent);

    }
}