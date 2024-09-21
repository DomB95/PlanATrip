package com.example.planatrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class HotelCheck extends Activity {

    EditText hotellocation;
    FloatingActionButton nextscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelchecker);

        SharedPref.init(getApplicationContext());
        nextscreen = findViewById(R.id.searchhotels);
        nextscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newscreen = new Intent(HotelCheck.this, CheckHotels.class);
                startActivity(newscreen);
            }
        });


    }


    @Override
    protected void onStart(){
        super.onStart();

        hotellocation = findViewById(R.id.hotellocationtext);

        String location = hotellocation.getText().toString();

        SharedPref.write(SharedPref.CityName, location);

        Log.i("Saved cityname", location);







    }
}
