package com.example.nils.pilldispenser.Fragments.Monday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nils.pilldispenser.BaseDrawerActivity;
import com.example.nils.pilldispenser.R;

public class MondayActivity extends BaseDrawerActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_monday, frameLayout);
        setTitle("Monday");
    }
}
