package josedlujan.app.recetas.com.recetasapp;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jose on 11/05/17.
 */

public class RecetasAdapter extends RecyclerView.Adapter<RecetasAdapter.ViewHolder>  {
    Context context;
    List<Receta> recetas;

    public RecetasAdapter(Context context, List<Receta> recetas){
        this.context = context;
        this.recetas = recetas;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recetaitem,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.nombre.setText(recetas.get(position).getNombre());
        holder.personas.setText("Personas: "+String.valueOf(recetas.get(position).getPersonas()));
        holder.descripcion.setText(recetas.get(position).getDescripcion());
        holder.preparacion.setText(recetas.get(position).getPreparacion());

        if(recetas.get(position).getFav() == 1){
            holder.star.setImageResource(R.drawable.yellow);
        }else{
            holder.star.setImageResource(R.drawable.black);
        }
    }

    @Override
    public int getItemCount() {
        return recetas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView nombre,personas,descripcion,preparacion;
        ImageView image,star;

        public ViewHolder(View itemView) {
            super(itemView);

            cardView = (CardView) itemView.findViewById(R.id.cardview);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            personas  = (TextView) itemView.findViewById(R.id.personas);
            descripcion =(TextView) itemView.findViewById(R.id.descripcion);
            preparacion = (TextView) itemView.findViewById(R.id.preparacion);
            image  = (ImageView) itemView.findViewById(R.id.image);
            star = (ImageView) itemView.findViewById(R.id.star);
        }
    }
}
