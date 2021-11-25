package com.example.alumnoproyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import  java.io.*;

import android.os.Bundle;

public class Deserializado{
    public static void main(String [] args) {
        Alumno al = null;
        try {
            FileInputStream fileIn = new FileInputStream("/tmp/alumno.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            al = (Alumno) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Imposble encontrar al alumno");
            c.printStackTrace();
            return;
        }

        System.out.println("Datpos de Alumno");
        System.out.println("Nombre: " + al.getNombre());
        System.out.println("Matrcula: " + al.getMatricula());

    }
}

}


public class AlumnoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.alumno_fragment_container);
        if (fragment == null){
            fragment = new AlumnoFragment();
            Bundle data = new Bundle();
            int matricula = getIntent().getIntExtra(Constantes.ID_ALUMNO, -1);
            data.putInt(Constantes.ID_ALUMNO,matricula);
            fragment.setArguments(data);
            fm.beginTransaction().add(R.id.alumno_fragment_container, fragment).commit();
        }
    }



}