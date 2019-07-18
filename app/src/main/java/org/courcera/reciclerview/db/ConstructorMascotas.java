package org.courcera.reciclerview.db;

import android.content.ContentValues;
import android.content.Context;


import org.courcera.reciclerview.R;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {
    private static final int LIKE = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Perro1", 1, R.drawable.g5527));
        mascotas.add(new Mascota("Perro2", 3, R.drawable.g5930));
        mascotas.add(new Mascota("Perro3", 2, R.drawable.g5930_2));
        mascotas.add(new Mascota("Perro4", 3, R.drawable.g4657_4));
        mascotas.add(new Mascota("Perro5", 5, R.drawable.g6846));

        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodasLasMascotas();

    }
    public void insertarTresContactos(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota1");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.g5527);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota2");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.g5930);
        db.insertarMascota(contentValues);

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Mascota3");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION, 0);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_IMAGEN, R.drawable.g5930_2);
        db.insertarMascota(contentValues);
    }

    public void darPuntuacionMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_PUNTUACION_PUNTUACION, LIKE);
        db.insertarMascotaPuntuacion(contentValues);
    }

    public int obtenerPuntuacionMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerPuntuacionMAscota(mascota);
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerMascotasFavoritas();
    }

    public void actualizarPuntuacionMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_PUNTUACION, obtenerPuntuacionMascota(mascota)+1);
        db.actualizarMascotaPuntuacion(contentValues,mascota.getId());

    }
}
