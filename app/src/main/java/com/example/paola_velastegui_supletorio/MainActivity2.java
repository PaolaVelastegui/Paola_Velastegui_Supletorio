package com.example.paola_velastegui_supletorio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.paola_velastegui_supletorio.databinding.ActivityMain2Binding;
import com.google.android.material.tabs.TabLayout;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;
    private ImageView añadirimagen;
    private  ImageView reportes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        //viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        añadirimagen = findViewById(R.id.imageView_add);
        reportes = findViewById(R.id.reportesid);
        reportes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity2.this, Reportesfinal.class);
               // startActivity(intent);
            }
        });
        añadirimagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nuevatarea();
            }
        });

    }



    private void nuevatarea() {
        Intent intent = new Intent(MainActivity2.this, AgregarTareas.class);
        startActivity(intent);
    }


}