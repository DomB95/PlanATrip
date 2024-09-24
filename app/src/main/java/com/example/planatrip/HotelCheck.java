package com.example.planatrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HotelCheck extends AppCompatActivity {

    EditText hotellocation;
    Button hotelsearch;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelchecker);

        SharedPref.init(getApplicationContext());


        hotelsearch = (Button) findViewById(R.id.searchhotels);
        hotelsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newscreen = new Intent(HotelCheck.this, CheckHotels.class);
                startActivity(newscreen);
            }
        });


    }


    @Override
    protected void onPause(){
        super.onPause();

        hotellocation = findViewById(R.id.hotellocationtext);

        String location = hotellocation.getText().toString();

        SharedPref.write(SharedPref.CityName, location);

        Log.i("Saved cityname", location);













    }
}
