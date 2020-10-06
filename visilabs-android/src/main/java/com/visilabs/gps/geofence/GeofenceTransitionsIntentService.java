package com.visilabs.gps.geofence;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.core.app.JobIntentService;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.visilabs.Injector;
import com.visilabs.Visilabs;
import com.visilabs.VisilabsResponse;
import com.visilabs.api.VisilabsGeofenceRequest;
import com.visilabs.api.VisilabsCallback;
import com.visilabs.gps.entities.VisilabsGeoFenceEntity;
import com.visilabs.gps.manager.GpsManagerMoreThanOreo;
import com.visilabs.gps.util.GeoFencesUtils;
import com.visilabs.json.JSONArray;

import java.util.List;

public class GeofenceTransitionsIntentService extends JobIntentService {

    private static final String TAG = "GeofenceTIService";

    public static void enqueueWork(Context context, Intent intent) {
        enqueueWork(context, GeofenceTransitionsIntentService.class, 573, intent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (Visilabs.CallAPI() == null) {
            Visilabs.CreateAPI(getApplicationContext());
        }
        Visilabs.CallAPI().startGpsManager();
    }

    @Override
    protected void onHandleWork(Intent intent) {
        Log.v(TAG, "onHandleWork");
        if (Visilabs.CallAPI() == null) {
            Visilabs.CreateAPI(getApplicationContext());
        }

        Visilabs.CallAPI().startGpsManager();

        final GeofencingEvent geoFenceEvent = GeofencingEvent.fromIntent(intent);
        if (geoFenceEvent.hasError()) {
            int errorCode = geoFenceEvent.getErrorCode();
            Log.e(TAG, "Location Services error: " + errorCode);
            return;
        } else {
            final GpsManagerMoreThanOreo gpsManager = Injector.INSTANCE.getGpsManagerMoreThanOreo();
            if (gpsManager == null)
                return;
            final List<Geofence> triggerList = geoFenceEvent.getTriggeringGeofences();

            if (Looper.myLooper() == null)
                Looper.prepare();
            Handler mainHandler = new Handler(Looper.getMainLooper());
            Runnable myRunnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Log.d("triggered", getClosestGoefence(gpsManager, triggerList).getRequestId());
                        geoFenceTriggered(getClosestGoefence(gpsManager, triggerList).getRequestId(), geoFenceEvent.getGeofenceTransition());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            mainHandler.post(myRunnable);
            if (Looper.myLooper() == null)
                Looper.loop();
        }
    }

    private void geoFenceTriggered(String geofence_guid, int transition) throws Exception {
        Log.i(TAG, geofence_guid);

        VisilabsGeofenceRequest request = new VisilabsGeofenceRequest(Visilabs.CallAPI().getContext());
        request.setAction("process");
        request.setApiVer("Android");

        String[] geofenceParts = geofence_guid.split("_");
        if (geofenceParts != null && geofenceParts.length > 2) {
            request.setActionID(geofenceParts[0]);
            request.setGeofenceID(geofenceParts[2]);
            VisilabsCallback callback = new VisilabsCallback() {
                @Override
                public void success(VisilabsResponse response) {
                    String rawResponse = response.getRawResponse();

                }

                @Override
                public void fail(VisilabsResponse response) {
                    String rawResponse = response.getRawResponse();
                    JSONArray array = response.getArray();
                }
            };
            request.executeAsync(callback);
        }
    }

    private Geofence getClosestGoefence(GpsManagerMoreThanOreo gpsManager, List<Geofence> triggerList) {
        if (triggerList.size() == 0) {
            return  null;
        } else if (triggerList.size() ==1) {
            return  triggerList.get(0);
        } else {
            double lastKnownLatitude = gpsManager.getLastKnownLocation().getLatitude();
            double lastKnownLongitude = gpsManager.getLastKnownLocation().getLongitude();
            Geofence triggeredGeofence  = null;
            Double minDistance = Double.MAX_VALUE;
            for (final Geofence geofence : triggerList) {
                for(VisilabsGeoFenceEntity geoFenceEntity: gpsManager.activeGeoFenceEntityList) {
                        double distance = GeoFencesUtils.haversine(lastKnownLatitude, lastKnownLongitude, Double.parseDouble(geoFenceEntity.lat), Double.parseDouble(geoFenceEntity.lng));
                        if(distance < minDistance){
                            triggeredGeofence = geofence;
                            minDistance = distance;

                        break;
                    }
                }
            }
            return triggeredGeofence;
        }

    }}

