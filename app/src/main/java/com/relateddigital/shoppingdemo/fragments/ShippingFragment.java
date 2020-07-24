package com.relateddigital.shoppingdemo.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentShippingBinding;
import com.relateddigital.shoppingdemo.main.MainActivity;
import com.visilabs.Visilabs;

import java.util.HashMap;

public class ShippingFragment extends Fragment {

    FragmentShippingBinding mBinding;

    String TAG = "ShippingFragment";
    String NAME = "Shopping";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_shipping, container, false);

        mBinding.btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String> parameters = new HashMap<>();

                Visilabs.CallAPI().customEvent("Continue Shopping", parameters, getActivity());

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        Log.i(NAME, TAG);

        return mBinding.getRoot();
    }
}
