package org.courcera.reciclerview;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ToolbarWidgetWrapper;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    private ImageView ivRatingTB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivRatingTB = (ImageView)findViewById(R.id.ivRatingTB);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


        //Evento click a rating
        ivRatingTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MascotasFavoritas.class );
                i.putExtra("Mascota1Nombre",mascotas.get(0).getNombre());
                i.putExtra("Mascota1Puntuacion",mascotas.get(0).getPuntuacion());
                i.putExtra("Mascota1Foto",mascotas.get(0).getFoto());

                i.putExtra("Mascota2Nombre",mascotas.get(1).getNombre());
                i.putExtra("Mascota2Puntuacion",mascotas.get(1).getPuntuacion());
                i.putExtra("Mascota2Foto",mascotas.get(1).getFoto());

                i.putExtra("Mascota3Nombre",mascotas.get(2).getNombre());
                i.putExtra("Mascota3Puntuacion",mascotas.get(2).getPuntuacion());
                i.putExtra("Mascota3Foto",mascotas.get(2).getFoto());

                i.putExtra("Mascota4Nombre",mascotas.get(3).getNombre());
                i.putExtra("Mascota4Puntuacion",mascotas.get(3).getPuntuacion());
                i.putExtra("Mascota4Foto",mascotas.get(3).getFoto());

                i.putExtra("Mascota5Nombre",mascotas.get(4).getNombre());
                i.putExtra("Mascota5Puntuacion",mascotas.get(4).getPuntuacion());
                i.putExtra("Mascota5Foto",mascotas.get(4).getFoto());
                startActivity(i);
            }
        });

    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Perro1", 1, R.drawable.g5527));
        mascotas.add(new Mascota("Perro2", 3, R.drawable.g5930));
        mascotas.add(new Mascota("Perro3", 2, R.drawable.g5930_2));
        mascotas.add(new Mascota("Perro4", 3, R.drawable.g4657_4));
        mascotas.add(new Mascota("Perro5", 5, R.drawable.g6846));
    }

    public void agregarFAB(){
        FloatingActionButton miFAB = (FloatingActionButton)findViewById(R.id.fab);
        miFAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Funcion para la cámara
            }
        });
    }


}
