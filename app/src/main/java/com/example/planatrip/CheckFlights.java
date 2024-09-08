package com.example.planatrip;

import android.app.Activity;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;

import androidx.appcompat.app.AppCompatActivity;

public class CheckFlights extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightscreen);
        SharedPref.init(getApplicationContext());

        String tripname = SharedPref.read(SharedPref.TripName, null);
        String departcode = SharedPref.read(SharedPref.FromDes, null);
        String destinationcode = SharedPref.read(SharedPref.Destin, null);





    }
}
