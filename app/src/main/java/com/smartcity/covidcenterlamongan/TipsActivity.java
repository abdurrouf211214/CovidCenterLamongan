package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smartcity.covidcenterlamongan.Adapter.AdapterTips;
import com.smartcity.covidcenterlamongan.item.itemtips;

import java.util.ArrayList;

public class TipsActivity extends AppCompatActivity {
    private NestedScrollView nested_scroll_view;
    private RecyclerView rvView;
    private ArrayList<itemtips> listitem;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvView = findViewById(R.id.rv_tips);
        rvView.setLayoutManager(llm);
        nested_scroll_view = findViewById(R.id.nested_scroll_view);
        setTitle("Tips Kesehatan");
        listitem =new ArrayList<>();
        itemtips a=new itemtips();
        itemtips b=new itemtips();
        itemtips c=new itemtips();
        itemtips d=new itemtips();
        a.setJudul("Pencegahan Covid-19");
        a.setIsi("Bagaimana cara mencegah penyebaran Covid-19?\n" +
                "Langkah-langkah yang dapat dilakukan:\n" +
                " 1. Jaga kesehatan dan kebugaran untuk meningkatkan kekebalan tubuh.\n"+
                " 2. Cuci tangan menggunakan sabun dan air mengalir atau bisa menggunakan hand sanitizer.\n" +
                " 3. Terapkan etika batuk dan bersin. Tutup hidung dan mulut dengan tisu atau dengan lengan atas bagian dalam.\n" +
                " 4. Jaga jaraj saat bertemu orang lain, 1-2 meter.\n" +
                " 5. Hindari menyentuh mata, hidung dan mulut sebelum mencuci tangan.\n" +
                " 6. Gunakan masker penutup hidung dan mulut ketika anda sakit.\n" +
                " 7. Buang Tisu atau masker yang sudah digunakan ke tempat sampah kemudian cucilah tangan.\n" +
                " 8. Tunda bepergian ke daerah zona merah Covid-19.\n" +
                " 9. Jauhi tempat keramaian atau berdiam diri di rumah diutamakan.\n\n" +
                "Sumber: WHO & Kementerian Kesehatan");
        b.setJudul("Penerapan Jaga Jarak");
        b.setIsi("Langkah-Langkahnya:\n" +
                " 1. Hindari pertemuan besar (lebih dari 10 orang).\n" +
                " 2. Jaga jarak (1 meter atau lebih) dengan orang lain.\n" +
                " 3. Jangan bepergian ke sarana jesehatan kecuali diperlukan.\n" +
                " 4. Bila memiliki anggota keluarga yang terpapar Covid-19 dan sedang dirawat, batasi pengunjung.\n" +
                " 5. Orang berisiko tinggi terpapar Covid-19 sebaiknya di rumah.\n" +
                " 6. Beri dukungan anggota keluarga, kawan, atau tetangga yang terpapar COVID-19 tanpa bertemu langsung (misal melalui telepon).\n" +
                " 7. Ikuti panduan resmi pemerintah setempat.\n" +
                " 8. Ikuti perkembangan informasi karena situasi bisa berubah sewaktu-waktu.\n\n" +
                "Sumber: covid19.go.id");
        c.setJudul("Cara menggunakan masker");
        c.setIsi("Berikut ini langkah-langkah penggunaan masker yang tepat:\n" +
                " 1. Cuci tangan sebelum memakai masker.\n" +
                " 2. Pasang masker menutupi hidung dan mulut sampai dagu.\n" +
                " 3. Jangan buka tutup masker. Jangan menyentuh masker yang kotor.\n" +
                " 4. Ganti masker yang basah atau lembab dengan masker yang baru.\n" +
                " 5. Untuk membuka masker: lepaskan dari belakang dan jangan sentuh bagian depan\n\n" +
                "Sumber: covid19.go.id");
        d.setJudul("Waktunya memeriksakan diri");
        d.setIsi("Sesuai dengan prosedur yang sudah ditetapkan oleh pihak berwenang atau pemerintah, anda dapat menghubungi 119 ext. 9 atau periksa ke rumah sakit rujukan jika:\n" +
                " 1. Pernah berkunjung ke daerah zona merah Covid-19 dalam 14 hari terakhir dan mengalami gejala demam di atas 38 derajat celcius, batuk dan sesak nafas yang tidak kunjung membaik.\n" +
                " 2. Pernah kontak langsung dengan pasien Covid-19 atau orang dengan kondisi pada point 1.\n" +
                " 3. Mengalami gejala ringan-sedang yang mengarah ke Covid-19 seperti demam, batuk dan sesak nafas yang tidak kunjung membaik meski tidak ada riwayat kontak langsung dengan pasien atau berada di daerah zona merah.\n\n" +
                "Sumber: Infografis Kementerian Kesehatan");
        listitem.add(a);
        listitem.add(b);
        listitem.add(c);
        listitem.add(d);
        AdapterTips adapterTips= new AdapterTips(this,listitem,nested_scroll_view);
        rvView.setAdapter(adapterTips);

    }

    @Override
    public boolean onSupportNavigateUp(){
        onBackPressed();
        return true;
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }
}