package com.example.registrounsaaplication;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList <Postulante> listaPostulantes = new ArrayList<Postulante>();

        EditText apePat = findViewById(R.id.ApePat);
        EditText apeMat = findViewById(R.id.ApeMat);
        EditText nombres = findViewById(R.id.Nom);
        EditText fecNac = findViewById(R.id.Nac);
        EditText colegio = findViewById(R.id.Cole);
        EditText carrera = findViewById(R.id.Carr);

        Button btnRegistrar = (Button) findViewById(R.id.btnRegistrar);
        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String apePaterno= apePat.getText().toString();
                String apeMaterno= apeMat.getText().toString();
                String nomAlum= nombres.getText().toString();
                String fechNaci= fecNac.getText().toString();
                String calPro= colegio.getText().toString();
                String carPos= carrera.getText().toString();

                listaPostulantes.add(new Postulante(apePaterno, apeMaterno, nomAlum, fechNaci, calPro, carPos));

                Log.d("TAG", "Apellido Paterno: "+apePaterno);
                Log.d("TAG", "Apellido Materno: "+apeMaterno);
                Log.d("TAG", "Nombres: "+nomAlum);
                Log.d("TAG", "Fecha de Nacimiento: "+fechNaci);
                Log.d("TAG", "Colegio de Procedencia: "+calPro);
                Log.d("TAG", "Carrera a la que Postula: "+carPos);

                Toast.makeText(getApplicationContext(), "Postulante registrado exitosamente" , Toast.LENGTH_SHORT).show();
            }
        });

        Button btnListar = (Button) findViewById(R.id.btnListar);
        btnListar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                for(Postulante p: listaPostulantes){
                    Log.d("TAG","Apellidos y Nombres: "+ p.getApellidoPaterno() + p.getApellidoMaterno() + ", " + p.getNombres() + "\n Fecha de Nacimiento: " + p.getCarreraPostula() + "\nColegio de Procedencia: " + p.getColegioProcedencia() + "\nCarrera a la que postula: " + p.getCarreraPostula());
                }
        }
    });
    }
}