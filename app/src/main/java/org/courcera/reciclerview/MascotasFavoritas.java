package org.courcera.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.courcera.reciclerview.adapter.MascotaAdaptador;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    Bundle parametros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        if (toolbar != null) {
            // Up navigation to the parent activity for 4.0 and earlier
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }

        //Recuperacion de parametros en Intent
        parametros = getIntent().getExtras();

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas2);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Perro1", 1, R.drawable.g5527));
        mascotas.add(new Mascota("Perro2", 3, R.drawable.g5930));
        mascotas.add(new Mascota("Perro3", 2, R.drawable.g5930_2));
        mascotas.add(new Mascota("Perro4", 3, R.drawable.g4657_4));
        mascotas.add(new Mascota("Perro5", 5, R.drawable.g6846));
    }


}
