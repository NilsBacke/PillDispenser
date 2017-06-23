package com.example.nils.pilldispenser.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Spinner;

import com.example.nils.pilldispenser.DayRegiment;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.PillBayDatabaseHelper;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;

public class DispenseIndivActivity extends AppCompatActivity {

    private Spinner spinner;
    private PillBayDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispense_indiv);

        db = PillBayDatabaseHelper.getInstance(this);

        setupNumberPicker();
        addItemsToSpinner();
    }

    public void setupNumberPicker() {
        final NumberPicker numberPicker = (NumberPicker) findViewById(R.id.number_picker);
        numberPicker.setMaxValue(20);
        numberPicker.setMinValue(0);
        numberPicker.setWrapSelectorWheel(false);
        numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {

            }
        });
    }

    public void addItemsToSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> list = new ArrayList<String>();

        ArrayList<ListElement> savedlist = new ArrayList<>();
        savedlist.addAll(db.getAllElements("pillbay"));

        for (int i = 0; i < savedlist.size(); i++) {
            list.add(savedlist.get(i).getName());
        }

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
}
