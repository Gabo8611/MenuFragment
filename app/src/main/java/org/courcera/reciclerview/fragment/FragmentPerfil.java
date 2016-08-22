package org.courcera.reciclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.courcera.reciclerview.R;
import org.courcera.reciclerview.adapter.MascotaAdaptador;
import org.courcera.reciclerview.adapter.MascotaPerfilAdaptador;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentPerfil extends Fragment {

    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;

    Bundle parametros;

    public FragmentPerfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        //Recuperacion de parametros en Intent
        //parametros = getIntent().getExtras();

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotasPerfil);
        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //llm.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);

        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        /*mascotas.add(new Mascota(parametros.getString("Mascota1Nombre"), getIntent().getIntExtra("Mascota1Puntuacion",1), getIntent().getIntExtra("Mascota1Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota2Nombre"), getIntent().getIntExtra("Mascota2Puntuacion",1), getIntent().getIntExtra("Mascota2Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota3Nombre"), getIntent().getIntExtra("Mascota3Puntuacion",1), getIntent().getIntExtra("Mascota3Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota4Nombre"), getIntent().getIntExtra("Mascota4Puntuacion",1), getIntent().getIntExtra("Mascota4Foto",R.drawable.g5527)));
        mascotas.add(new Mascota(parametros.getString("Mascota5Nombre"), getIntent().getIntExtra("Mascota5Puntuacion",1), getIntent().getIntExtra("Mascota5Foto",R.drawable.g5527)));
        */

        mascotas.add(new Mascota("Perro1", 1, R.drawable.g5527));
        mascotas.add(new Mascota("Perro2", 3, R.drawable.g5930));
        mascotas.add(new Mascota("Perro3", 2, R.drawable.g5930_2));
        mascotas.add(new Mascota("Perro4", 3, R.drawable.g4657_4));
        mascotas.add(new Mascota("Perro5", 5, R.drawable.g6846));


    }

}
