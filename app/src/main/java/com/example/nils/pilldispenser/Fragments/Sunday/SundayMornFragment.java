package com.example.nils.pilldispenser.Fragments.Sunday;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nils.pilldispenser.ConfigDayFragmentCustomAdapter;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;
import java.util.List;

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
        View view = inflater.inflate(R.layout.fragment_one, container, false);   
        listView = (ListView) view.findViewById(R.id.fraglistview); 
        list = new ArrayList<>(); 
        list.addAll(((SundayActivity)getActivity()).getList("sunday")); 
        if (list.isEmpty()) { 
            list.addAll(((SundayActivity)getActivity()).getList("pillbay")); 
        } 
        Log.d("ArrayList", list.toString()); 
        ConfigDayFragmentCustomAdapter adapter = new ConfigDayFragmentCustomAdapter(getActivity(), list, 1); 
        listView.setAdapter(adapter);          return view;
    }


}
