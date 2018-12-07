package com.example.derekjames.uiproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class building_hour_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.building_hours_fragment,container,false);
        ////////////////adds array into the listview
        String[] restaurantsArray = new String[] {
                "fd 1     12:00pm-8:00pm",
                "Building 2     12:00pm-8:00pm",
                "Building 3     12:00pm-8:00pm",
                "Building 4     12:00pm-8:00pm",
                "Building 5     12:00pm-8:00pm",
                "Building 6     12:00pm-8:00pm",
        };

        ListView listView = view.findViewById(R.id.buildingHour_listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                restaurantsArray
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }


}


