package com.melikeey.shoppingdemo.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.databinding.FragmentProfileBinding;
import com.melikeey.shoppingdemo.fragments.SharedPref;
import com.melikeey.shoppingdemo.main.MainActivity;

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

                Toast.makeText(getActivity(), "Çıkış Yapıldı", Toast.LENGTH_LONG).show();

                sharedPref.setStr("email", "");
                sharedPref.setInt("login", 0);

                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return mBinding.getRoot();
    }
}
