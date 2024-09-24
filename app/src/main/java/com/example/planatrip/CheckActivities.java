package com.example.planatrip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CheckActivities extends Activity {
    String apiKey = BuildConfig.PLACES_API_KEY;
    List<String> includedact = new ArrayList<String>();
    List<String> excludedact = new ArrayList<String>();
    LatLng center;
    LocationFinder locateadress = new LocationFinder();
    TextView searcharea;
    Button mainmenubutton;
    TextView maininfoact1;
    TextView subinfoact1;
    TextView maininfoact2;
    TextView subinfoact2;
    TextView maininfoact3;
    TextView subinfoact3;
    TextView maininfoact4;
    TextView subinfoact4;
    TextView maininfoact5;
    TextView subinfoact5;


    StringBuilder maininfo1 = new StringBuilder();
    StringBuilder subinfo1 = new StringBuilder();
    StringBuilder maininfo2 = new StringBuilder();
    StringBuilder subinfo2 = new StringBuilder();
    StringBuilder maininfo3 = new StringBuilder();
    StringBuilder subinfo3 = new StringBuilder();
    StringBuilder maininfo4 = new StringBuilder();
    StringBuilder subinfo4 = new StringBuilder();
    StringBuilder maininfo5 = new StringBuilder();
    StringBuilder subinfo5 = new StringBuilder();


    String space = " ";
    String newline = "\n";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eventscreen);

        mainmenubutton = (Button)findViewById(R.id.acthomebutton);
        mainmenubutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextscreen = new Intent(CheckActivities.this, MainMenuScreen.class);
                startActivity(nextscreen);

            }
        });

        Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), apiKey);
        PlacesClient placesClient = Places.createClient(this);

        searcharea = findViewById(R.id.activitydestinationname);

        String locationaname = SharedPref.read(SharedPref.CityName, (String) null);

        searcharea.setText(locationaname);

        Log.i("Saved address", locationaname);






        maininfoact1 = (TextView) findViewById(R.id.act1);
        subinfoact1 = (TextView) findViewById(R.id.firstacttextresponse);
        maininfoact2 = (TextView)findViewById(R.id.act2);
        subinfoact2 = (TextView)findViewById(R.id.secondacttextresponse);
        maininfoact3 = (TextView) findViewById(R.id.act3);
        subinfoact3 = (TextView) findViewById(R.id.thirdacttextresponse);
        maininfoact4 = (TextView) findViewById(R.id.act4);
        subinfoact4 = (TextView) findViewById(R.id.fourthacttextresponse);
        maininfoact5 = (TextView) findViewById(R.id.act5);
        subinfoact5 = (TextView) findViewById(R.id.fifthacttextresponse);





        Set<String> included = SharedPref.read("IncludedAct", (Set<String>) null);
        Set<String> excluded = SharedPref.read("ExcludedAct", (Set<String>) null);

        includedact.addAll(included);
        excludedact.addAll(excluded);

        final List<Place.Field> placeFields = Arrays.asList(Place.Field.DISPLAY_NAME, Place.Field.FORMATTED_ADDRESS, Place.Field.NATIONAL_PHONE_NUMBER, Place.Field.EDITORIAL_SUMMARY, Place.Field.RATING);

        center = locateadress.GetLongLatFromAdress(this,locationaname);

        CircularBounds circle = CircularBounds.newInstance(center,1000);
        final List<String> includedtypes = includedact;
        final List<String> excludedtypes = excludedact;




        final SearchNearbyRequest searchNearbyRequest = SearchNearbyRequest.builder(circle,placeFields)
                .setIncludedTypes(includedtypes)
                .setExcludedTypes(excludedtypes)
                .setMaxResultCount(5)
                .build();
        placesClient.searchNearby(searchNearbyRequest)
                .addOnSuccessListener(response->
                {   List<Place> places = response.getPlaces();
                    String firstplacead  = places.get(0).getFormattedAddress();
                    String firstplacenum = places.get(0).getNationalPhoneNumber();
                    String firstplacename = places.get(0).getDisplayName();


                    String firstplacesummary = places.get(0).getEditorialSummary();
                    String firstactrating = places.get(0).getRating().toString();

                    maininfo1.append(firstplacename).append(newline).append(firstplacead).append(newline).append(firstplacenum);

                    maininfoact1.setText(maininfo1);

                    subinfo1.append(firstactrating).append(newline).append(firstplacesummary).append(newline);
                    subinfoact1.setText(subinfo1);


                    String secondplacead  = places.get(1).getFormattedAddress();
                    String secondplacenum = places.get(1).getNationalPhoneNumber();
                    String secondplacename = places.get(1).getDisplayName();


                    String secondplacesummary = places.get(1).getEditorialSummary();
                    String secondactrating = places.get(1).getRating().toString();

                    maininfo2.append(secondplacename).append(newline).append(secondplacead).append(newline).append(secondplacenum);

                    maininfoact2.setText(maininfo2);

                    subinfo2.append(secondactrating).append(newline).append(secondplacesummary).append(newline);
                    subinfoact2.setText(subinfo2);

                    String thirdplacead  = places.get(2).getFormattedAddress();
                    String thirdplacenum = places.get(2).getNationalPhoneNumber();
                    String thirdplacename = places.get(2).getDisplayName();


                    String thirdplacesummary = places.get(2).getEditorialSummary();
                    String thirdactrating = places.get(2).getRating().toString();

                    maininfo3.append(thirdplacename).append(newline).append(thirdplacead).append(newline).append(thirdplacenum);

                    maininfoact3.setText(maininfo3);

                    subinfo3.append(thirdactrating).append(newline).append(thirdplacesummary).append(newline);
                    subinfoact3.setText(subinfo3);

                    String fourthplacead  = places.get(3).getFormattedAddress();
                    String fourthplacenum = places.get(3).getNationalPhoneNumber();
                    String fourthplacename = places.get(3).getDisplayName();


                    String fourthplacesummary = places.get(3).getEditorialSummary();
                    String fourthactrating = places.get(3).getRating().toString();
                    maininfo4.append(fourthplacename).append(newline).append(fourthplacead).append(newline).append(fourthplacenum);

                    maininfoact4.setText(maininfo4);

                    subinfo4.append(fourthactrating).append(newline).append(fourthplacesummary).append(newline);
                    subinfoact4.setText(subinfo4);
                    String fifthplacead  = places.get(4).getFormattedAddress();
                    String fifthplacenum = places.get(4).getNationalPhoneNumber();
                    String fifthplacename = places.get(4).getDisplayName();


                    String fifthplacesummary = places.get(4).getEditorialSummary();
                    String fifthactrating = places.get(4).getRating().toString();


                    maininfo5.append(fifthplacename).append(newline).append(fifthplacead).append(newline).append(fifthplacenum);

                    maininfoact5.setText(maininfo5);

                    subinfo5.append(fifthactrating).append(newline).append(fifthplacesummary).append(newline);
                    subinfoact5.setText(subinfo5);










                });








    }
}
