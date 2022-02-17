package com.example.paola_velastegui_supletorio;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterTareaVLJP {

    private List<Tarea> tareas;
    private int layout;
    private AdapterTareaVLJP.OnItemClickListener itemClickListener;
    private AdapterTareaVLJP.OnViewClickListener viewClickListener;
    private SparseBooleanArray checkBoxStateArray = new SparseBooleanArray();

    public AdapterTareaVLJP(List<Tarea> tareas, int layout, AdapterTareaVLJP.OnItemClickListener listener, AdapterTareaVLJP.OnViewClickListener listenerView) {
        this.tareas = tareas;
        this.layout = layout;
        this.itemClickListener = listener;
        this.viewClickListener = listenerView;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(!checkBoxStateArray.get(position,false))
        {
            //checkbox unchecked
            holder.checkBox.setChecked(false);
        }
        else
        {
            //checkbox checked.
            holder.checkBox.setChecked(true);
        }
        holder.bind(tareas.get(position),checkBoxStateArray,itemClickListener, viewClickListener);
    }

    @Override
    public int getItemCount() {
        return tareas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewDescripcion;
        public CheckBox checkBox;
        public TextView textTitulo;

        public ViewHolder(View itemView) {
            super(itemView);
            this.textTitulo = (TextView) itemView.findViewById(R.id.textView_titulo);
            this.checkBox = (CheckBox) itemView.findViewById(R.id.checkBox_estado);
            this.textViewDescripcion = itemView.findViewById(R.id.textView_Descripcion);
        }

        public void bind(final Tarea tarea, final SparseBooleanArray checkBoxStateList, final AdapterTareaVLJP.OnItemClickListener listener, final AdapterTareaVLJP.OnViewClickListener listenerView) {
            this.textTitulo.setText(tarea.getTitulo());
            this.textViewDescripcion.setText(tarea.getDescripcion());
            if (tarea.getCompletado()){
                checkBox.setChecked(true);
            }else{
                checkBox.setChecked(false);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(tarea, getAdapterPosition());
                }
            });
            checkBox.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    //getAdapterPosition returns clicked item position
                    boolean estado;
                    if(!checkBoxStateList.get(getAdapterPosition(),false))
                    {
                        //checkbox checked
                        checkBox.setChecked(true);
                        //checkbox state stored.
                        checkBoxStateList.put(getAdapterPosition(),true);
                        estado = true;
                        tarea.setCompletado(true);
                    }
                    else
                    {
                        //checkbox unchecked.
                        checkBox.setChecked(false);
                        //checkbox state stored
                        checkBoxStateList.put(getAdapterPosition(),false);
                        estado = false;
                        tarea.setCompletado(true);
                    }
                    listenerView.onViewClick(tarea, getAdapterPosition(), estado);
                }
            });
        }

    }

    public interface OnItemClickListener{
        void onItemClick(Tarea tarea, int position);
    }

    public interface OnViewClickListener{
        void onViewClick(Tarea tarea, int positio, boolean estado);
    }

}
