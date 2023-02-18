package com.example.crudandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crudandroid.databinding.ActivityInicioSesionBinding;

public class InicioSesion extends AppCompatActivity {

    static final String USUARIO = "a";
    static final String CONTRASENYA = "a";

    ActivityInicioSesionBinding b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        b = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());
    }

    public void entrar(View view) {
        if (verificar()) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Credenciales Incorrectos, inténtelo de nuevo", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean verificar() {
        if (!b.etEmailNombre.getText().toString().equals(USUARIO) &&
                !b.etContra.getText().toString().equals(CONTRASENYA))
            return false;
        else
            return true;
    }

    public void registrarme(View view) {
        Intent intent = new Intent(this, Registracion.class);
        startActivity(intent);
    }

    public void proximamente(View view) {
        Toast.makeText(this, "Próximamente", Toast.LENGTH_SHORT).show();
    }
}