package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smartcity.covidcenterlamongan.Adapter.AdapterFaq;
import com.smartcity.covidcenterlamongan.item.itemfaq;

import java.util.ArrayList;

public class FaqActivity extends AppCompatActivity {
    private NestedScrollView nested_scroll_view;
    private RecyclerView rvView;
    private ArrayList<itemfaq> listitem;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvView = findViewById(R.id.rv_faq);
        rvView.setLayoutManager(llm);
        nested_scroll_view = findViewById(R.id.nested_scroll_view);
        setTitle("Frequently Asked Question (FAQ)");
        listitem =new ArrayList<>();
        itemfaq a=new itemfaq();
        itemfaq b=new itemfaq();
        itemfaq c=new itemfaq();
        itemfaq d=new itemfaq();
        itemfaq e=new itemfaq();
        itemfaq f=new itemfaq();
        itemfaq g=new itemfaq();
        itemfaq h=new itemfaq();
        itemfaq i=new itemfaq();

        a.setJudul("Apa itu Covid-19?");
        a.setIsi("Coronavirus Disease (Covid-19) adalah nama penyakit yang disebabkan Novel coronavirus (2019-nCoV), jenis baru coronavirus yang belum pernah diidentifikasi sebelumnya pada manusia. Coronavirus merupakan keluarga besar virus yang menyebabkan penyakit pada manusia dan hewan. Pada manusia menyebabkan penyakit mulai flu biasa hingga penyakit yang serius seperti Middle East Respiratory Syndrome (MERS) dan Sindrom Pernapasan Akut Berat/ Severe Acute Respiratory Syndrome (SARS).");
        b.setJudul("Apa saja gejala Covid-19?");
        b.setIsi("Gejala umum berupa demam ≥38C, batuk, pilek, nyeri tenggorokan dan sesak napas. Jika ada orang dengan gejala tersebut pernah melakukan perjalanan ke Tiongkok (terutama Wuhan), atau pernah merawat/kontak dengan penderita Covid-19, maka terhadap orang tersebut akan dilakukan pemeriksaan laboratorium lebih lanjut untuk memastikan diagnosisnya.");
        c.setJudul("Seberapa bahaya Covid-19?");
        c.setIsi("Seperti penyakit pernapasan lainnya, infeksi 2019-nCoV dapat menyebabkan gejala ringan termasuk pilek, sakit tenggorokan, batuk, dan demam. Beberapa orang mungkin akan menderita sakit yang parah, seperti disertai pneumonia atau kesulitan bernafas. Walaupun fatalitas penyakit ini masih jarang, namun bagi orang yang berusia lanjut, dan orang-orang dengan kondisi medis yang sudah ada sebelumnya (seperti, diabetes dan penyakit jantung), mereka biasanya lebih rentan untuk menjadi sakit parah.");
        d.setJudul("Apakah Covid-19 ditularkan manusia?");
        d.setIsi("Ya, Covid-19 dapat ditularkan dari orang ke orang, biasanya setelah kontak erat dengan pasien yang terinfeksi, misalnya, di tempat kerja, di rumah tangga, atau fasilitas pelayanan kesehatan.");
        e.setJudul("Berapa lama Covid-19 bertahan?");
        e.setIsi("Meskipun ada informasi awal yang menunjukkan dapat bertahan hingga beberapa jam. Namun desinfektan sederhana dapat membunuh virus tersebut sehingga tidak mungkin menginfeksi orang lagi.");
        f.setJudul("Orang berisiko terinfeksi Covid-19?");
        f.setIsi("Orang yang tinggal atau bepergian di daerah di mana COVID-19 bersirkulasi sangat mungkin berisiko terinfeksi. Petugas kesehatan yang merawat pasien yang terinfeksi COVID-19 berisiko lebih tinggi dan harus konsisten melindungi diri mereka sendiri dengan prosedur pencegahan dan pengendalian infeksi yang tepat.");
        g.setJudul("Berapa lama Masa Inkubasi Covid-19?");
        g.setIsi("Waktu yang diperlukan sejak tertular/terinfeksi hingga muncul gejala disebut masa inkubasi. Saat ini masa inkubasi Covid-19 diperkirakan antara 2-11 hari, dan perkiraan ini dapat berubah sewaktu-waktu sesuai perkembangan kasus. Berdasarkan data dari penyakit akibat coronavirus sebelumnya, seperti MERS dan SARS, masa inkubasi Covid-19 juga bisa mencapai 14 hari.");
        h.setJudul("Apakah anak-anak harus memakai masker?");
        h.setIsi("Anak-anak yang berusia 5 tahun dan di bawah 5 tahun sebaiknya tidak diwajibkan untuk memakai masker. Anjuran ini didasarkan pada keamanan dan kepentingan keseluruhan anak serta kemampuan menggunakan masker dengan tepat tanpa banyak dibantu.");
        i.setJudul("Masker jenis apa yang baik dipakai?");
        i.setIsi("Orang yang secara umum sehat dapat memakai masker nonmedis atau kain. Masker jenis ini memberikan pengendalian sumber, yang berarti masker menghalangi penyebaran virus kepada orang lain jika pemakainya memang terinfeksi virus tetapi tidak menyadarinya. Orang dewasa yang menyediakan masker ini harus memastikan bahwa masker kain memiliki ukuran yang tepat serta cukup menutup hidung, mulut, dan dagu.");

        listitem.add(a);
        listitem.add(b);
        listitem.add(c);
        listitem.add(d);
        listitem.add(e);
        listitem.add(f);
        listitem.add(g);
        listitem.add(h);
        listitem.add(i);

        AdapterFaq adapterFaq= new AdapterFaq(this,listitem,nested_scroll_view);
        rvView.setAdapter(adapterFaq);

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