package com.relateddigital.shoppingdemo.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentRegisterBinding;
import com.relateddigital.shoppingdemo.SharedPref;
import com.visilabs.Visilabs;

import java.util.Objects;


public class RegisterFragment extends Fragment {

    SharedPref sharedPref;

    FragmentRegisterBinding mBinding;

    String TAG = "RegisterFragment";
    String NAME = "Shopping";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_register, container, false);

        sharedPref = new SharedPref(getActivity());

        mBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Visilabs.CallAPI().signUp(sharedPref.getStr("email"));
                registerAction();
            }
        });

        Log.i(NAME, TAG);


        return mBinding.getRoot();
    }

    private void registerAction() {

        Utils.showMessage("Kayıt Oluşturuldu", getActivity());

        Utils.openFragment(new LoginFragment(), Objects.requireNonNull(getActivity()), "register");
    }
}
