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


    private static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String USERNAME = "USERNAME";
    public static final String PASSWORD = "PASSWORD";

    public void run() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("source", "google_search");
            jsonObject.put("query", "adidas");
            jsonObject.put("geo_location", "California,United States");
            jsonObject.put("parse", true);

        } catch (JSONException e) {
            Log.e("Error", " Error parsing website", e);
            throw new RuntimeException(e);
        }

        Authenticator authenticator = (route, response) -> {
            String credential = Credentials.basic(USERNAME, PASSWORD);
            return response
                    .request()
                    .newBuilder()
                    .header(AUTHORIZATION_HEADER, credential)
                    .build();
        };

        OkHttpClient client = new OkHttpClient.Builder()
                .authenticator(authenticator)
                .readTimeout(180, TimeUnit.SECONDS)
                .build();

        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody body = RequestBody.create(jsonObject.toString(), mediaType);
        Request request = new Request.Builder()
                .url("https://realtime.oxylabs.io/v1/queries")
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.body() != null) {
                try (ResponseBody responseBody = response.body()) {
                    System.out.println(responseBody.string());
                }
            }
        } catch (Exception exception) {
            System.out.println("Error: " + exception.getMessage());
        }

        System.exit(0);
    }

    public static void main(String[] args) {
        new Thread(new CheckFlights()).start();
    }
}













