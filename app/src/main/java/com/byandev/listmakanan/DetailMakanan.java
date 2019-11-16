package com.byandev.listmakanan;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailMakanan extends AppCompatActivity {

    TextView txtnama;
    TextView desc;
    ImageView gambar;

//var
    int id;
    String nama;
    int photo;
    String detail;

    Spinner spinner;

    private String[] namaHewan = {
            "Jerapah",
            "Gajah",
            "Kucing",
            "Anjing",
            "Kelinci"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_makanan);

//untuk balik ke home (setting juga yg di manifest)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtnama= findViewById(R.id.nama_detail);
        desc = findViewById(R.id.desc_detail);
        gambar = findViewById(R.id.image_detail);
        spinner = findViewById(R.id.spinner);



        nama = getIntent().getStringExtra("nama");
        photo = getIntent().getIntExtra("gambar",0);
        detail = getIntent().getStringExtra("detail");

        txtnama.setText(nama);
        desc.setText(detail);
        Glide.with(getApplicationContext()).load(photo).into(gambar);

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.support_simple_spinner_dropdown_item, namaHewan);

//        set adapter
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            klo di klik
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(DetailMakanan.this, "Kamu Pelihara " + adapter.getItem(1),Toast.LENGTH_SHORT ).show() ;

            }

//            klo ga di klik
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
