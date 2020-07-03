package com.relateddigital.shoppingdemo.main;

import android.app.Application;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.relateddigital.shoppingdemo.Constants;
import com.visilabs.Visilabs;

import java.util.HashMap;

import euromsg.com.euromobileandroid.EuroMobileManager;

public class MainApplication extends Application {

    EuroMobileManager euroMobileManager;

    @Override
    public void onCreate() {
        super.onCreate();

        FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
            @Override
            public void onSuccess(InstanceIdResult instanceIdResult) {

                String token = instanceIdResult.getToken();

                setVL(token);

                setEM(token);
            }
        });
    }

    private void setEM(String token) {

        euroMobileManager = EuroMobileManager.init(euromsg.com.euromobileandroid.Constants.APP_ALIAS, getApplicationContext());
        euroMobileManager.registerToFCM(getApplicationContext());
        euroMobileManager.subscribe(token, getApplicationContext());
        euroMobileManager.setNotificationColor("#03DAC5");
    }

    private void setVL(String token) {

        Visilabs.CreateAPI(Constants.ORGANIZATION_ID, Constants.SITE_ID, "http://lgr.visilabs.net",
                Constants.DATASOURCE, "http://rt.visilabs.net", "Android", getApplicationContext(), "http://s.visilabs.net/json", "http://s.visilabs.net/actjson", 30000, "http://s.visilabs.net/geojson", true);

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("OM.sys.TokenID", token);
        parameters.put("OM.sys.AppID", Constants.APP_ALIAS);

        Visilabs.CallAPI().customEvent("Open intent", parameters);
    }
}
