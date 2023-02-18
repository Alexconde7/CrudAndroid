package com.example.crudandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.crudandroid.databinding.ActivityAnyadirProductoBinding;
import com.example.crudandroid.db.DbProductos;
import com.example.crudandroid.modelo.Producto;

public class AnyadirProductoActivity extends AppCompatActivity {

    ActivityAnyadirProductoBinding b;

    DbProductos db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityAnyadirProductoBinding.inflate(getLayoutInflater());
        db = new DbProductos(this);
        setContentView(b.getRoot());

        b.include.tvTitulo.setText("");
        b.include.bVolver.setOnClickListener(v -> {
            volverAMain();
        });
    }




    public void anyadir(View view) {
        try {
            db.anyadir(new Producto(
                    "",
                    Integer.parseInt(b.etCodBarra.getText().toString()),
                    b.etNombre.getText().toString(),
                    Float.parseFloat(b.etPrecio.getText().toString()),
                    Integer.parseInt(b.etCantidad.getText().toString()),
                    b.etCif.getText().toString()));
            Toast.makeText(this, "Producto insertado", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        volverAMain();
    }



    private void volverAMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}