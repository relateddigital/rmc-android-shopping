package com.relateddigital.shoppingdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentProductDetailBinding;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.model.Product;
import com.visilabs.Visilabs;

import java.util.HashMap;
import java.util.Objects;
import java.util.UUID;

public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false);

        Product product = (Product) Objects.requireNonNull(getArguments()).getSerializable("product");

        HashMap<String, String> parameters = new HashMap<>();
        parameters.put("OM.pv", Objects.requireNonNull(product).getId());
        parameters.put("OM.pn", product.getName());
        parameters.put("OM.ppr", product.getPrice());
        Visilabs.CallAPI().customEvent("Product View", parameters);

        mBinding.btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showMessage("Sepete Eklendi", getActivity());
            }
        });

        return mBinding.getRoot();
    }
}