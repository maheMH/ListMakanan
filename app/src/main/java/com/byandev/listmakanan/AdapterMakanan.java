package com.byandev.listmakanan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterMakanan extends RecyclerView.Adapter<AdapterMakanan.MakananViewHolder> {

                                                                            //1.alt+enter yang bergaris merah, sampai membuat public oncreate, onbindviewholder, dan getitemcount (sesuai pesan yang diperintah)

    Context context;                                                        //2.untuk ngambil root dari activity (ngebantu buat ngakses yang ada di activity/ make yang ada di activity)

    List<Makanan> dataMakanan;                                              //4. untuk di bindviewholder

                                                                            //7 diambil dr data yg paling dibawah
    public AdapterMakanan(Context context, List<Makanan> dataMakanan) {
        this.context = context;
        this.dataMakanan = dataMakanan;
    }

                                                                            //untuk ngehubungin ke layout atau file xml nya
    @NonNull
    @Override
    public MakananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_makanan, parent, false); // klo pake grid ganti (layoutnya)
        return new MakananViewHolder(view);
    }


                                                                            // untuk nge band ing, atau untuk masukin data datanya
    @Override
    public void onBindViewHolder(@NonNull MakananViewHolder holder, final int position) {
                                                                            //5
        holder.nama.setText(dataMakanan.get(position).getNama());

                                                                            //        settinng glide untuk gambar
                                                                            //        Glide.with(this).load("http://goo.gl/gEgYUd").into(imageView
        Glide.with(context).load(dataMakanan.get(position).getPhoto()).into(holder.gambar);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,DetailMakanan.class);
                intent.putExtra("nama", dataMakanan.get(position).getNama());
                intent.putExtra("gambar", dataMakanan.get(position).getPhoto());
                intent.putExtra("detail", dataMakanan.get(position).getDetail());
                context.startActivity(intent);
            }
        });
    }

                                                                        //brapa data yang akan ditampilkan, misal data ada 10 tp cuma mau ditampilin 5 aja.
                                                                        //6
    @Override
    public int getItemCount() {
        return dataMakanan.size();
    }

                                                                        //masih 1. tulis extends recyclerView
                                                                        //3.bikin varnya(A) dulu, lalu bikin(B)

    public class MakananViewHolder extends RecyclerView.ViewHolder {
                                                                        //A. variablenya
        ImageView gambar;
        TextView nama;

        public MakananViewHolder(@NonNull View itemView) {
            super(itemView);
                                                                        //B isi datanya, isi dari si list nya
            gambar = itemView.findViewById(R.id.image_makanan);
            nama = itemView.findViewById(R.id.nama_makanan);
        }
    }
}
