package com.example.appthemovie;

import android.app.Application;

public class App extends Application {
    private static App INSTANCE;
    private com.example.appthemovie.Storage storage;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        storage = new com.example.appthemovie.Storage();
    }

    public com.example.appthemovie.Storage getStorage() {
        return storage;
    }
}
