package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BagikanActivity extends AppCompatActivity {

    Button button1, button2, button3, button4;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bagikan);
        setTitle("Bagikan Aplikasi");

        actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button1=findViewById(R.id.h_wa);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Mulailah update informasi Covid-19 dan lindungi diri Anda & yang tercinta dari penyebaran " +
                        "Covid-19 dengan mengunduh Aplikasi Covid Center Lamongan di https://s.id/cclapp . Unduh sekarang juga!");
                intent.setType("text/plain");
                intent.setPackage("com.whatsapp");
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });
        button2=findViewById(R.id.h_twitter);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent();
                intent.setAction(intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Mulailah update informasi Covid-19 dan lindungi diri Anda & yang tercinta dari penyebaran " +
                        "Covid-19 dengan mengunduh Aplikasi Covid Center Lamongan di https://s.id/cclapp . Unduh sekarang juga!");
                intent.setType("text/plain");
                Intent shareIntent = Intent.createChooser(intent, null);
                startActivity(shareIntent);
            }
        });
        button3=findViewById(R.id.h_pesan);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("smsto:");
                Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
                intent.putExtra("sms_body","Mulailah update informasi Covid-19 dan lindungi diri Anda & yang tercinta dari penyebaran " +
                        "Covid-19 dengan mengunduh Aplikasi Covid Center Lamongan di https://s.id/cclapp . Unduh sekarang juga!");
                startActivity(intent);
            }
        });
        button4=findViewById(R.id.h_gmail);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {""});
                intent.putExtra(Intent.EXTRA_CC, new String[] {""});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Link Download Aplikasi Covid Center Lamongan");
                intent.putExtra(Intent.EXTRA_TEXT, "Mulailah update informasi Covid-19 dan lindungi diri Anda & yang tercinta dari penyebaran " +
                        "Covid-19 dengan mengunduh Aplikasi Covid Center Lamongan di https://s.id/cclapp . Unduh sekarang juga!");

                try {
                    startActivity(Intent.createChooser(intent, "Ingin Mengirim Email?"));
                } catch (android.content.ActivityNotFoundException ex) {
                    //do something else
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