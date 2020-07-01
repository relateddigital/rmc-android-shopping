package com.relateddigital.shoppingdemo.main;

import android.app.Application;

import euromsg.com.euromobileandroid.EuroMobileManager;

public class MainApplication extends Application {

    String appAlias  = "";

    @Override
    public void onCreate() {
        super.onCreate();

        EuroMobileManager euroMobileManager = EuroMobileManager.init(appAlias, getApplicationContext());
        euroMobileManager.registerToFCM(getApplicationContext());
    }
}
