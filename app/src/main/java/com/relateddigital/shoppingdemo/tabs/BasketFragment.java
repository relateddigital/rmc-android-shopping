package com.relateddigital.shoppingdemo.tabs;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentBasketBinding;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.fragments.ShippingFragment;
import com.visilabs.Visilabs;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class BasketFragment extends Fragment {

    FragmentBasketBinding mBinding;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket, container, false);

        mBinding.tvProductContent.setText("Bilgisayar");
        mBinding.tvProductName.setText("Macbook");
        mBinding.ivProduct.setBackgroundResource(R.drawable.bilgisayar);

        HashMap<String, String> parameters= new HashMap<>();
        parameters.put("OM.pbid", String.valueOf(UUID.randomUUID()));
        parameters.put("OM.pb", "10;20");
        parameters.put("OM.pu","2;2");
        parameters.put("OM.ppr","30000;2000");
        Visilabs.CallAPI().customEvent("Cart", parameters);

        mBinding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                payAction();

                HashMap<String, String> parameters= new HashMap<>();
                parameters.put("OM.tid","1234568");
                parameters.put("OM.pp","10;20");
                parameters.put("OM.pu","2;2");
                parameters.put("OM.ppr","30000;2000");
                Visilabs.CallAPI().customEvent("Product Purchase", parameters);

            }
        });
        return mBinding.getRoot();
    }

    private void payAction() {
        Utils.openFragment(new ShippingFragment(), Objects.requireNonNull(getActivity()), "shipping");
    }
}
