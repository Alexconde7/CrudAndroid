package com.example.crudandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudandroid.databinding.ActivityRegistracionBinding;
import com.example.crudandroid.modelo.Usuario;

import java.util.ArrayList;
import java.util.List;

public class Registracion extends AppCompatActivity {

    private static final String ER_CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    List<EditText> ets;
    List<Usuario> usuarios;

    ActivityRegistracionBinding b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityRegistracionBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        usuarios = new ArrayList<>();

        ets = List.of(b.etEmail,
                b.etNombre,
                b.etApellidos,
                b.etContra,
                b.etConfirmarContra
        );


    }

    public void registrar(View view) {
        boolean valido = inputValido(ets);
        if (valido) {
            usuarios.add(new Usuario(b.etEmail.getText().toString(), b.etNombre.getText().toString()
                    , b.etApellidos.getText().toString(), b.etContra.getText().toString()
                    , b.etConfirmarContra.getText().toString()));

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();

            System.out.println(usuarios);
        }
    }

    private boolean inputValido(List<EditText> ets) {
        for (EditText e : ets) {
            if (e.getText().toString().trim().isEmpty()) {
                e.setError("Este campo no puede estar vacío");
                return false;
            }
        }

        if (!b.etEmail.getText().toString().matches(ER_CORREO)) {
            b.etEmail.setError("Formato de email inválido");
            return false;
        }

        if (!b.etContra.getText().toString().equals(b.etConfirmarContra.getText().toString())) {
            b.etConfirmarContra.setError("Las contraseñas deben coincidir");
            return false;
        }

        Toast.makeText(this, "Datos correctos, usuario creado", Toast.LENGTH_SHORT).show();
        return true;
    }

    public void proximamente(View view) {
        Toast.makeText(this, "Próximamente", Toast.LENGTH_SHORT).show();
    }
}