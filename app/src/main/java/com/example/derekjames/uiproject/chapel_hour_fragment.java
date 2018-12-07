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
import android.widget.ListView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.IOException;


public class chapel_hour_fragment extends Fragment {

    TextView tryText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.chapel_hour_fragment,container,false);
        tryText = view.findViewById(R.id.tryText);


        new Connection().execute();


        ////////////////adds array into the listview
        String[] restaurantsArray = new String[] {
                "Chapel 1     12:00pm-8:00pm",
                "Chapel 2     12:00pm-8:00pm",
                "Chapel 3     12:00pm-8:00pm",
                "Chapel 4     12:00pm-8:00pm",
                "Chapel 5     12:00pm-8:00pm",
                "Chapel 6     12:00pm-8:00pm",
        };

        ListView listView = view.findViewById(R.id.chapelHour_listView);

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                restaurantsArray
        );

        listView.setAdapter(listViewAdapter);

        return view;
    }

    public class Connection extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {

            org.jsoup.nodes.Document doc = null;
            try {
                doc = Jsoup.connect("https://www.biola.edu/chapel").get();

                for(org.jsoup.nodes.Element row: doc.select(
                        "ul.chapel-list.active li"))
                {
                    final String ticker =
                            row.select("li:nth-of-type(1) > .item-body > .title").text();
                    tryText.setText(ticker);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}