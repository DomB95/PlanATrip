package com.example.planatrip;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;
import java.util.Locale;

public class LocationFinder {

    public LatLng GetLongLatFromAdress(Context appContext, String strAddress) {
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
