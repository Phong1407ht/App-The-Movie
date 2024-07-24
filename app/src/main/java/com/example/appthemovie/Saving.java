package com.example.appthemovie;

import android.content.Context;
import android.content.SharedPreferences;

public class Saving {
    private static final String PREF_FILE = "pref_saving";
    private static Saving instance;

    public Saving() {
    }

    public static Saving getInstance() {
        if(instance == null){
            instance = new Saving();
        }
        return instance;
    }

    public void savePref(String key, String value){
        SharedPreferences pref = com.example.appthemovie.App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        pref.edit().putString(key,value).apply();
    }
    public String getPref(String key){
        SharedPreferences pref = com.example.appthemovie.App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        return pref.getString(key,null);
    }
    public void clearPref(String key){
        SharedPreferences pref = com.example.appthemovie.App.getInstance().getSharedPreferences(PREF_FILE, Context.MODE_PRIVATE);
        pref.edit().remove(key).apply();
    }
}
