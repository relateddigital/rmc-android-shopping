package com.relateddigital.shoppingdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.FragmentLoginBinding;
import com.relateddigital.shoppingdemo.SharedPref;
import com.relateddigital.shoppingdemo.tabs.HomeFragment;
import com.visilabs.Visilabs;

import java.util.Objects;

public class LoginFragment extends Fragment {
    SharedPref sharedPref;

    FragmentLoginBinding mBinding;

    String email;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false);

        sharedPref = new SharedPref(getActivity());

        checkAuth();

        mBinding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loginAction();

                email = sharedPref.getStr("email");

                Visilabs.CallAPI().login(email);

            }
        });

        mBinding.btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.openFragment(new RegisterFragment(), Objects.requireNonNull(getActivity()), "register");

            }
        });

        return mBinding.getRoot();
    }

    private void checkAuth() {
        if (sharedPref.getInt("login") == 1) {
            Utils.openFragment(new HomeFragment(), Objects.requireNonNull(getActivity()), "home");
        }
    }

    public void loginAction() {

        Utils.showMessage("Giriş Yapıldı", getActivity());

        sharedPref.setStr("email", "test@test.com");
        sharedPref.setBool("login", true);

        Utils.openFragment(new HomeFragment(), Objects.requireNonNull(getActivity()), "home");
    }
}

