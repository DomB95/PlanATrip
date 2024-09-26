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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class HotelCheck extends AppCompatActivity {
    CheckBox BedandB;
    CheckBox extendedS;
    CheckBox guesthouse;
    CheckBox hotel;
    CheckBox motel;
    CheckBox privateguest;
    CheckBox resorthotel;


    List<String> included = new ArrayList<>();
    List<String> excluded = new ArrayList<>();

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
    protected void onStart(){
     super.onStart();

        BedandB =(CheckBox) findViewById(R.id.bed_and_breakfast);
        BedandB.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("bed_and_breakfast");
                    Toast.makeText(HotelCheck.this,"Bed and Breakfast are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("bed_and_breakfast");
                }

            }
        });extendedS =(CheckBox) findViewById(R.id.extended_stay_hotel);
        extendedS.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("extended_stay_hotel");
                    Toast.makeText(HotelCheck.this,"Extended Stays are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("extended_stay_hotel");
                }

            }
        });guesthouse =(CheckBox) findViewById(R.id.guest_house);
        guesthouse.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("guest_house");
                    Toast.makeText(HotelCheck.this,"Guest Houses are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("guest_house");
                }

            }
        });hotel =(CheckBox) findViewById(R.id.hotel);
        hotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("hotel");
                    Toast.makeText(HotelCheck.this,"Hotels are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("hotel");
                }

            }
        });motel =(CheckBox) findViewById(R.id.motel);
        motel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("motel");
                    Toast.makeText(HotelCheck.this,"Motels are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("motel");
                }

            }
        });privateguest =(CheckBox) findViewById(R.id.private_guest_room);
        privateguest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("private_guest_room");
                    Toast.makeText(HotelCheck.this,"AirBnBs are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("private_guest_room");
                }

            }
        });resorthotel =(CheckBox) findViewById(R.id.resort_hotel);
        resorthotel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("resort_hotel");
                    Toast.makeText(HotelCheck.this,"Resorts are included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("resort_hotel");
                }

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


        Set<String> includedstring = new HashSet<String>();
        includedstring.addAll(included);

        Set<String> excludedstring = new HashSet<String>();
        excludedstring.addAll(excluded);

        SharedPref.write("IncludedAct",includedstring);
        SharedPref.write("ExcludedAct", excludedstring);













    }
}
