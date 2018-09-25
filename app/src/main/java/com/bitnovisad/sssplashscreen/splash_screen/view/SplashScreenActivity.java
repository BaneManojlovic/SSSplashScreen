package com.bitnovisad.sssplashscreen.splash_screen.view;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.bitnovisad.sssplashscreen.R;
import com.bitnovisad.sssplashscreen.main.view.MainActivity;

public class SplashScreenActivity extends AppCompatActivity implements IntSplashScreenView{

    private static int SPLASH_TIME_OUT = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //opens main activity after splashscreen
        openMainActivity();
    }

    @Override
    public void openMainActivity() {
        TextView textView = findViewById(R.id.textOnSplashScreen);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        textView.startAnimation(animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
