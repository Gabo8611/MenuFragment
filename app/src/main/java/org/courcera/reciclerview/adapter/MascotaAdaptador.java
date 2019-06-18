package org.courcera.reciclerview.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.courcera.reciclerview.db.ConstructorMascotas;
import org.courcera.reciclerview.pojo.Mascota;
import org.courcera.reciclerview.R;

import java.util.ArrayList;


/**
 * Created by Usuario on 04/06/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgPrincipal.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombre.setText(String.valueOf(mascota.getNombre()));
        mascotaViewHolder.tvPuntuacion.setText(String.valueOf(mascota.getPuntuacion()));

        mascotaViewHolder.imgPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, mascota.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

        mascotaViewHolder.imgHuesoIzquierdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darPuntuacionMascota(mascota);
                mascotaViewHolder.tvPuntuacion.setText(String.valueOf(constructorMascotas.obtenerPuntuacionMascota(mascota)));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPrincipal;
        private TextView tvNombre;
        private TextView tvPuntuacion;
        private ImageView imgHuesoIzquierdo;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgPrincipal = (ImageView)itemView.findViewById(R.id.imgPrincipal);
            tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvPuntuacion = (TextView) itemView.findViewById(R.id.tvPuntuacion);
            imgHuesoIzquierdo = (ImageView)itemView.findViewById(R.id.imgHuesoIzquierdo);
        }
    }

}
