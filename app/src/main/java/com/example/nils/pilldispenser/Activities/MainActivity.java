package com.example.nils.pilldispenser.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.nils.pilldispenser.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void DispenseDayButton(View view) {
        Intent intent = new Intent(MainActivity.this, DispenseIndivActivity.class);
        startActivity(intent);
    }

    public void customizeButtom(View view) {
        Intent intent = new Intent(MainActivity.this, CustomizeActivity.class);
        startActivity(intent);
    }
}
