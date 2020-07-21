package com.relateddigital.shoppingdemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentMainBinding;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.fragments.LoginFragment;
import com.relateddigital.shoppingdemo.SharedPref;
import com.relateddigital.shoppingdemo.fragments.ProfileFragment;
import com.relateddigital.shoppingdemo.tabs.HomeFragment;

import java.util.Objects;

import euromsg.com.euromobileandroid.EuroMobileManager;

public class MainFragment extends Fragment {

    SharedPref sharedPref;

    FragmentMainBinding mBinding;

    String TAG = "MainFragment";
    String NAME = "Shopping";

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        sharedPref = new SharedPref(getActivity());

       if (sharedPref.getInt("login") == 1) {
            Utils.openFragment(new HomeFragment(), Objects.requireNonNull(getActivity()), "home");
        } else {
            Utils.openFragment(new LoginFragment(), Objects.requireNonNull(getActivity()), "login");
        }

        Log.i(NAME, TAG);

        if (getActivity().getIntent().getExtras() != null && EuroMobileManager.getInstance().getNotification(getActivity().getIntent()) != null) {
            EuroMobileManager.getInstance().reportRead(getActivity().getIntent().getExtras());
            notificationUrl(getActivity().getIntent());
        }

        return mBinding.getRoot();
    }

    private void notificationUrl(Intent intent) {

        if (EuroMobileManager.getInstance().getNotification(intent) != null) {

            Log.d("Euromessage", EuroMobileManager.getInstance().getNotification(intent).getUrl());

            if (EuroMobileManager.getInstance().getNotification(intent).getUrl().equals(":melike")){
                Fragment profileFragment = new ProfileFragment();

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, profileFragment, "product")
                        .addToBackStack(null)
                        .commit();
            }
        }

        if (EuroMobileManager.getInstance().getCarousels(intent) != null) {

            Log.d("Euromessage Carousel", EuroMobileManager.getInstance().getCarousels(intent).get(0).getUrl());
        }

    }
}