package com.example.planatrip;
import android.content.Intent;
import android.location.Location;

import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.Manifest;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.Manifest.permission;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMyLocationButtonClickListener;
import com.google.android.gms.maps.GoogleMap.OnMyLocationClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;


public class login extends AppCompatActivity {
        LocationFinder locationfinder = new LocationFinder();
        TextView response;
        EditText locationtext;
        Button locationbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginscreen);


        locationtext = (EditText) findViewById(R.id.editTextTextEmailAddress);

        String location = locationtext.toString();

        String locationnew = locationfinder.GetLongLatFromAdress(this,location).toString();



        locationbutton = (Button) findViewById(R.id.getlocation);
        locationbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                response.setText(locationnew);
            }




        });









        }







}