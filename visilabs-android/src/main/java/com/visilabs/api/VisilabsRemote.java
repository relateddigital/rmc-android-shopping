package com.visilabs.api;

import android.content.Context;

import com.visilabs.Visilabs;
import com.visilabs.json.JSONObject;
import com.visilabs.util.VisilabsLog;

import cz.msebera.android.httpclient.Header;


public abstract class VisilabsRemote implements VisilabsAction {

    public static final String PATH_PREFIX = "/box/srv/1.1/";

    protected static String LOG_TAG = "VisilabsRemote";

    protected VisilabsCallback mCallback;
    protected Context mContext;

    public VisilabsRemote(Context context) {
        mContext = context;
    }

    @Override
    public void executeAsync() throws Exception {
        executeAsync(mCallback);
    }

    @Override
    public void executeAsync(VisilabsCallback pCallback) throws Exception {
        try {
            VisilabsHttpClient.post(getApiURL(), buildHeaders(null), getRequestArgs(), pCallback, false, 10);
        } catch (Exception e) {
            VisilabsLog.e(LOG_TAG, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void execute(VisilabsCallback pCallback) throws Exception {
        try {
            VisilabsHttpClient.post(getApiURL(), buildHeaders(null), getRequestArgs(), pCallback, true, 10);
        } catch (Exception e) {
            VisilabsLog.e(LOG_TAG, e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public void executeAsyncAction(VisilabsCallback pCallback) throws Exception {
        try {
            VisilabsHttpClient.post(getApiURL(), buildHeaders(null), getRequestArgs(), pCallback, false, 10);
        } catch (Exception e) {
            VisilabsLog.e(LOG_TAG, e.getMessage(), e);
            throw e;
        }
    }

    public void setCallback(VisilabsCallback pCallback) {
        mCallback = pCallback;
    }

    protected String getApiURL() {
        return Visilabs.getTargetURL();
//        String apiUrl = StringUtils.removeTrailingSlash(AppProps.getInstance().getHost());
//        return apiUrl + PATH_PREFIX + getPath();
    }

    protected abstract String getPath();

    protected abstract JSONObject getRequestArgs();

    protected abstract Header[] buildHeaders(Header[] pHeaders) throws Exception;
}
