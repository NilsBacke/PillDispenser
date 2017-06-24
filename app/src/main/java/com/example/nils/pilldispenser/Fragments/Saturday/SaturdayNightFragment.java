package com.example.nils.pilldispenser.Fragments.Saturday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nils.pilldispenser.ConfigDayFragmentCustomAdapter;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;

public class SaturdayNightFragment extends Fragment {

    ListView listView;
    ArrayList<ListElement> list;

    public SaturdayNightFragment() {
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
        View view = inflater.inflate(R.layout.fragment_saturday_night, container, false);
        listView = (ListView) view.findViewById(R.id.fraglistview);
        list = new ArrayList<>();
        list.addAll(((SaturdayActivity)getActivity()).getList("saturdaynight"));
        if (list.isEmpty()) {
            list.addAll(((SaturdayActivity)getActivity()).getList("pillbay"));
        }
        ConfigDayFragmentCustomAdapter adapter = new ConfigDayFragmentCustomAdapter(getActivity(), list, 7, 4);
        listView.setAdapter(adapter);
        return view;
    }


}
