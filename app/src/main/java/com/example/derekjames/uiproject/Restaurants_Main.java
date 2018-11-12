package com.example.derekjames.uiproject;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurants_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants__main);


        String[] restaurantsArray = new String[] {
                "Eagles Nest",
                "Common Grounds",
                "Heritage Cafe",
                "Talon",
                "Caf",
                "Coffee Cart"
        };
        final ListView restaurantListView = (ListView) findViewById(R.id.RestaurantsListView);
        final List<String> myList = new ArrayList<String>(Arrays.asList(restaurantsArray));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList) {
            @Override public View getView(int pos, View convertView, ViewGroup parent) {
                View view = super.getView(pos, convertView,parent);
                ViewGroup.LayoutParams parameters = view.getLayoutParams();
                parameters.height = 400;
                view.setLayoutParams(parameters);
                return  view;
            }
        };
        restaurantListView.setAdapter(arrayAdapter);





    }
}
