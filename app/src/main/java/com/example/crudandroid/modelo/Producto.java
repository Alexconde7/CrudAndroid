package com.example.crudandroid.modelo;

import android.content.ContentValues;

public class Producto {

    private String imagen;
    private int codBarra;
    private String nombre;
    private float precio;
    private int cantidad;
    String cifProveedor;


    private ProductoContract.ProductoEntry pr;

    public Producto(String imagen, int codBarra, String nombre, float precio, int cantidad, String cifProveedor) {
        this.imagen = imagen;
        this.codBarra = codBarra;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.cifProveedor = cifProveedor;
    }

    public ContentValues toContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(pr.IMAGEN, imagen);
        cv.put(pr.COD_BARRA, codBarra);
        cv.put(pr.NOMBRE, nombre);
        cv.put(pr.PRECIO, precio);
        cv.put(pr.CANTIDAD, cantidad);
        cv.put(pr.CIF_PROVEEDOR, cifProveedor);

        return cv;
    }

    public int getCodBarra() {
        return codBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getCifProveedor() {
        return cifProveedor;
    }

    public String getImagen() {
        return imagen;
    }

    public float getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codBarra=" + codBarra +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", cifProveedor=" + cifProveedor +
                '}';
    }
}
