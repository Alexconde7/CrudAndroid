package com.example.crudandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.crudandroid.adaptadores.ProductosAdapter;
import com.example.crudandroid.databinding.ActivityMainBinding;
import com.example.crudandroid.db.DbProductos;
import com.example.crudandroid.modelo.Producto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding b;

    DbProductos dbProducto;
    List<Producto> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        b =ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        b.rvProductos.setLayoutManager(new LinearLayoutManager(this));

        dbProducto = new DbProductos(this);
        productos = new ArrayList<>();

        ProductosAdapter pa = new ProductosAdapter(dbProducto.mostrar());
        b.rvProductos.setAdapter(pa);
        b.include.tvTitulo.setText(getString(R.string.Productos));
        b.include.bVolver.setVisibility(View.INVISIBLE);

    }

    public void anyadir(View view) {
        Intent intent = new Intent(this, AnyadirProductoActivity.class);
        startActivity(intent);
    }


}