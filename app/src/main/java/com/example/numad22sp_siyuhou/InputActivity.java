package com.example.numad22sp_siyuhou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextUrl;
    public final static String EXTRA_NAME =
            "siyuhou.EXTRA_NAME";
    public final static String EXTRA_URL =
            "hou.siy@northeastern.edu.EXTRA_LINK";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editTextName = (EditText) findViewById(R.id.editName);
        editTextUrl = (EditText) findViewById(R.id.editUrl);
        Button saveButton = (Button) findViewById(R.id.saveTheInput);

        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                saveData();
            }
        });
    }


    private void saveData(){
        String name = editTextName.getText().toString().trim();
        String url = editTextUrl.getText().toString().trim().toLowerCase();
        if(name.equals("") || url.equals("") || !isValidUrl(url)){
            Toast.makeText(InputActivity.this, "Please insert valid url", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_URL, url);

        setResult(RESULT_OK, intent);
        finish();
    }


    private boolean isValidUrl(String url){
        return Patterns.WEB_URL.matcher(url).matches();
    }
}