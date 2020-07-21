package com.relateddigital.shoppingdemo.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentProfileBinding;
import com.relateddigital.shoppingdemo.SharedPref;
import com.relateddigital.shoppingdemo.TestPush;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.main.MainActivity;

import euromsg.com.euromobileandroid.model.Message;
import euromsg.com.euromobileandroid.notification.PushNotificationManager;

public class ProfileFragment extends Fragment {

    SharedPref sharedPref;

    FragmentProfileBinding mBinding;

    String TAG = "ProfileFragment";
    String NAME = "Shopping";

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

        mBinding.btnSendPush.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PushNotificationManager pushNotificationManager = new PushNotificationManager();
                Message message = new Gson().fromJson(TestPush.testText, Message.class);
                pushNotificationManager.generateNotification(getActivity(), message, null);

            }
        });

        Log.i(NAME, TAG);

        return mBinding.getRoot();
    }

    private void logoutAction() {

        Utils.showMessage("Çıkış Yapıldı", getActivity());

        sharedPref.setStr("email", "");
        sharedPref.setInt("login", 0);

        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
