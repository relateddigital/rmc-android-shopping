package com.relateddigital.shoppingdemo.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdem.databinding.ActivityMainBinding;
import com.relateddigital.shoppingdemo.adapters.TabAdapter;
import com.relateddigital.shoppingdemo.fragments.ProfileFragment;

import java.util.Objects;


public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    TabAdapter tabAdapter;

    ActivityMainBinding mainBinding;

    private int[] icons = {
            R.drawable.ic_baseline_home_24,
            R.drawable.ic_baseline_shopping_cart_24,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpTabs();
    }

    private void setUpTabs() {

        mainBinding.tabLayout.addTab(mainBinding.tabLayout.newTab().setText(""));
        mainBinding.tabLayout.addTab(mainBinding.tabLayout.newTab().setText(""));

        for (int i = 0; i < mainBinding.tabLayout.getTabCount(); i++) {
            Objects.requireNonNull(mainBinding.tabLayout.getTabAt(i)).setIcon(icons[i]);
        }

        mainBinding.tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        tabAdapter = new TabAdapter(0, getSupportFragmentManager(), mainBinding.tabLayout.getTabCount());
        mainBinding.viewPager.setAdapter(tabAdapter);

        mainBinding.viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mainBinding.tabLayout));

        mainBinding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mainBinding.viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new ProfileFragment(), "profile")
                    .addToBackStack(null)
                    .commit();
        }
        return super.onOptionsItemSelected(item);
    }
}