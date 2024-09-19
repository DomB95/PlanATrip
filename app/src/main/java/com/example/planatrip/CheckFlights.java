package com.example.planatrip;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import okhttp3.*;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;

import serpapi.SerpApi;
import serpapi.SerpApiException;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class CheckFlights extends AppCompatActivity {

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
    protected void onStart(){
        super.onStart();

            Map<String, String> auth = new HashMap<>();
            auth.put("api_key", "dc9f2d25d8491f966db4ee52982271ba90a703469573bde8f895c6e0a51cea4f");
            SerpApi serpapi = new SerpApi(auth);

            Map<String, String> parameter = new HashMap<>();
            parameter.put("q", "Coffee");
            parameter.put("location", "Austin, Texas, United States");
            parameter.put("hl", "en");
            parameter.put("gl", "us");
            parameter.put("google_domain", "google.com");
            parameter.put("safe", "active");
            parameter.put("start", "10");
            parameter.put("num", "10");
            parameter.put("device", "desktop");
            try {
                JsonObject results = serpapi.search(parameter);
                System.out.print(results.getAsString());
            } catch (SerpApiException e) {

                Log.e("error","Error occurred during API call",e);
                throw new RuntimeException(e);
            }
        }
}













