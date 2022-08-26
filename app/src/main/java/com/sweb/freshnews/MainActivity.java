package com.sweb.freshnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent splashIntent = new Intent(MainActivity.this,SplashActivity.class);
        startActivity(splashIntent);

    }
}
