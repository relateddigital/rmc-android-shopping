package com.relateddigital.shoppingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdemo.main.MainActivity;

public class CampaignActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_campaign);

        Button btnYes = findViewById(R.id.btn_yes);
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CampaignActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
