package com.example.planatrip;

import android.os.AsyncTask;
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


public class CheckFlights extends AppCompatActivity  {

    TextView cityname;
    TextView flightinfo;
    TextView tripname;
    TextView durationtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightscreen);
        SharedPref.init(getApplicationContext());

        String _tripname = SharedPref.read(SharedPref.TripName, (String) null);
        String departcode = SharedPref.read(SharedPref.FromDes, (String) null);
        String destinationcode = SharedPref.read(SharedPref.Destin, (String) null);
        String citydestination = SharedPref.read(SharedPref.CityName, (String) null);

        cityname = findViewById(R.id.destinationname);
        cityname.setText(citydestination);

        tripname = findViewById(R.id.Tripnammeflight);
        tripname.setText(_tripname);

        String returndate = SharedPref.read(SharedPref.Returndate, (String) null);
        String departuredate = SharedPref.read(SharedPref.departdate, (String) null);

        durationtime = findViewById(R.id.durantionflight);

        durationtime.setText(departuredate + " / " + returndate);

        Map<String,String> auth = new HashMap<>();
        auth.put("Api_Key", "dc9f2d25d8491f966db4ee52982271ba90a703469573bde8f895c6e0a51cea4f");
        SerpApi client = new SerpApi(auth);

        Map<String, String> parameter = new HashMap<>();
        parameter.put("q", "Coffee");
        parameter.put("location", "Austin, Texas, United States");
        parameter.put("hl", "en");
        parameter.put("gl", "us");
        parameter.put("google_domain", "google.com");
        parameter.put("api_key", "dc9f2d25d8491f966db4ee52982271ba90a703469573bde8f895c6e0a51cea4f");

        try {
            JsonObject results = client.search(parameter);
            Log.i("Results", results.toString());
        } catch (SerpApiException e) {
            Log.e("Error","It didnt Work");
            throw new RuntimeException(e);
        }


    }

}













