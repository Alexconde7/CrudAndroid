package com.example.crudandroid.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crudandroid.AnyadirProductoActivity;
import com.example.crudandroid.databinding.ElementoListaProductosBinding;
import com.example.crudandroid.modelo.Producto;
import com.example.crudandroid.verActivity;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder> {

    List<Producto> productos;

    public ProductosAdapter(List<Producto> productos) {
        this.productos = productos;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ProductosViewHolder(ElementoListaProductosBinding.inflate(LayoutInflater.from(parent.getContext())));
    }


    @Override
    public void onBindViewHolder(@NonNull ProductosViewHolder holder, int position) {
        holder.b.tvCodBarra.setText(Integer.toString((productos.get(position).getCodBarra())));
        holder.b.tvNombre.setText(productos.get(position).getNombre());
        holder.b.tvPrecio.setText(Float.toString(productos.get(position).getPrecio()));
        holder.b.tvCantidad.setText(Integer.toString(productos.get(position).getCantidad()));
        holder.b.tvCifProveedor.setText(productos.get(position).getCifProveedor());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        ElementoListaProductosBinding b;

        public ProductosViewHolder(ElementoListaProductosBinding b) {
            super(b.getRoot());
            this.b = b;
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = itemView.getContext();
                    Intent intent = new Intent(context, verActivity.class);



                }
            });

        }
    }
}
