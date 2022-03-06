package com.example.numad22sp_siyuhou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button2);
        Button buttonLink = (Button) findViewById(R.id.button3);
        Button aboutMe = (Button) findViewById(R.id.button);
        aboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAboutMe();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity2();
            }
        });

        buttonLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openActivity3();
            }
        });
        Button locator = (Button) findViewById(R.id.locator);
        locator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLocation();
            }
        });

        Button webService = (Button) findViewById(R.id.webService);
        webService.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                openService();
            }
        });
    }

    public void openService(){
        Intent intent = new Intent(this, WebService.class);
        startActivity(intent);
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    public void openActivity3(){
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }


    public void openAboutMe(){
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }
    public void openLocation(){
        Intent intent = new Intent(this, Locator.class);
        startActivity(intent);
    }
}