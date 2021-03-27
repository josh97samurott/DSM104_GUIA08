package com.example.dsm104_guia08;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.dsm104_guia08.datos.Persona;

public class AddPersonaActivity extends AppCompatActivity {
    EditText edtDUI, edtNombre, edtFechaNacimiento, edtGenero, edtPeso, edtAltura;
    String key="",nombre="",dui="",accion="", fecha_nacimiento="", genero="", peso="", altura="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        edtGenero = findViewById(R.id.edtGenero);
        edtAltura = findViewById(R.id.edtAltura);
        edtPeso = findViewById(R.id.edtPeso);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        accion=datos.getString("accion");
        fecha_nacimiento=datos.getString("fecha_nacimiento");
        genero=datos.getString("genero");
        peso=datos.getString("peso");
        altura=datos.getString("altura");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
        edtFechaNacimiento.setText(fecha_nacimiento);
        edtPeso.setText(peso);
        edtAltura.setText(altura);
        edtGenero.setText(genero);

    }

    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String fecha_nacimiento = edtFechaNacimiento.getText().toString();
        String genero = edtGenero.getText().toString();
        String peso = edtPeso.getText().toString();
        String altura = edtAltura.getText().toString();

        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre, fecha_nacimiento, genero, peso, altura);

        if (accion.equals("a")) { //Agregar usando push()
            PersonasActivity.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            PersonasActivity.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


}