package com.relateddigital.shoppingdemo.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentHomeBinding;
import com.relateddigital.shoppingdemo.model.Product;
import com.relateddigital.shoppingdemo.adapters.HomeAdapter;
import com.visilabs.Visilabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeFragment extends Fragment {

    List<Product> productList;

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

        return mBinding.getRoot();
    }

    public List<Product> getProductList() {

        productList = new ArrayList<>();
        productList.add(new Product(10, "Bilgisayar", "Macbook", R.drawable.bilgisayar,"15000TL"));
        productList.add(new Product(20, "Tablet", "Samsung", R.drawable.samsung, "1000TL"));
        productList.add(new Product(30,"Telefon", "Huawei", R.drawable.huawei, "5000TL"));
        productList.add(new Product(50, "Oyun Konsolu", "Playstation", R.drawable.playstation, "5000TL"));
        productList.add(new Product(60, "Kulaklık", "Airpods", R.drawable.airpods, "1000TL"));

        return productList;
    }
}
