package com.example.numad22sp_siyuhou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    public void toastMsg(String msg) {
//        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
//        toast.show();
//    }
//
//    public void displayToastMsg(View v) {
//        toastMsg("My name is Siyu Hou, my email address is hou.siy@northeastern.edu");
//    }

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