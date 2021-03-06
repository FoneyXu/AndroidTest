package com.foney.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LunchActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lunch);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startMainActivity();
            }
        }, 2000);
    }

    private void startMainActivity() {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}
