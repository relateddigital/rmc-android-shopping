package com.melikeey.shoppingdemo.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.databinding.FragmentBasketBinding;
import com.melikeey.shoppingdemo.fragments.ShippingFragment;

public class BasketFragment extends Fragment {

    FragmentBasketBinding mBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_basket, container, false);

        mBinding.tvProductContent.setText("Bilgisayar");
        mBinding.tvProductName.setText("Macbook");
        mBinding.ivProduct.setBackgroundResource(R.drawable.bilgisayar);

        mBinding.btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment shippingFragment = new ShippingFragment();
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction ft = manager.beginTransaction();
                ft.replace(R.id.container, shippingFragment);
                ft.commit();
            }
        });
        return mBinding.getRoot();
    }
}
