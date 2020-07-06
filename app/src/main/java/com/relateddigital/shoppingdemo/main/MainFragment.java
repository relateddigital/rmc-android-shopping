package com.relateddigital.shoppingdemo.main;

import android.os.Bundle;
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
import com.relateddigital.shoppingdemo.tabs.HomeFragment;

import java.util.Objects;

public class MainFragment extends Fragment {

    SharedPref sharedPref;

    FragmentMainBinding mBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);

        sharedPref = new SharedPref(getActivity());

       if (sharedPref.getInt("login") == 1) {
            Utils.openFragment(new HomeFragment(), Objects.requireNonNull(getActivity()), "home");
        } else {
            Utils.openFragment(new LoginFragment(), Objects.requireNonNull(getActivity()), "login");
        }

        return mBinding.getRoot();
    }
}