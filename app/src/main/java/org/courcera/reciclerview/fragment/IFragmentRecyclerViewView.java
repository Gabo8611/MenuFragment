package org.courcera.reciclerview.fragment;

import org.courcera.reciclerview.adapter.MascotaAdaptador;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;

public interface IFragmentRecyclerViewView {
    public void generarLinearLayoutVertical();
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
