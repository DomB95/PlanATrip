package com.example.planatrip;

import android.app.Activity;
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

import androidx.recyclerview.widget.RecyclerView;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.net.PlacesClient;


public class CheckHotels extends Activity {
    String apiKey = BuildConfig.PLACES_API_KEY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotelscreen);
        SharedPref.init(getApplicationContext());

        if (TextUtils.isEmpty(apiKey) || apiKey.equals("AIzaSyCYZnmoZaFwDGcpqz98M_P2A3ckhq213a0")) {
            Log.e("Places test", apiKey);
            finish();
            return;
        }
        System.out.println(apiKey);

        // Initialize the SDK
        Places.initializeWithNewPlacesApiEnabled(getApplicationContext(), apiKey);

        // Create a new PlacesClient instance
        PlacesClient placesClient = Places.createClient(this);


    }

}
