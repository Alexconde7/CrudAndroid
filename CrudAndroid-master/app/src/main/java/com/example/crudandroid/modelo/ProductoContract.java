package com.example.crudandroid.modelo;

import android.provider.BaseColumns;

public class ProductoContract {

    public static abstract class ProductoEntry implements BaseColumns{

        public static final String NOMBRE_TABLA ="Productos";

        public static final String IMAGEN = "imagen";
        public static final String COD_BARRA = "codBarra";
        public static final String NOMBRE = "nombre";
        public static final String PRECIO = "precio";
        public static final String CANTIDAD = "cantidad";
        public static final String CIF_PROVEEDOR = "cifProveedor";


    }

}
