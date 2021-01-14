package com.smartcity.covidcenterlamongan;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro;

public class MyIntroActivity extends AppIntro {
    // Please DO NOT override onCreate. Use init
    @Override
    public void init(Bundle savedInstanceState) {

//adding the three slides for introduction app you can ad as many you needed
        addSlide(AppIntroSampleSlider.newInstance(R.layout.fragmentsatu));
        addSlide(AppIntroSampleSlider.newInstance(R.layout.fragmentdua));
        addSlide(AppIntroSampleSlider.newInstance(R.layout.fragmenttiga));

        showStatusBar(true);
        showSkipButton(true);
        setSeparatorColor(Color.parseColor("#2196F3"));
        setDepthAnimation();
    }

    @Override
    public void onSkipPressed() {
        Intent i = new Intent(com.smartcity.covidcenterlamongan.MyIntroActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onNextPressed() {
        // Do something here when users click or tap on Next button.
    }

    @Override
    public void onDonePressed() {
        Intent i = new Intent(com.smartcity.covidcenterlamongan.MyIntroActivity.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onSlideChanged() {
        // Do something here when slide is changed
    }
}
