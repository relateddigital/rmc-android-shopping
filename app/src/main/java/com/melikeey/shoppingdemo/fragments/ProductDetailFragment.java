package com.melikeey.shoppingdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.databinding.FragmentProductDetailBinding;
import com.melikeey.shoppingdemo.model.Product;

public class ProductDetailFragment extends Fragment {

    FragmentProductDetailBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_product_detail, container, false);

        Product product = (Product)  getArguments().getSerializable("product");

        mBinding.tvProductName.setText(product.getName());
        mBinding.tvProductContent.setText(product.getContent());
        mBinding.ivProduct.setBackgroundResource(product.getPic());

        mBinding.btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Sepete Eklendi", Toast.LENGTH_LONG).show();
            }
        });

        return mBinding.getRoot();
    }
}
