package com.example.planatrip;

import android.app.Activity;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CheckHotels extends AppCompatActivity {
    String apiKey = BuildConfig.PLACES_API_KEY;
    double citynort = 0;
    double citywest = 0;
    String coord = String.valueOf(citynort) +" ," + String.valueOf(citywest);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelscreen);
        SharedPref.init(getApplicationContext());


        // Initialize the SDK
        Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), apiKey);

        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);

        String hotellocation = SharedPref.read(SharedPref.CityName, null);


       String coord =  determineLatLngFromAddress(this,hotellocation).toString();
       Log.i("City Coord", coord);

       LatLng citycoord = determineLatLngFromAddress(this, hotellocation);



        final List<Place.Field> placefields = Arrays.asList(Place.Field.DISPLAY_NAME);

        CircularBounds circle = CircularBounds. newInstance(citycoord,1000);

        final List<String> includedTypes = Arrays.asList("hotel","motel","resort_hotel");

        final SearchNearbyRequest searchNearbyRequest =
                SearchNearbyRequest.builder(circle,placefields)
                        .setIncludedTypes(includedTypes)
                        .setMaxResultCount(10)
                        .build();

        placesClient.searchNearby(searchNearbyRequest)
                .addOnSuccessListener(response->{
                    List<Place> places = response.getPlaces();
                   for(int i = 0; i < places.size(); i++){
                       Log.i("Place", places.get(i).toString());
                   }

                });




    }

    public LatLng determineLatLngFromAddress(Context appContext, String strAddress) {
        LatLng latLng = null;
        Geocoder geocoder = new Geocoder(appContext, Locale.getDefault());
        List<Address> geoResults = null;

        try {
            geoResults = geocoder.getFromLocationName(strAddress, 1);
            while (geoResults.size()==0) {
                geoResults = geocoder.getFromLocationName(strAddress, 1);
            }
            if (geoResults.size()>0) {
                Address addr = geoResults.get(0);
                latLng = new LatLng(addr.getLatitude(),addr.getLongitude());
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

        return latLng; //LatLng value of address
    }

}
