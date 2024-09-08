package com.example.planatrip;

import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.trusted.sharing.ShareData;

import java.util.Calendar;

public class PlanATrip extends AppCompatActivity {
    EditText planname;
    EditText depart;
    EditText arrival;
    Button departuredate;
    Button returndate;
    TextView departday;
    TextView returnday;
    EditText cityname;
    private int depyear, depday, depmonth,retyear,retday,retmonth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tripstarting);

        SharedPref.init(getApplicationContext());

        planname = findViewById(R.id.planname);

        SharedPref.write(SharedPref.TripName, planname.getText().toString());

        depart = findViewById(R.id.departurecode);

        SharedPref.write(SharedPref.FromDes, depart.getText().toString());

        arrival = findViewById(R.id.arrivalcode);

        SharedPref.write(SharedPref.Destin, arrival.getText().toString());


        cityname = findViewById(R.id.citydestname);

        SharedPref.write(SharedPref.CityName, cityname.getText().toString());



        departday = findViewById(R.id.departdate);

        returnday = findViewById(R.id.returndate);



        departuredate = (Button) findViewById(R.id.departbutton);

        returndate = (Button) findViewById(R.id.returnbutton);

        departuredate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                depyear = c.get(Calendar.YEAR);
                depmonth = c.get(Calendar.MONTH);
                depday = c.get(Calendar.DAY_OF_WEEK);

                DatePickerDialog datpicker = new DatePickerDialog(PlanATrip.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        departday.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, depyear, depmonth, depday);

                datpicker.show();

            }
        });

        returndate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                retyear = cal.get(Calendar.YEAR);
                retmonth = cal.get(Calendar.MONTH);
                retday = cal.get(Calendar.DAY_OF_WEEK);

                DatePickerDialog datpicker = new DatePickerDialog(PlanATrip.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        returnday.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, retyear, retmonth, retday);

                datpicker.show();

            }


        });

        SharedPref.write(SharedPref.departdate, (depyear + "-" +  depmonth + "-" + depday));

        SharedPref.write(SharedPref.Returndate, (retyear + "-" +  retmonth + "-" + retday));


    }


};
