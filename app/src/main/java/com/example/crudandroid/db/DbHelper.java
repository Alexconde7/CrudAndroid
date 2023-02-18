package com.example.crudandroid.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.example.crudandroid.modelo.ProductoContract;

import java.time.format.DateTimeFormatter;


public class DbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "productos.db";

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");

    private ProductoContract.ProductoEntry pr;

    Context context;


    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + pr.NOMBRE_TABLA + "(" +
                pr.IMAGEN + " text, " +
                pr.COD_BARRA + " primary key, " +
                pr.NOMBRE + " text not null, " +
                pr.PRECIO + " real not null, " +
                pr.CANTIDAD + " integer, " +
                pr.CIF_PROVEEDOR + " text)");

        Toast.makeText(context, "Base de datos creada", Toast.LENGTH_SHORT).show();
    }

/*
    public Cursor getProductos() {
        return getReadableDatabase().query(pr.NOMBRE_TABLA, null, null, null, null, null, null);
    }
*/

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table " + pr.NOMBRE_TABLA);
        onCreate(sqLiteDatabase);
    }
}
