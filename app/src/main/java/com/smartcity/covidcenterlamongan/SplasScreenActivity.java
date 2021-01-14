package com.smartcity.covidcenterlamongan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

public class SplasScreenActivity extends AppCompatActivity {
    public boolean isFirstStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());
                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);
                if (isFirstStart) {
                    Intent home=new Intent(SplasScreenActivity.this, MyIntroActivity.class);
                    startActivity(home);
                    SharedPreferences.Editor e = getSharedPreferences.edit();
                    e.putBoolean("firstStart", false);
                    e.apply();
                    finish();
                }else {
                    Intent home=new Intent(SplasScreenActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }

            }
        },3000);
    }
}