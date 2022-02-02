package com.example.numad22sp_siyuhou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView show = (TextView) findViewById(R.id.textView2);

        Button buttonA = (Button) findViewById(R.id.buttonA);
        Button buttonB = (Button) findViewById(R.id.buttonB);
        Button buttonC = (Button) findViewById(R.id.buttonC);
        Button buttonD = (Button) findViewById(R.id.buttonD);
        Button buttonE = (Button) findViewById(R.id.buttonE);
        Button buttonF = (Button) findViewById(R.id.buttonF);

        buttonA.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: A");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });

        buttonB.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: B");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });

        buttonC.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: C");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });

        buttonD.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: D");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });

        buttonE.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: E");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });

        buttonF.setOnTouchListener((view, motionEvent) -> {
            switch (motionEvent.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    show.setText("Pressed: F");
                    return true;
                case MotionEvent.ACTION_UP:
                    show.setText("Pressed: -");
                    return true;
            }
            return false;
        });
    }
}