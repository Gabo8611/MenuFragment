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

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotasPerfil);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(parametros.getString("Mascota1Nombre"), getIntent().getIntExtra("Mascota1Puntuacion",1), getIntent().getIntExtra("Mascota1Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota2Nombre"), getIntent().getIntExtra("Mascota2Puntuacion",1), getIntent().getIntExtra("Mascota2Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota3Nombre"), getIntent().getIntExtra("Mascota3Puntuacion",1), getIntent().getIntExtra("Mascota3Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota4Nombre"), getIntent().getIntExtra("Mascota4Puntuacion",1), getIntent().getIntExtra("Mascota4Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota5Nombre"), getIntent().getIntExtra("Mascota5Puntuacion",1), getIntent().getIntExtra("Mascota5Foto",R.drawable.g5527)));
    }


}
