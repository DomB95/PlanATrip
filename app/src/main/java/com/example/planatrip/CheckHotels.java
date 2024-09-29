package com.example.planatrip;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.text.TextWatcher;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.CircularBounds;
import com.google.android.libraries.places.api.model.PhotoMetadata;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.api.net.FetchPhotoRequest;
import com.google.android.libraries.places.api.net.PlacesClient;
import com.google.android.libraries.places.api.net.SearchByTextRequest;
import com.google.android.libraries.places.api.net.SearchNearbyRequest;


import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CheckHotels extends AppCompatActivity {

    LocationFinder locationfinder = new LocationFinder();
    String apiKey = BuildConfig.PLACES_API_KEY;

    TextView firsthotelname;
    TextView firsthoteladdress;
    TextView firsthotelphone;
    TextView firsthotelrating;
    TextView firsthotelsummary;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelscreen);
        SharedPref.init(getApplicationContext());


        // Initialize the SDK
        Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), apiKey);

        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);

        String hotellocation = SharedPref.read(SharedPref.CityName, (String) null);

        firsthotelname = findViewById(R.id.firsthotelname);
        firsthoteladdress = findViewById(R.id.firsthoteladdress);
        firsthotelphone = findViewById(R.id.firsthotelphonenumber);
        firsthotelrating = findViewById(R.id.firsthotelrating);
        firsthotelsummary = findViewById(R.id.firsthotelsummary);







       LatLng citycoord = locationfinder.GetLongLatFromAdress(this, hotellocation);



        final List<Place.Field> placefields = Arrays.asList(Place.Field.DISPLAY_NAME, Place.Field.FORMATTED_ADDRESS, Place.Field.EDITORIAL_SUMMARY , Place.Field.NATIONAL_PHONE_NUMBER);

        CircularBounds circle = CircularBounds. newInstance(citycoord,1000);

        final List<String> includedTypes = Arrays.asList("hotel","motel","resort_hotel");

        final SearchNearbyRequest searchNearbyRequest =
                SearchNearbyRequest.builder(circle,placefields)
                        .setIncludedTypes(includedTypes)
                        .setMaxResultCount(5)
                        .build();

        placesClient.searchNearby(searchNearbyRequest)
                .addOnSuccessListener(response-> {
                    List<Place> places = response.getPlaces();
                    String firstname = places.get(0).getDisplayName().toString();
                    String firstaddress = places.get(0).getFormattedAddress();
                    String firstsumm = places.get(0).getEditorialSummary();
                    String firstrating = places.get(0).getRating().toString();

                    String firstnum = places.get(0).getNationalPhoneNumber();

                    firsthotelname.setText(firstname);
                    firsthotelphone.setText("Phone Number:  \t" + firstnum);
                    firsthoteladdress.setText("Address:   \t"+ firstaddress);
                    firsthotelrating.setText("Rating: \t" + firstrating);
                    firsthotelsummary.setText("Summary: \n" + firstsumm);









                });








    }



}
