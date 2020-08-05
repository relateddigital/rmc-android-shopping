package com.relateddigital.shoppingdemo.main;

import android.app.Application;
import android.util.Log;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.common.ApiException;
import com.relateddigital.shoppingdemo.Constants;
import com.visilabs.Visilabs;

import java.util.HashMap;

import euromsg.com.euromobileandroid.EuroMobileManager;

public class MainApplication extends Application {

    EuroMobileManager euroMobileManager;

    @Override
    public void onCreate() {
        super.onCreate();

        Visilabs.CreateAPI(Constants.ORGANIZATION_ID, Constants.SITE_ID, "http://lgr.visilabs.net",
                Constants.DATASOURCE, "http://rt.visilabs.net", "Android", getApplicationContext(), "http://s.visilabs.net/json", "http://s.visilabs.net/actjson", 30000, "http://s.visilabs.net/geojson", true);

        euroMobileManager = EuroMobileManager.init("shopping-android", "shopping-huawei", getApplicationContext());
        euroMobileManager.registerToFCM(getApplicationContext());
        euroMobileManager.setPushIntent("com.relateddigital.shoppingdemo.CampaignActivity", getApplicationContext());

        if (!EuroMobileManager.checkPlayService(getApplicationContext())) {
            setHuaweiTokenToEuromessage();
        } else {
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                @Override
                public void onSuccess(InstanceIdResult instanceIdResult) {

                    String token = instanceIdResult.getToken();

                    setVL(token);

                    setEM(token);
                }
            });
        }
    }

    private void setEM(String token) {
        euroMobileManager.subscribe(token, getApplicationContext());
        euroMobileManager.setNotificationColor("#03DAC5");
    }

    private void setHuaweiTokenToEuromessage() {

        new Thread() {
            @Override
            public void run() {
                try {
                    String appId = AGConnectServicesConfig.fromContext(getApplicationContext()).getString("client/app_id");
                    String token = HmsInstanceId.getInstance(getApplicationContext()).getToken(appId, "HCM");

                    euroMobileManager.subscribe(token, getApplicationContext());

                    Log.i("Huawei Token", "" + token);

                } catch (ApiException e) {
                    Log.e("Huawei Token", "get token failed, " + e);
                }
            }
        }.start();
    }

    private void setVL(String token) {


        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("OM.sys.TokenID", token);
        parameters.put("OM.sys.AppID", Constants.APP_ALIAS);

        Visilabs.CallAPI().customEvent("Open intent", parameters);
    }
}
