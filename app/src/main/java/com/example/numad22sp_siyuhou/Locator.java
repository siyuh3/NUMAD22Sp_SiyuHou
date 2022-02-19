package com.example.numad22sp_siyuhou;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Locator extends AppCompatActivity implements LocationListener {
    TextView text;
    Button button;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        text = (TextView) findViewById(R.id.locationView);
        button = (Button) findViewById(R.id.locationButton);
        if (savedInstanceState != null) {
            String location = savedInstanceState.getString("location");
            text.setText(location);
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkLocationPermit();
                getLocation();
            }
        });
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("location", text.getText().toString());
    }


    private void checkLocationPermit() {
        if (ContextCompat.checkSelfPermission(Locator.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Locator.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 1);
        }
    }


    @SuppressLint("MissingPermission")
    private void getLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, Locator.this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onLocationChanged(@NonNull Location location) {
        text.setText("Latitude: " + location.getLatitude() + "\nLongitude: " + location.getLongitude());
    }


    @Override
    public void onProviderEnabled(@NonNull String provider) {

    }


    @Override
    public void onProviderDisabled(@NonNull String provider) {

    }
}
