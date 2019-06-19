package org.courcera.reciclerview.presentador;

import android.content.Context;

import org.courcera.reciclerview.db.ConstructorMascotas;
import org.courcera.reciclerview.fragment.IFragmentRecyclerViewView;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritasPresenter implements IRecyclerViewFragmentPresenter {
    private IFragmentRecyclerViewView iFragmentRecyclerViewView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFavoritasPresenter(IFragmentRecyclerViewView iFragmentRecyclerViewView, Context context) {
        this.iFragmentRecyclerViewView = iFragmentRecyclerViewView;
        this.context = context;
        obternerMascotasBaseDatos();
    }

    @Override
    public void obternerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerMascotasFavoritas();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFragmentRecyclerViewView.inicializarAdaptadorRV(iFragmentRecyclerViewView.crearAdaptador(mascotas));
        iFragmentRecyclerViewView.generarLinearLayoutVertical();
    }
}
