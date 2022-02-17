package com.example.paola_velastegui_supletorio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Fragment_Personal extends Fragment {

    public Fragment_Personal() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private List<Tarea> listaTareas = new ArrayList<Tarea>();
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private Button eliminarimagen;
    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_personal, container, false);
        // Inflate the layout for this fragment
        eliminarimagen = root.findViewById(R.id.imageView_delete2);
        recuperarDatosFB();
        eliminarimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return root;
    }


    private void recuperarDatosFB() {
/*
        databaseReference.child(user.getUid()).child("Tareas").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listaTareas.clear();
                for (DataSnapshot objeto: snapshot.getChildren()) {

                    Tarea tarea = objeto.getValue(Tarea.class);
                    if(tarea.getTipo().equals("p") && tarea.getCompletado()==false){
                        listaTareas.add(tarea);
                    }

                }
                //└Toast.makeText(getActivity(), String.valueOf(listaTareas.size()), Toast.LENGTH_SHORT).show();
                AdapterRecyclerView();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

 */
    }

    private void AdapterRecyclerView() {
        mRecyclerView = root.findViewById(R.id.recyclerviewTarea);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mAdapter = new AdapterTareaVLJP(listaTareas, R.layout.detallepersonal, new AdapterTareaVLJP.OnItemClickListener() {
            @Override
            public void onItemClick(Tarea tarea, int position) {
                Toast.makeText(getActivity(),tarea.getUid(), Toast.LENGTH_SHORT).show();
            }
        }, new AdapterTareaVLJP.OnViewClickListener() {
            @Override
            public void onViewClick(Tarea tarea, int positio, boolean estado) {

            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

}