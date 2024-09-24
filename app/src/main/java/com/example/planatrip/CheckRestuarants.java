package com.example.planatrip;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class CheckRestuarants extends Activity {

    List<String> includedshops = new ArrayList<String>();
    List<String> excludedshops = new ArrayList<String>();
    LatLng center;
    String apiKey = BuildConfig.PLACES_API_KEY;
    LocationFinder locateadress = new LocationFinder();
    TextView location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodscreen);
        Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), apiKey);

        PlacesClient placesClient = Places.createClient(this);



        SharedPref.init(getApplicationContext());
        location = findViewById(R.id.fooddestinationname);

        String locationname = SharedPref.read(SharedPref.CityName, (String) null);

        location.setText(locationname);

        Set<String> included = SharedPref.read("IncludedShops", (Set<String>) null);
        Set<String> excluded = SharedPref.read("ExcludedShops", (Set<String>) null);

        includedshops.addAll(included);
        excludedshops.addAll(excluded);

        final List<Place.Field> placeFields = Arrays.asList(Place.Field.DISPLAY_NAME);

        center = locateadress.GetLongLatFromAdress(this,locationname);

        CircularBounds circle = CircularBounds.newInstance(center, 3000);

        final List<String> includedtypes = includedshops;
        final List<String> excludedtypes = excludedshops;


        final SearchNearbyRequest searchNearbyRequest = SearchNearbyRequest.builder(circle,placeFields)
                .setIncludedTypes(includedtypes)
                .setExcludedTypes(excludedtypes)
                .setMaxResultCount(5)
                .build();

        placesClient.searchNearby(searchNearbyRequest)
                .addOnSuccessListener(repsonse->{
                    List<Place> places = repsonse.getPlaces();

                    for(int i = 0; i < places.size(); i++){
                        Log.i("Place", places.get(i).toString());
                    }
                });















    }
}
