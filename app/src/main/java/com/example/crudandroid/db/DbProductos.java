package com.example.crudandroid.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import com.example.crudandroid.modelo.Producto;
import com.example.crudandroid.modelo.ProductoContract;

import java.util.ArrayList;

public class DbProductos extends DbHelper {

    private Context context;

    private ProductoContract.ProductoEntry pr;

    public DbProductos(Context context) {
        super(context);
        this.context = context;
    }


    public long anyadir(Producto producto) {
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            id = db.insert(pr.NOMBRE_TABLA, null, producto.toContentValues());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    public ArrayList<Producto> mostrar() {
        ArrayList<Producto> productos = new ArrayList<>();

        Cursor cursor = getReadableDatabase().rawQuery("select * from " + pr.NOMBRE_TABLA, null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                productos.add(new Producto(
                        cursor.getString(0),
                        cursor.getInt(1),
                        cursor.getString(2),
                        cursor.getFloat(3),
                        cursor.getInt(4),
                        cursor.getString(5)));
            }
        }
        cursor.close();

        return productos;
    }
}
