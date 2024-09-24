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
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;


public class CheckHotels extends AppCompatActivity {

    LocationFinder locationfinder = new LocationFinder();
    String apiKey = BuildConfig.PLACES_API_KEY;
    TextView firsthotelinfo;
    TextView secondhotelinfo;
    TextView thirdhotelinfo;
    TextView fourthhotelinfo;
    TextView Fifthhotelinfo;
    TextView   hotelnameone;
    TextView hotelnametwo;
    TextView hotelnamethree;
    TextView hotelnamefour;
    TextView hotelnamefive;
    TextView hoteldestination;

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
    String newline = "\n";



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

        hoteldestination = (TextView) findViewById(R.id.hoteldestinationname);
        hoteldestination.setText(hotellocation);

        hotelnameone = (TextView) findViewById(R.id.hotel1);
        firsthotelinfo = (TextView) findViewById(R.id.firsthoteltextresponse);
        hotelnametwo = (TextView)findViewById(R.id.hotel2);
        secondhotelinfo = (TextView)findViewById(R.id.secondhoteltextresponse);
        hotelnamethree = (TextView) findViewById(R.id.act3);
        thirdhotelinfo = (TextView) findViewById(R.id.thirdhoteltextresponse);
        hotelnamefour = (TextView) findViewById(R.id.act4);
        fourthhotelinfo = (TextView) findViewById(R.id.fourthhoteltextresponse);
        hotelnamefive = (TextView) findViewById(R.id.act5);
        Fifthhotelinfo = (TextView) findViewById(R.id.fifthhoteltextresponse);





       LatLng citycoord = locationfinder.GetLongLatFromAdress(this, hotellocation);



        final List<Place.Field> placefields = Arrays.asList(Place.Field.DISPLAY_NAME, Place.Field.FORMATTED_ADDRESS, Place.Field.EDITORIAL_SUMMARY, Place.Field.RATING, Place.Field.NATIONAL_PHONE_NUMBER);

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
                    String firsthotelname = places.get(0).getDisplayName().toString();
                    String firsthotelad = places.get(0).getFormattedAddress();
                    String firsthotelsumm = places.get(0).getEditorialSummary();
                    String firsthotelrating = places.get(0).getRating().toString();
                    String firsthotelnum = places.get(0).getNationalPhoneNumber();

                    maininfo1.append(firsthotelname).append(newline).append(firsthotelad).append(newline).append(firsthotelnum);

                    hotelnameone.setText(maininfo1);

                    subinfo1.append(firsthotelrating).append(newline).append(firsthotelsumm).append(newline);
                    firsthotelinfo.setText(subinfo1);


                    String secondplacead  = places.get(1).getFormattedAddress();
                    String secondplacenum = places.get(1).getNationalPhoneNumber();
                    String secondplacename = places.get(1).getDisplayName();


                    String secondplacesummary = places.get(1).getEditorialSummary();
                    String secondactrating = places.get(1).getRating().toString();

                    maininfo2.append(secondplacename).append(newline).append(secondplacead).append(newline).append(secondplacenum);

                    hotelnametwo.setText(maininfo2);

                    subinfo2.append(secondactrating).append(newline).append(secondplacesummary).append(newline);
                    secondhotelinfo.setText(subinfo2);

                    String thirdplacead  = places.get(2).getFormattedAddress();
                    String thirdplacenum = places.get(2).getNationalPhoneNumber();
                    String thirdplacename = places.get(2).getDisplayName();


                    String thirdplacesummary = places.get(2).getEditorialSummary();
                    String thirdactrating = places.get(2).getRating().toString();

                    maininfo3.append(thirdplacename).append(newline).append(thirdplacead).append(newline).append(thirdplacenum);

                    hotelnamethree.setText(maininfo3);

                    subinfo3.append(thirdactrating).append(newline).append(thirdplacesummary).append(newline);
                    thirdhotelinfo.setText(subinfo3);

                    String fourthplacead  = places.get(3).getFormattedAddress();
                    String fourthplacenum = places.get(3).getNationalPhoneNumber();
                    String fourthplacename = places.get(3).getDisplayName();


                    String fourthplacesummary = places.get(3).getEditorialSummary();
                    String fourthactrating = places.get(3).getRating().toString();
                    maininfo4.append(fourthplacename).append(newline).append(fourthplacead).append(newline).append(fourthplacenum);

                    hotelnamefour.setText(maininfo4);

                    subinfo4.append(fourthactrating).append(newline).append(fourthplacesummary).append(newline);
                    fourthhotelinfo.setText(subinfo4);
                    String fifthplacead  = places.get(4).getFormattedAddress();
                    String fifthplacenum = places.get(4).getNationalPhoneNumber();
                    String fifthplacename = places.get(4).getDisplayName();


                    String fifthplacesummary = places.get(4).getEditorialSummary();
                    String fifthactrating = places.get(4).getRating().toString();


                    maininfo5.append(fifthplacename).append(newline).append(fifthplacead).append(newline).append(fifthplacenum);

                    hotelnamefive.setText(maininfo5);

                    subinfo5.append(fifthactrating).append(newline).append(fifthplacesummary).append(newline);
                    Fifthhotelinfo.setText(subinfo5);






                });








    }



}
