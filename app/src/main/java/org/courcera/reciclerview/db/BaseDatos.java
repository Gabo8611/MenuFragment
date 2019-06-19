package org.courcera.reciclerview.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {

        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " text, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION + " INTEGER, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN + " INTEGER " +
                                        ")";
        String queryCrearTablaMascotaPuntuacion = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION + "(" +
                ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_ID_MASCOTA+ " INTEGER, " +
                ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_PUNTUACION + " INTEGER " +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaPuntuacion);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL(" DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setPuntuacion(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            /*String queryPuntuaciones = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_PUNTUACION + ") AS puntuaciones " +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosPuntuacion = db.rawQuery(queryPuntuaciones,null);
            if(registrosPuntuacion.moveToNext()){
                mascotaActual.setPuntuacion(registrosPuntuacion.getInt(0));
            }else{
                mascotaActual.setPuntuacion(0);
            }*/

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarMascotaPuntuacion(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION,null, contentValues);
        db.close();

    }

    public void actualizarMascotaPuntuacion(ContentValues contentValues, int mascota_id){
        SQLiteDatabase db = this.getWritableDatabase();
        int respuesta = db.update(ConstantesBaseDatos.TABLE_MASCOTAS, contentValues,ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + mascota_id, null);
        db.close();

    }

    public  int obtenerPuntuacionMAscota(Mascota mascota){
        int puntuaciones = 0;

        /*String query = "SELECT COUNT (" + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_PUNTUACION + ")" +
            " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION +
            " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_ID_MASCOTA + "=" + mascota.getId();
        */

        String query = "SELECT " + ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION  +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTAS +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTAS_ID + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            puntuaciones = registros.getInt(0);
        }
        db.close();

        return puntuaciones;

    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS+
                " ORDER BY puntuacion DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setPuntuacion(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
}
