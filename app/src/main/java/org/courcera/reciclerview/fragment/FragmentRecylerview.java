package org.courcera.reciclerview.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.courcera.reciclerview.R;
import org.courcera.reciclerview.adapter.MascotaAdaptador;
import org.courcera.reciclerview.pojo.Mascota;
import org.courcera.reciclerview.presentador.IRecyclerViewFragmentPresenter;
import org.courcera.reciclerview.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentRecylerview extends Fragment  implements IFragmentRecyclerViewView{

    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;

    public FragmentRecylerview() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recylerview, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
        // Inflate the layout for this fragment
        return v;


    }


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
