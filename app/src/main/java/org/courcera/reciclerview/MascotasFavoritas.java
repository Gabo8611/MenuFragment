package org.courcera.reciclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.courcera.reciclerview.adapter.MascotaAdaptador;
import org.courcera.reciclerview.fragment.IFragmentRecyclerViewView;
import org.courcera.reciclerview.pojo.Mascota;
import org.courcera.reciclerview.presentador.IRecyclerViewFragmentPresenter;
import org.courcera.reciclerview.presentador.MascotasFavoritasPresenter;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity implements IFragmentRecyclerViewView {

    ArrayList<Mascota> mascotas;
    RecyclerView listaMascotas;
    Bundle parametros;
    private IRecyclerViewFragmentPresenter presenter;

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

        //listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new MascotasFavoritasPresenter(this, this);

    }



    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
