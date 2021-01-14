package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.smartcity.covidcenterlamongan.Adapter.ProvinsiAdapter;
import com.smartcity.covidcenterlamongan.Model.ModelDataIndonesia;
import com.smartcity.covidcenterlamongan.Model.ModelObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tSembuh, tPositif, tMeninggal;
    RecyclerView list;
    ProgressDialog dialog;

    Button button1, button2, button3, button4;
    Button nas, jatim, lamongan;
    Button hot, wa, bshare;

    private boolean adaInternet(){
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tSembuh = findViewById(R.id.datasembuh);
        tPositif = findViewById(R.id.datapositif);
        tMeninggal = findViewById(R.id.datameninggal);

        list = findViewById(R.id.list);
        list.setLayoutManager(new LinearLayoutManager(this));

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();
        getData();
        getProvinsi();

        button1=findViewById(R.id.hperiksa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,PeriksaActivity.class);
                startActivity(intent);

            }
        });
        button2=findViewById(R.id.htips);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,TipsActivity.class);
                startActivity(intent);
            }
        });
        button3=findViewById(R.id.hfaq);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,FaqActivity.class);
                startActivity(intent);
            }
        });
        button4=findViewById(R.id.habout);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AboutActivity.class);
                startActivity(intent);
            }
        });

        nas=findViewById(R.id.wnas);
        nas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(MainActivity.this,WNasActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(MainActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });
        jatim=findViewById(R.id.wjatim);
        jatim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(MainActivity.this,WJatimActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(MainActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });
        lamongan=findViewById(R.id.wlamongan);
        lamongan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(MainActivity.this,WLamonganActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(MainActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });

        hot=findViewById(R.id.hotline);
        hot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = "+6281216257743";
                Intent Call = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+number));
                startActivity(Call);
            }
        });
        wa=findViewById(R.id.whatsapp);
        wa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent = new Intent();
                    intent.setAction(intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse("https://wa.me/6281216257743"));
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(MainActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });
        bshare=findViewById(R.id.share);
        bshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,BagikanActivity.class);
                startActivity(intent);
            }
        });

    }

    public void getData(){
        Call<List<ModelDataIndonesia>> call = Api.service().getData();
        call.enqueue(new Callback<List<ModelDataIndonesia>>() {
            @Override
            public void onResponse(Call<List<ModelDataIndonesia>> call, Response<List<ModelDataIndonesia>> response) {
                tSembuh.setText(response.body().get(0).getSembuh());
                tMeninggal.setText(response.body().get(0).getMeninggal());
                tPositif.setText(response.body().get(0).getPositif());

            }

            @Override
            public void onFailure(Call<List<ModelDataIndonesia>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(),Toast.LENGTH_SHORT).show();

            }

        });
    }

    public void getProvinsi(){
        Call<List<ModelObject>> call = Api.service().getProvinsi();
        call.enqueue(new Callback<List<ModelObject>>() {
            @Override
            public void onResponse(Call<List<ModelObject>> call, Response<List<ModelObject>> response) {
                list.setAdapter(new ProvinsiAdapter(MainActivity.this,response.body()));
                dialog.cancel();

            }

            @Override
            public void onFailure(Call<List<ModelObject>> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                dialog.cancel();

            }
        });
    }
}