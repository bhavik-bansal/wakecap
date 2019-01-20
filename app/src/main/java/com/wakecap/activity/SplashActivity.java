package com.wakecap.activity;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wakecap.R;
import com.wakecap.utils.BookoUtils;
import com.wakecap.utils.Constants;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(
                runnable,
                Constants.SPLASH_SCREEN_TIME_OUT);

    }

    private final Runnable runnable = new Runnable() {
        @Override
        public void run() {
            BookoUtils.launchMainActivity(SplashActivity.this, MainActivity.class);
        }
    };
}
