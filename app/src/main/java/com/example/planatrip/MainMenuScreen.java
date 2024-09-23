package com.example.planatrip;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainMenuScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

       Button planbutton = (Button) findViewById(R.id.plantripbutton);
       planbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent newscreen = new Intent(MainMenuScreen.this, PlanATrip.class);
               startActivity(newscreen);

           }
       });
       Button checkflightsbutton = (Button) findViewById(R.id.CheckFlightsbutton);
       checkflightsbutton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent newscreen = new Intent(MainMenuScreen.this, PlanATrip.class);
               startActivity(newscreen);

           }
       });
        Button hotelbutton = (Button) findViewById(R.id.checkhotelsbutton);
        hotelbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newscreen = new Intent(MainMenuScreen.this, HotelCheck.class);
                startActivity(newscreen);

            }
        });
        Button activitybutton = (Button) findViewById(R.id.actvivitiesbutton);
        activitybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newscreen = new Intent(MainMenuScreen.this, PlanATrip.class);
                startActivity(newscreen);

            }
        });

        Button foodbutton = (Button) findViewById(R.id.restaurantsbutton);
        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newscreen = new Intent(MainMenuScreen.this, FoodSelecter.class);
                startActivity(newscreen);
            }
        });


        Button itinaraybutton = (Button) findViewById(R.id.checktripsbutton);
        itinaraybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newscreen = new Intent(MainMenuScreen.this, PlanATrip.class);
                startActivity(newscreen);
            }
        });



    }


}
