package com.example.offloading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SplashActivity extends AppCompatActivity {
String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4";
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);

            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4";
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4";
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                url="http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4";
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                intent.putExtra("url",url);
                startActivity(intent);
            }
        });
    }
}