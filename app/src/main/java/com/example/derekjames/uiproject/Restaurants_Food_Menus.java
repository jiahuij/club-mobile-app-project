package com.example.derekjames.uiproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Restaurants_Food_Menus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants__food__menus);



        /////Switch between tabs
        BottomNavigationView tabBar = (BottomNavigationView) findViewById(R.id.tabBar);
        tabBar.setSelectedItemId(R.id.restaurantsicon);
        tabBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.chimesicon : ///////Go to chimes page
                        Intent intent1 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Chime_Main_Tab.class);
                        startActivity(intent1);
                        return true;
                    case R.id.mapicon :
                        Intent intent2 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Map.class);
                        startActivity(intent2);
                        return true;
                    case R.id.buildinghoursicon :
                        Intent intent3 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Building_Hours.class);
                        startActivity(intent3);
                        return true;
                    case R.id.restaurantsicon :
                        Intent intent4 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Restaurants_Main.class);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        ////////////////////////////////////////


        ////////////////adds array into the listview
       String[] restaurantsArray = new String[] {
                "Menu Item 1: jskldfjskldajkiojs",
                "Menu Item 3: jskldfjskldajfksds",
                "Menu Item 4: jskldfjskldajfeiojs",
                "Menu Item 5: jskldfjskiojs",
                "Menu Item 6: jskldfjskojs",
                "Menu Item 7: jskldfjskldajfksiojs",
        };
        final ListView restaurantListView = (ListView) findViewById(R.id.RestaurantsMenuListView);
        final List<String> myList = new ArrayList<String>(Arrays.asList(restaurantsArray));
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1, myList) {
            @Override public View getView(int pos, View convertView, ViewGroup parent) {
                View view = super.getView(pos, convertView,parent);
                ViewGroup.LayoutParams parameters = view.getLayoutParams();
                parameters.height = 300;
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                view.setLayoutParams(parameters);
                text.setTextSize(20);
                return  view;
            }
        };
        restaurantListView.setAdapter(arrayAdapter);
        /////////////////////////////////////////////////////////////////////////////////////////////





    }
}
