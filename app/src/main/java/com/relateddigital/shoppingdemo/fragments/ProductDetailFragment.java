package com.relateddigital.shoppingdemo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentProductDetailBinding;
import com.relateddigital.shoppingdemo.Utils;
import com.squareup.picasso.Picasso;
import com.visilabs.Visilabs;
import com.visilabs.VisilabsResponse;
import com.visilabs.api.VisilabsCallback;
import com.visilabs.api.VisilabsTargetRequest;
import com.visilabs.favs.FavsResponse;
import com.visilabs.inApp.VisilabsActionRequest;
import com.visilabs.json.JSONArray;
import com.visilabs.json.JSONObject;
import com.visilabs.util.VisilabsConstant;

import java.util.HashMap;

public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding mBinding;

    String TAG = "ProductDetailFragment";
    String NAME = "Shopping";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false);

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("OM.pv", "77");
        parameters.put("OM.pn", "Nectarine Blossom & Honey Body & Hand Lotion");
        parameters.put("OM.ppr", "39");
        Visilabs.CallAPI().customEvent("Product View", parameters);

        mBinding.tvProductBrand.setText("Kozmo "+ "- Ürün Kodu : " + 77  );
        mBinding.tvProductName.setText("Nectarine Blossom & Honey Body & Hand Lotion");
        Picasso.get().load("http://kodblogu.net/one2one/1.jpg").into(mBinding.ivProduct);

        mBinding.btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showMessage("Sepete Eklendi", getActivity());
            }
        });

        getRecommendations();

        getFavs();

        Log.i(NAME, TAG);

        return mBinding.getRoot();

    }

    public VisilabsCallback getCallBackVisi(){
        VisilabsCallback callback = new VisilabsCallback() {
            @Override
            public void success(VisilabsResponse response) {
                try{
                    JSONArray array = response.getArray();

                    for (int i = 0 ; i<array.length(); i++){
                        JSONObject jsonObject = array.getJSONObject(i);
                        String data = jsonObject.getString("data");


                    }
                    if(array != null) {
                        Log.d("Success", array.length() + "");
                    }
                }catch (Exception ex){
                    Log.e("Error", ex.getMessage(), ex);
                }
            }
            @Override
            public void fail(VisilabsResponse response) {
                Log.d("Error", response.getRawResponse());
            }
        };

        return callback;
    }

    private void getRecommendations() {
        try {
          /*  List<VisilabsTargetFilter> filters = new  ArrayList<>();
           VisilabsTargetFilter f = new VisilabsTargetFilter("title", "2","a");
            filters.add(f);*/

          VisilabsTargetRequest visilabsTargetRequest =  Visilabs.CallAPI().buildTargetRequest("6", "");
          visilabsTargetRequest.execute(getCallBackVisi());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getFavs(){
        try {
            VisilabsActionRequest visilabsActionRequest = Visilabs.CallAPI().requestAction(VisilabsConstant.FavoriteAttributeAction);
            visilabsActionRequest.executeAsyncAction(getVisilabsFavsCallback());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public VisilabsCallback getVisilabsFavsCallback() {

        return new VisilabsCallback() {
            @Override
            public void success(VisilabsResponse response) {
                try {

                    FavsResponse favsResponse = new Gson().fromJson(response.getRawResponse(), FavsResponse.class);

                    String favBrands = favsResponse.getFavoriteAttributeAction()[0].getActiondata().getFavorites().getBrand()[0];
                    Log.i("Favs 1.Brand", favBrands);
                    mBinding.tvFavs.setText("Favori Markalar :" + favBrands);

                } catch (Exception ex) {
                    Log.e("Error", ex.getMessage(), ex);
                }
            }

            @Override
            public void fail(VisilabsResponse response) {
                Log.d("Error", response.getRawResponse());
            }
        };
    }
}