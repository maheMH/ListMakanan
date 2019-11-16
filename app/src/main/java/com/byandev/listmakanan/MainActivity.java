package com.byandev.listmakanan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //2
    RecyclerView recyclerView;
    AdapterMakanan adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //3
        adapter = new AdapterMakanan(getApplicationContext(), dataMakanan());

        recyclerView = findViewById(R.id.recycler_makanan);
 //     recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext())); untuk recyclerview kebawah(?)
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        recyclerView.setAdapter(adapter);

        //1. buat method untuk mengambil data datanya


    }

    ArrayList<Makanan> dataMakanan(){
        return DummyMakanan.listMakanan();
    }

}
