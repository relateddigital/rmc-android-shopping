package com.melikeey.shoppingdemo.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.melikeey.shoppingdemo.R;
import com.melikeey.shoppingdemo.tabs.HomeFragment;

public class LoginFragment extends Fragment {
    SharedPref sharedPref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        sharedPref = new SharedPref(getActivity());

        if (sharedPref.getInt("login") == 1) {
            Fragment mainFragment = new HomeFragment();
            getActivity().getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, mainFragment, "home")
                    .addToBackStack(null)
                    .commit();

        }

        Button btnLogin = view.findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(), "Giriş Yapıldı", Toast.LENGTH_LONG).show();

                sharedPref.setStr("email", "test@test.com");
                sharedPref.setInt("login", 1);
                Fragment mainFragment = new HomeFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, mainFragment, "home")
                        .addToBackStack(null)
                        .commit();

            }
        });

        Button btnRegister = view.findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment registerFragment = new RegisterFragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, registerFragment, "register")
                        .addToBackStack(null)
                        .commit();
            }
        });

        return view;
    }
}

