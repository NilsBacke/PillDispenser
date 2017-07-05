package com.example.nils.pilldispenser.Fragments.Sunday;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.nils.pilldispenser.ConfigDayFragmentCustomAdapter;
import com.example.nils.pilldispenser.DayRegiment;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.PillBayDatabaseHelper;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;
import java.util.Calendar;

public class SundayMornFragment extends Fragment {

    ListView listView;
    ArrayList<ListElement> list;

    public SundayMornFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment 
        final View view = inflater.inflate(R.layout.fragment_sunday_morn, container, false);
        listView = (ListView) view.findViewById(R.id.fraglistview);
        list = new ArrayList<>();
        list.addAll(((SundayActivity)getActivity()).getList("sundaymorning"));
        if (list.isEmpty()) {
            list.addAll(((SundayActivity)getActivity()).getList("pillbay"));
        }
        ConfigDayFragmentCustomAdapter adapter = new ConfigDayFragmentCustomAdapter(getActivity(), list, 1, 1);
        listView.setAdapter(adapter);




        final PillBayDatabaseHelper db = PillBayDatabaseHelper.getInstance(getActivity());
        final String day = "sundaymorning";


        Button changeTime = (Button) view.findViewById(R.id.button2);

        changeTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ListElement> items = new ArrayList<>();
                final TextClock textClock = (TextClock) view.findViewById(R.id.textClock2);
                String textClockStr = (String) textClock.getText();
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        textClock.setText(hourOfDay + ":" + minute);
                    }
                }, hour, minute, false); //No 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

                if (!textClockStr.equals(textClock.getText())) {
                    if (!db.getAllElements(day).isEmpty()) {
                        items.addAll(db.getAllElements(day));
                        db.clearDatabase(day);
                    }

                    for (ListElement element: items) {
                        db.addElement(day, element);
                    }
                }

            }
        });

        return view;
    }


}
