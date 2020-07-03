package com.relateddigital.shoppingdemo;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdemo.tabs.HomeFragment;

public class Utils {

    public static void  openFragment(Fragment fragment, FragmentActivity a, String tag){
        a.getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment, tag)
                .addToBackStack(null)
                .commit();
    }

    public static void showMessage(String msg, Context context) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }
}
