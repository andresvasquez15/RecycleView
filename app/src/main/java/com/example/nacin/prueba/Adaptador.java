package com.example.nacin.prueba;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by NACIÓN on 13/06/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.AdaptadorHolder> {

    Context context;
    ArrayList<Datos> datoses;

    public Adaptador(Context context, ArrayList<Datos> datoses) {
        this.context = context;
        this.datoses = datoses;
    }

    @Override
    public AdaptadorHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista, parent, false);

        AdaptadorHolder holder = new AdaptadorHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(AdaptadorHolder holder, int position) {

        Datos datos = datoses.get(position);

        holder.id.setText("Id: "+datos.getDatos_id());
        Picasso.with(context).load(datos.getDatos_imagen()).into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return datoses.size();
    }

    public class AdaptadorHolder extends RecyclerView.ViewHolder {
        TextView id;
        ImageView imagen;

        public AdaptadorHolder(View itemView) {
            super(itemView);

            id = (TextView) itemView.findViewById(R.id.id);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
        }
    }
}
