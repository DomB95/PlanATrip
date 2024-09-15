package com.example.planatrip;
import com.google.gson.JsonObject;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.HashMap;
import java.util.Map;

public class CheckFlights extends AppCompatActivity {

    TextView cityname;
    TextView flightinfo;
    TextView tripname;
    TextView durationtime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flightscreen);
        SharedPref.init(getApplicationContext());

        String _tripname = SharedPref.read(SharedPref.TripName, null);
        String departcode = SharedPref.read(SharedPref.FromDes, null);
        String destinationcode = SharedPref.read(SharedPref.Destin, null);
        String citydestination = SharedPref.read(SharedPref.CityName, null);

        cityname = findViewById(R.id.destinationname);
        cityname.setText(citydestination);

        tripname = findViewById(R.id.Tripnammeflight);
        tripname.setText(_tripname);

        String returndate = SharedPref.read(SharedPref.Returndate, null);
        String departuredate = SharedPref.read(SharedPref.departdate, null);

        durationtime = findViewById(R.id.durantionflight);

        durationtime.setText(departuredate + " / " + returndate);


        Map<String, String> parameter = new HashMap<>();

        parameter.put("engine", "google_flights");
        parameter.put("departure_id", departcode);
        parameter.put("arrival_id", destinationcode);
        parameter.put("outbound_date", departuredate);
        parameter.put("return_date", returndate);
        parameter.put("currency", "USD");
        parameter.put("hl", "en");
        parameter.put("api_key", "b5088acc7f6118bf4af1c85ee12f811d5166586c89802a20b97fbc47a760b398");

    }
}







