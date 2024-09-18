package com.example.planatrip;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;



public class CheckFlights extends AppCompatActivity implements Runnable {

    TextView cityname;
    TextView flightinfo;
    TextView tripname;
    TextView durationtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightscreen);
        SharedPref.init(getApplicationContext());

        String _tripname = SharedPref.read(SharedPref.TripName, null);
        String departcode = SharedPref.read(SharedPref.FromDes, null);
        String destinationcode = SharedPref.read(SharedPref.Destin, null);
        String citydestination = SharedPref.read(SharedPref.CityName, null);

        cityname = findViewById(R.id.destinationname);
        cityname.setText(citydestination);

        tripname = findViewById(R.id.Tripnammeflight);
        tripname.setText(_tripname);

        String returndate = SharedPref.read(SharedPref.Returndate, null);
        String departuredate = SharedPref.read(SharedPref.departdate, null);

        durationtime = findViewById(R.id.durantionflight);

        durationtime.setText(departuredate + " / " + returndate);







    }

    @Override
    public void run() {

    }
}







