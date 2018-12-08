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


     int buildingHoudCount = 0;

     private  class building
     {
         String buildingName;
         String buildingHours;
         String currentStatus;

         building(String buildingName, String buildingHours, String currentStatus)
         {
             this.buildingName = buildingName;
             this.buildingHours = buildingHours;
             this.currentStatus = currentStatus;
         }
     }building[] Building= new building[50];


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.building_hours_fragment,container,false);
        ////////////////adds array into the listview

        try {
            Void temp = new Connection().execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        String[] restaurantsArray = new String[buildingHoudCount];

        for(int i = 0; i <buildingHoudCount; i++)
        {
            restaurantsArray[i] = Building[i].buildingHours;
        }

        ListView listView = view.findViewById(R.id.buildingHour_listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                restaurantsArray
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }

    public class Connection extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            org.jsoup.nodes.Document doc = null;
            try {
                doc = Jsoup.connect("https://www.biola.edu/chapel").get();


                for (org.jsoup.nodes.Element row : doc.select(
                        "ul.chapel-list.active li")) {

                    if (row.select("li:nth-of-type(1).item-body.title").text().equals(" ")) {
                        continue;
                    } else {


                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }


}


