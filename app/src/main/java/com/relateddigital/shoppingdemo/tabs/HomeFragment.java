package com.relateddigital.shoppingdemo.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentHomeBinding;
import com.relateddigital.shoppingdemo.OnItemClickListener;
import com.relateddigital.shoppingdemo.TestJson;
import com.relateddigital.shoppingdemo.fragments.ProductDetailFragment;
import com.relateddigital.shoppingdemo.model.Product;
import com.relateddigital.shoppingdemo.adapters.HomeAdapter;
import com.visilabs.Visilabs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.NameList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Product> productList;

    String TAG = "HomeFragment";
    String NAME = "Shopping";

    FragmentHomeBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);

        mBinding.recyclerView.setHasFixedSize(true);
        mBinding.recyclerView.setLayoutManager(layoutManager);

        HomeAdapter homeAdapter = new HomeAdapter(getProductList());

        mBinding.recyclerView.setAdapter(homeAdapter);
        homeAdapter.notifyDataSetChanged();

        homeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Product product) {

                Fragment productDetailFragment = new ProductDetailFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, productDetailFragment, "product")
                        .addToBackStack(null)
                        .commit();
            }
        });

        Log.i(NAME, TAG);

        return mBinding.getRoot();
    }

    public List<Product> getProductList() {


        productList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(TestJson.test);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i); //0 for just retrieving first object you can loop it
                String id = obj.getString("ID");
                String name = obj.getString("Name");
                String image = obj.getString("Image");
                String brand = obj.getString("Brand");
                String price = obj.getString("DiscountedPrice");

                productList.add(new Product(id, name, brand, image, price));
            }

            //Similarly do it for others as well
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return productList;
    }
}
