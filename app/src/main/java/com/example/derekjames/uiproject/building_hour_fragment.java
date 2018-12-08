package com.example.derekjames.uiproject;

import android.os.AsyncTask;
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

import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class building_hour_fragment extends Fragment {



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.building_hours_fragment,container,false);
        ////////////////adds array into the listview


        String[] restaurantsArray = new String[7];
        restaurantsArray[0]="Library Hours";
        restaurantsArray[1]="Fitness Facility Hours";
        restaurantsArray[2]="Biola Cafe Hours";
        restaurantsArray[3]="Eagles' Nest Hours";
        restaurantsArray[4]="Common Grounds Hours";
        restaurantsArray[5]="Blackstone Cafe Hours";
        restaurantsArray[6]="Heritage Cafe Hours";

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


