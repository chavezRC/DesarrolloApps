package com.example.alumnoproyecto;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import java.io.*;

import androidx.fragment.app.Fragment;

 class  SerialTest{

    public static void main (String[] args){
        Alumno al = new Alumno();
        al.setNombre("NombrePrueba");
        al.setMatricula(4554);



        try{

            FileOutputStream fileOut=
                    new FileOutputStream("/temp/alumno.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(al);
            out.close();
            fileOut.close();
            System.out.printf("El serializable esta guardado en  /tmp/alumno.ser");
        } catch (IOException i){
            i.printStackTrace();
        }
    }
}

public class AlumnoFragment extends Fragment {
    private Alumno alumno;
    private EditText txtNombre;
    private Button btnDetalle;
    private CheckBox chkActivo;
    private int matricula;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        matricula = getArguments().getInt(Constantes.ID_ALUMNO);
        //int matricula = getActivity().getIntent().getIntExtra(Constantes.ID_ALUMNO, 0);
        alumno = GrupoAlumnos.getGrupo().getAlumno(matricula);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.alumno_fragment, container, false);
        txtNombre = v.findViewById(R.id.txtNombre);
        btnDetalle = v.findViewById(R.id.btnDetalle);
        chkActivo = v.findViewById(R.id.chkActivo);

        chkActivo.setOnCheckedChangeListener(
                (compoundButton, b) -> GrupoAlumnos.getGrupo().getAlumno(matricula).setActivo(b));

        txtNombre.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int before, int count) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                GrupoAlumnos.getGrupo().getAlumno(matricula).setNombre(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        txtNombre.setText(alumno.getNombre());
        chkActivo.setChecked(alumno.isActivo());

        return v;
    }

    public void returnResult(){
        getActivity().setResult(Activity.RESULT_OK, null);
    }

    public static AlumnoFragment newInstanceFragment(int matricula){
        AlumnoFragment fragment = new AlumnoFragment();
        Bundle data = new Bundle();
        data.putInt(Constantes.ID_ALUMNO,matricula);
        fragment.setArguments(data);
        return fragment;
    }
}
