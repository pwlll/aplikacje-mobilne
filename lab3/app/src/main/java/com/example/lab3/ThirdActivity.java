package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.Manifest;
import android.content.Context;
import android.location. LocationListener;
import android.location. LocationManager;
import android.location. Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import org.w3c.dom.Text;

public class ThirdActivity extends AppCompatActivity {

    private Button startBtn,stopBtn;
    private TextView tWidth,tLength;
    public LocationManager locationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        locationManager=(LocationManager) getSystemService (Context. LOCATION_SERVICE);


        LocationListener listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location){
                String width = String.valueOf(location.getLatitude());
                String length= String.valueOf(location.getLongitude());
                tWidth = (TextView) findViewById(R.id.tWidth);
                tWidth.setText (width);
                tLength = (TextView) findViewById(R.id.tLength);
                tLength.setText(length);
            }

            @Override
            public void onStatusChanged(String provider,int status,Bundle extras){
            }

            @Override
            public void onProviderEnabled(String provider) {
            }

            @Override
            public void onProviderDisabled(String provider) {
            }
        };
        if (checkSelfPermission (Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && checkSelfPermission (Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
        }
        locationManager.requestLocationUpdates (LocationManager.GPS_PROVIDER, 0,0,(LocationListener) listener);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        Button btnStart=findViewById(R.id.btnStart);
        Button btnStop=findViewById(R.id.btnStop);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                btnStart.setEnabled(true);
                btnStop.setEnabled(false);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                btnStart.setEnabled(false);
                btnStop.setEnabled(true);
            }
        });
    }

}


