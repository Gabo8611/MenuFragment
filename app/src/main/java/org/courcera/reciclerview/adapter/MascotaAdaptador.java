package org.courcera.reciclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.courcera.reciclerview.pojo.Mascota;
import org.courcera.reciclerview.R;

import java.util.ArrayList;


/**
 * Created by Usuario on 04/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgPrincipal.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(String.valueOf(mascota.getNombre()));
        mascotaViewHolder.tvPuntuacion.setText(String.valueOf(mascota.getPuntuacion()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPrincipal;
        private TextView tvNombre;
        private TextView tvPuntuacion;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgPrincipal = (ImageView)itemView.findViewById(R.id.imgPrincipal);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvPuntuacion = (TextView) itemView.findViewById(R.id.tvPuntuacion);
        }
    }

}
