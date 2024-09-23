package com.example.planatrip;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.health.connect.datatypes.ActiveCaloriesBurnedRecord;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FoodSelecter extends AppCompatActivity {
    EditText locationtosearch;
    Button foodsearchbutton;
    CheckBox american;
    CheckBox barbeque;
    CheckBox brazilian;
    CheckBox fastfood;
    CheckBox icecream;
    CheckBox italian;
    CheckBox korean;
    CheckBox mexican;
    CheckBox sandwich;
    CheckBox seafood;
    CheckBox sushi;
    CheckBox thai;
    CheckBox vegan;
    CheckBox vegetarian;



    List<String> included = new ArrayList<>();
    List<String> excluded = new ArrayList<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.foodquestionaire);

        foodsearchbutton = (Button) findViewById(R.id.foodsearch);
        foodsearchbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextscreen = new Intent(FoodSelecter.this, CheckRestuarants.class);

                startActivity(nextscreen);
            }

        });



    }

    @Override
    protected void onStart(){
        super.onStart();

        american =(CheckBox) findViewById(R.id.american_restaurant);
        american.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("american_restaurant");
                    Toast.makeText(FoodSelecter.this,"american is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("american_restaurant");
                }

            }
        });

        barbeque = (CheckBox) findViewById(R.id.barbecue_restaurant);
        barbeque.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("barbecue_restaurant");
                    Toast.makeText(FoodSelecter.this,"barbeque is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("barbecue_restaurant");
                }

            }
        });
        brazilian = (CheckBox) findViewById(R.id.brazilian_restaurant);
        brazilian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("brazilian_restaurant");
                    Toast.makeText(FoodSelecter.this,"brazilian is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("brazilian_restaurant");
                }

            }
        });
        fastfood = (CheckBox) findViewById(R.id.fast_food_restaurant);
        fastfood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("fast_food_restaurant");
                    Toast.makeText(FoodSelecter.this,"fastfood is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("fast_food_restaurant");
                }

            }
        });

        icecream = (CheckBox) findViewById(R.id.ice_cream_shop);
        icecream.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("ice_cream_shop");
                    Toast.makeText(FoodSelecter.this,"icecream is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("ice_cream_shop");
                }

            }
        });
        italian = (CheckBox) findViewById(R.id.italian_restaurant);
        italian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("italian_restaurant");
                    Toast.makeText(FoodSelecter.this,"italian is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("italian_restaurant");
                }

            }
        });
        korean = (CheckBox) findViewById(R.id.korean_restaurant);
        korean.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("korean_restaurant");
                    Toast.makeText(FoodSelecter.this,"korean is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("korean_restaurant");
                }

            }
        });
        mexican = (CheckBox) findViewById(R.id.mexican_restaurant);
        mexican.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("mexican_restaurant");
                    Toast.makeText(FoodSelecter.this,"mexican is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("mexican_restaurant");
                }

            }
        });
        sandwich = (CheckBox) findViewById(R.id.sandwich_shop);
        sandwich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("sandwich_shop");
                    Toast.makeText(FoodSelecter.this,"sandwich is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("sandwich_shop");
                }

            }
        });
        seafood = (CheckBox) findViewById(R.id.seafood_restaurant);
        seafood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("seafood_restaurant");
                    Toast.makeText(FoodSelecter.this,"seafood is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("seafood_restaurant");
                }

            }
        });
        sushi = (CheckBox) findViewById(R.id.sushi_restaurant);
        sushi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("sushi_restaurant");
                    Toast.makeText(FoodSelecter.this,"sushi is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("sushi_restaurant");
                }

            }
        });
        thai = (CheckBox) findViewById(R.id.thai_restaurant);
        thai.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("thai_restaurant");
                    Toast.makeText(FoodSelecter.this,"thai is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("thai_restaurant");
                }

            }
        });
        vegan = (CheckBox) findViewById(R.id.vegan_restaurant);
        vegan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("vegan_restaurant");
                    Toast.makeText(FoodSelecter.this,"vegan is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("vegan_restaurant");
                }

            }
        });
        vegetarian = (CheckBox) findViewById(R.id.vegetarian_restaurant);
        vegetarian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    included.add("vegetarian_restaurant");
                    Toast.makeText(FoodSelecter.this,"vegetarian is included", Toast.LENGTH_LONG).show();
                }
                else {
                    excluded.add("vegetarian_restaurant");
                }

            }
        });



    }









    @Override
    protected void onPause(){
        super.onPause();
        SharedPref.init(getApplicationContext());

        locationtosearch = findViewById(R.id.foodlocationtext);
        String searchlocation = locationtosearch.getText().toString();
        SharedPref.write(SharedPref.CityName, searchlocation);

        Log.i("Saved Address", searchlocation);

        Set<String> includedstring = new HashSet<String>();
        includedstring.addAll(included);

        Set<String> excludedstring = new HashSet<String>();
        excludedstring.addAll(excluded);

        SharedPref.write("IncludedShops",includedstring);
        SharedPref.write("ExcludedShops", excludedstring);









    }


}
