package com.example.planatrip;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ActivitySelector extends AppCompatActivity {
    EditText locationtosearch;
    Button actvitysearchbutton;
    CheckBox AmusementPark;
    CheckBox aquarium;
    CheckBox bowling_alley;
    CheckBox zoo;
    CheckBox museum;
    CheckBox sports_complex;
    CheckBox movie_theater;
    CheckBox jewelry_store;
    CheckBox bar;
    CheckBox casino;
    CheckBox night_club;
    CheckBox event_venue;
    CheckBox golf_course;
    CheckBox shopping_mall;

    List<String> included = new ArrayList<>();
    List<String> excluded = new ArrayList<>();





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitiesquestionaire);

        actvitysearchbutton = (Button) findViewById(R.id.activitysearchbutton);
        actvitysearchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(ActivitySelector.this, CheckActivities.class);

                startActivity(nextscreen);
            }

        });
    }

    @Override
    protected void onStart(){
        super.onStart();


        aquarium =(CheckBox) findViewById(R.id.aquarium);
        aquarium.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("aquarium");
                    Toast.makeText(ActivitySelector.this,"aquarium is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("aquarium");
                }

            }
        });

        AmusementPark = (CheckBox) findViewById(R.id.amusement_center);
        AmusementPark.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("amusement_park");
                    Toast.makeText(ActivitySelector.this,"AmusementPark is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("amusement_park");
                }

            }
        });
        bowling_alley = (CheckBox) findViewById(R.id.bowling_alley);
        bowling_alley.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("brazilian_restaurant");
                    Toast.makeText(ActivitySelector.this,"brazilian is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("brazilian_restaurant");
                }

            }
        });
        casino = (CheckBox) findViewById(R.id.casino);
        casino.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("casino");
                    Toast.makeText(ActivitySelector.this,"Casino is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("casino");
                }

            }
        });

        event_venue = (CheckBox) findViewById(R.id.event_venue);
        event_venue.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("event_venue");
                    Toast.makeText(ActivitySelector.this,"Event venues is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("event_venue");
                }

            }
        });
        movie_theater = (CheckBox) findViewById(R.id.movie_theater);
        movie_theater.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("movie_theater");
                    Toast.makeText(ActivitySelector.this,"Movies is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("movie_theater");
                }

            }
        });
        night_club = (CheckBox) findViewById(R.id.night_club);
        night_club.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("night_club");
                    Toast.makeText(ActivitySelector.this,"Night clubs is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("night_club");
                }

            }
        });
        bar = (CheckBox) findViewById(R.id.bar);
        bar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("bar");
                    Toast.makeText(ActivitySelector.this,"Bars is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("bar");
                }

            }
        });
        museum = (CheckBox) findViewById(R.id.museum);
        museum.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("museum");
                    Toast.makeText(ActivitySelector.this,"Museums is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("museum");
                }

            }
        });
        shopping_mall = (CheckBox) findViewById(R.id.shopping_mall);
        shopping_mall.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("shopping_mall");
                    Toast.makeText(ActivitySelector.this,"Malls is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("shopping_mall");
                }

            }
        });
        golf_course = (CheckBox) findViewById(R.id.golf_course);
        golf_course.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("golf_course");
                    Toast.makeText(ActivitySelector.this,"Golf courses is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("golf_course");
                }

            }
        });
        sports_complex = (CheckBox) findViewById(R.id.sports_complex);
        sports_complex.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("sports_complex");
                    Toast.makeText(ActivitySelector.this,"Sporting Complexes is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("sports_complex");
                }

            }
        });
        jewelry_store = (CheckBox) findViewById(R.id.jewelry_store);
        jewelry_store.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("jewelry_store");
                    Toast.makeText(ActivitySelector.this,"vegan is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("jewelry_store");
                }

            }
        });
        zoo = (CheckBox) findViewById(R.id.zoo);
        zoo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("zoo");
                    Toast.makeText(ActivitySelector.this,"Zoo is included", Toast.LENGTH_SHORT).show();
                }
                else {
                    excluded.add("zoo");
                }

            }
        });



    }

    @Override
    protected void onPause(){
        super.onPause();
        SharedPref.init(getApplicationContext());

        locationtosearch = findViewById(R.id.foodlocationtext);
        String searchlocation = locationtosearch.getText().toString();
        SharedPref.write(SharedPref.CityName, searchlocation);

        Log.i("Saved Address", searchlocation);

        Set<String> includedstring = new HashSet<String>();
        includedstring.addAll(included);

        Set<String> excludedstring = new HashSet<String>();
        excludedstring.addAll(excluded);

        SharedPref.write("IncludedAct",includedstring);
        SharedPref.write("ExcludedAct", excludedstring);
    }


}
