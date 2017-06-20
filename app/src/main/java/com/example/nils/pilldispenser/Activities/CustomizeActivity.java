package com.example.nils.pilldispenser.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nils.pilldispenser.Fragments.ConfigADayActivity;
import com.example.nils.pilldispenser.R;

public class CustomizeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize);
    }

    public void configPillBayButton(View view) {
        Intent intent = new Intent(CustomizeActivity.this, ConfigPillBayActivity.class);
        startActivity(intent);
    }

    public void configADayButton(View view) {
        Intent intent = new Intent(CustomizeActivity.this, ConfigADayActivity.class);
        startActivity(intent);
    }
}
