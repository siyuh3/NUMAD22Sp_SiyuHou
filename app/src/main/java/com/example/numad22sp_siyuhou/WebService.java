package com.example.numad22sp_siyuhou;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;


public class WebService extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_service);
        TextView content = findViewById(R.id.web_text);
        RadioGroup choosePost = findViewById(R.id.post);
        ProgressBar progressBar = findViewById(R.id.pb);
        Button buttonSubmit = findViewById(R.id.button_submit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String url;
                int checkedId = choosePost.getCheckedRadioButtonId();
                if (checkedId == -1) {
                    Toast.makeText(WebService.this, "Please select one post", Toast.LENGTH_LONG).show();
                } else {
                    url = findRadioButton(checkedId);
                    progressBar.setVisibility(View.VISIBLE);
                    new AsyncHttpClient().get(url, new AsyncHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                            String response = new String(responseBody);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            content.setText(response);
                            progressBar.setVisibility(View.GONE);
                        }

                        @SuppressLint("SetTextI18n")
                        @Override
                        public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            content.setText("Error");
                            progressBar.setVisibility(View.GONE);
                        }
                    });
                }
            }
        });

    }

    private String findRadioButton(int option) {
        String url;
        switch (option) {
            case R.id.radioButton1:
                url = "https://jsonplaceholder.typicode.com/posts/1";
                break;
            case R.id.radioButton2:
                url = "https://jsonplaceholder.typicode.com/posts/2";
                break;
            case R.id.radioButton3:
                url = "https://jsonplaceholder.typicode.com/posts/3";
                break;
            case R.id.radioButton4:
                url = "https://jsonplaceholder.typicode.com/posts/4";
                break;
            case R.id.radioButton5:
                url = "https://jsonplaceholder.typicode.com/posts/5";
                break;
            default:
                url = "https://jsonplaceholder.typicode.com/posts/1";
        }
        return url;
    }
}