package com.example.nils.pilldispenser.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.nils.pilldispenser.ConfigDayFragmentCustomAdapter;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.PillBayDatabaseHelper;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;


public class OneFragment extends Fragment {

    ListView listView;
    ArrayList<ListElement> list;

    public OneFragment() {
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
        View view = inflater.inflate(R.layout.fragment_one, container, false);


        listView = (ListView) view.findViewById(R.id.fraglistview);
        list = new ArrayList<>();
        list.addAll(((ConfigADayActivity)getActivity()).getList("sunday"));
        if (list.isEmpty()) {
            list.addAll(((ConfigADayActivity)getActivity()).getList("pillbay"));
        }
        Log.d("ArrayList", list.toString());
        ConfigDayFragmentCustomAdapter adapter = new ConfigDayFragmentCustomAdapter(getActivity(), list, 1);
        listView.setAdapter(adapter);

        return view;
    }

}
