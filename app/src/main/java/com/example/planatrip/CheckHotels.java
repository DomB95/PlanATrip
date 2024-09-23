package com.example.planatrip;

import static android.content.ContentValues.TAG;

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
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CheckHotels extends AppCompatActivity {

    LocationFinder locationfinder = new LocationFinder();
    String apiKey = BuildConfig.PLACES_API_KEY;

    ImageView hotelimageone;
    TextView secondhotelinfo;
    TextView thirdhotelinfo;
    TextView fourthhotelinfo;
    TextView Fifthhotelinfo;
    TextView Sixthhotelinfo;
    TextView   hotelnameone;




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

        hotelnameone = findViewById(R.id.firsthoteltextresponse);


       String coord =  locationfinder.GetLongLatFromAdress(this,hotellocation).toString();
       Log.i("City Coord", coord);

       LatLng citycoord = locationfinder.GetLongLatFromAdress(this, hotellocation);



        final List<Place.Field> placefields = Arrays.asList(Place.Field.ID,Place.Field.DISPLAY_NAME);

        CircularBounds circle = CircularBounds. newInstance(citycoord,1000);

        final List<String> includedTypes = Arrays.asList("hotel","motel","resort_hotel");

        final SearchNearbyRequest searchNearbyRequest =
                SearchNearbyRequest.builder(circle,placefields)
                        .setIncludedTypes(includedTypes)
                        .setMaxResultCount(6)
                        .build();

        placesClient.searchNearby(searchNearbyRequest)
                .addOnSuccessListener(response-> {
                    List<Place> places = response.getPlaces();
                    for (int i = 0; i < places.size(); i++) {


                        Log.i("Place", places.get(i).toString());


                    }
                    String firsthotelname = places.get(0).getDisplayName().toString();
                    String secondhotelname = places.get(1).getDisplayName().toString();
                    String thirdhotelname = places.get(2).getDisplayName().toString();
                    String fourthhotelname = places.get(3).getDisplayName().toString();
                    String fifthhotelname = places.get(4).getDisplayName().toString();
                    String Sixthhotelname = places.get(5).getDisplayName().toString();


                    hotelnameone.setText(firsthotelname);

                });








    }



}
