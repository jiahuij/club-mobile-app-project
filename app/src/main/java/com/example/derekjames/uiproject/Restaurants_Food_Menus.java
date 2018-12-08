package com.example.derekjames.uiproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Field;
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
        disableTabBarShift(tabBar);

        tabBar.setSelectedItemId(R.id.restaurantsicon);
        tabBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.chimesicon : ///////Go to chimes page
                        Intent intent1 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Chime_Main_Tab.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        return true;
                    case R.id.mapicon :
                        Intent intent2 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Map.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        return true;
                    case R.id.buildinghoursicon :
                        Intent intent3 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Hours.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        return true;
                    case R.id.restaurantsicon :
                        Intent intent4 = new Intent(Restaurants_Food_Menus.this,
                                com.example.derekjames.uiproject.Restaurants_Main.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        ////////////////////////////////////////

        Intent startIntent = getIntent();
        String restaurantName = startIntent.getStringExtra("RestaurantName");
        TextView restaurantNameTextView = (TextView) findViewById(R.id.RestaurantTitle);
        restaurantNameTextView.setText(restaurantName);

        ////////////////adds array into the listview
       final String[] restaurantsArray2 = new String[] {
                "Menu Item 1: jskldfjskldajkiojs",
                "Menu Item 3: jskldfjskldajfksds",
                "Menu Item 4: jskldfjskldajfeiojs",
                "Menu Item 5: jskldfjskiojs",
                "Menu Item 6: jskldfjskojs",
                "Menu Item 7: jskldfjskldajfksiojs",
        };
        final ListView restaurantListView = (ListView) findViewById(R.id.RestaurantsMenuListView);
        final List<String> myList = new ArrayList<String>(Arrays.asList(restaurantsArray2));
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




        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("Position", String.valueOf(position));
                String restaurants = restaurantsArray2[position];
                Intent intent = new Intent(Restaurants_Food_Menus.this,
                        com.example.derekjames.uiproject.Restaurants_Food_Menus_2.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.putExtra("RestaurantNames", restaurants);
                startActivity(intent);
            }
        };
        restaurantListView.setOnItemClickListener(itemClickListener);


    }




    @SuppressLint("RestrictedApi")
    private void  disableTabBarShift(BottomNavigationView view) {
        BottomNavigationMenuView tabBar = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = tabBar.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(tabBar, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < tabBar.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) tabBar.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        }catch (NoSuchFieldException e)
        {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        }catch (IllegalAccessException e)
        {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }


}
