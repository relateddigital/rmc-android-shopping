package com.relateddigital.shoppingdemo.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentProfileBinding;
import com.relateddigital.shoppingdemo.SharedPref;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.main.MainActivity;

public class ProfileFragment extends Fragment {

    SharedPref sharedPref;

    FragmentProfileBinding mBinding;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_profile, container, false);

        sharedPref = new SharedPref(getActivity());

        mBinding.tvEmail.setText("Email : " + sharedPref.getStr("email"));

        mBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutAction();
            }
        });

        return mBinding.getRoot();
    }

    private void logoutAction() {

        Utils.showMessage("Çıkış Yapıldı", getActivity());

        sharedPref.setStr("email", "");
        sharedPref.setBool("login", false);

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
