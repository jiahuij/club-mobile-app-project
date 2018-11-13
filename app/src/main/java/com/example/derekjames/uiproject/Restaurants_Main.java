package com.example.derekjames.uiproject;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurants_Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants__main);

    ////////////creates and formats the listView
        String[] restaurantsArray = new String[] {
                "Eagles Nest",
                "Common Grounds",
                "Heritage Cafe",
                "Talon",
                "Caf",
                "Blackstone Cafe",
                "Coffee Cart"
        };
        Integer[] imageId = {
                R.drawable.eaglesnest,
                R.drawable.commongrounds,
                R.drawable.heritagecafe,
                R.drawable.talon,
                R.drawable.caf,
                R.drawable.blackstonecafe,
                R.drawable.coffeecart
        };
        final ListView restaurantListView = (ListView) findViewById(R.id.RestaurantsListView);



        final List<String> myList = new ArrayList<String>(Arrays.asList(restaurantsArray));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList) {
            @Override public View getView(int pos, View convertView, ViewGroup parent) {
                View view = super.getView(pos, convertView,parent);
                ViewGroup.LayoutParams parameters = view.getLayoutParams();
                parameters.height = 400;
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                view.setLayoutParams(parameters);
                text.setTextSize(30);
                return  view;
            }
        };
        restaurantListView.setAdapter(arrayAdapter);
////////////////////////////////////////////////////////////////


        /////Switch between tabs

        BottomNavigationView tabBar = (BottomNavigationView) findViewById(R.id.tabBar);
        tabBar.setSelectedItemId(R.id.restaurantsicon);
        tabBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.chimesicon : ///////Go to chimes page
                       Intent intent1 = new Intent(Restaurants_Main.this,
                            com.example.derekjames.uiproject.Chime_Main_Tab.class);
                        startActivity(intent1);
                        return true;
                    case R.id.mapicon :
                        Intent intent2 = new Intent(Restaurants_Main.this,
                                com.example.derekjames.uiproject.Map.class);
                        startActivity(intent2);
                        return true;
                    case R.id.buildinghoursicon :
                        Intent intent3 = new Intent(Restaurants_Main.this,
                                com.example.derekjames.uiproject.Building_Hours.class);
                        startActivity(intent3);
                        return true;
                    case R.id.restaurantsicon :
                        Intent intent4 = new Intent(Restaurants_Main.this,
                                com.example.derekjames.uiproject.Restaurants_Main.class);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        ////////////////////////////////////////







    }
}
