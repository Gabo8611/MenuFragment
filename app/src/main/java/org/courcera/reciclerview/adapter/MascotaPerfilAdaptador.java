package org.courcera.reciclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.courcera.reciclerview.R;
import org.courcera.reciclerview.pojo.Mascota;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Usuario on 17/06/2016.
 */
public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder>  {

    ArrayList<Mascota> mascotas;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas){this.mascotas = mascotas; }

    @Override
    public MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota,parent,false);
        return new MascotaPerfilViewHolder(v);
    }


    @Override
    public void onBindViewHolder(MascotaPerfilViewHolder mascotaPerfilViewHolder, int position) {
        Mascota mascota = mascotas.get(position);
        mascotaPerfilViewHolder.imgPrincipalPerfil.setImageResource(mascota.getFoto());
        //mascotaPerfilViewHolder.tvNombrePerfil.setText(String.valueOf(mascota.getNombre()));
        mascotaPerfilViewHolder.tvPuntuacionPerfil.setText(String.valueOf(mascota.getPuntuacion()));
    }

    @Override
    public int getItemCount() {return mascotas.size();}

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPrincipalPerfil;
        //private TextView tvNombrePerfil;
        private TextView tvPuntuacionPerfil;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            imgPrincipalPerfil = (ImageView)itemView.findViewById(R.id.imgPrincipalPerfil);
            //tvNombrePerfil = (TextView)itemView.findViewById(R.id.tvNombrePerfil);
            tvPuntuacionPerfil = (TextView) itemView.findViewById(R.id.tvPuntuacionPerfil);
        }
    }
}
