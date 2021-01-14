package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PeriksaActivity extends AppCompatActivity {
    Button button1, button2, button3, button4;

    ActionBar actionBar;

    private boolean adaInternet(){
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periksa);
        setTitle("Periksa Kesehatan Mandiri");

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1=findViewById(R.id.alodokter);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(PeriksaActivity.this,WebAlodokterActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(PeriksaActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });

        button2=findViewById(R.id.prixa);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(PeriksaActivity.this,WebPrixaActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(PeriksaActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });

        button3=findViewById(R.id.halodoc);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(PeriksaActivity.this,WebHalodocActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(PeriksaActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });

        button4=findViewById(R.id.prosehat);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(adaInternet()){
                    Intent intent=new Intent(PeriksaActivity.this,WebProsehatActivity.class);
                    startActivity(intent);
                }else{
                    Intent intent=new Intent(PeriksaActivity.this,NointernetActivity.class);
                    startActivity(intent);
                }

            }
        });
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