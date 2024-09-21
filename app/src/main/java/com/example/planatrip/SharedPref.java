package com.example.planatrip;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;


public class SharedPref
{   private static SharedPreferences profiledata;
    public static final String Username = "username";
    public static final String Email = "email";
    public static final String Password = "password";
    public static final String TripName = "tripname";
    public static final String FromDes = "fromdes";
    public static final String Destin = "todes";
    public static final String departdate = "departure";
    public static final String Returndate = "return";
    public static final String CityName = "cityname";


    public static void init(Context context)
    {
        if(profiledata == null)
            profiledata = context.getSharedPreferences(context.getPackageName(), Activity.MODE_PRIVATE);
    }

    public static String read(String key, String defValue) {
        return profiledata.getString(key, defValue);
    }

    public static void write(String key, String value) {
        SharedPreferences.Editor prefsEditor = profiledata.edit();
        prefsEditor.putString(key, value);
        prefsEditor.apply();

    }

    public static boolean read(String key, boolean defValue) {
        return profiledata.getBoolean(key, defValue);
    }

    public static void write(String key, boolean value) {
        SharedPreferences.Editor prefsEditor = profiledata.edit();
        prefsEditor.putBoolean(key, value);
        prefsEditor.apply();

    }

    public static Integer read(String key, int defValue) {
        return profiledata.getInt(key, defValue);
    }

    public static void write(String key, Integer value) {
        SharedPreferences.Editor prefsEditor = profiledata.edit();
        prefsEditor.putInt(key, value).apply();


    }

    public static void clear(){
        SharedPreferences.Editor prefsEditor = profiledata.edit();
        prefsEditor.clear().apply();

    }




}
