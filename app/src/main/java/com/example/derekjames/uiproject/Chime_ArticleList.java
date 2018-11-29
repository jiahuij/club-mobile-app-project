package com.example.derekjames.uiproject;

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
import android.view.WindowManager;
import android.widget.Button;

import java.lang.reflect.Field;

public class Chime_ArticleList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        setContentView(R.layout.activity_chime__article_list);

        Button Article1Btn = findViewById(R.id.Article1Btn);

        Article1Btn.setOnClickListener(new View.OnClickListener()  {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Chime_ArticleList.this,
                        com.example.derekjames.uiproject.Chime_Full_Article.class);
                startActivity(intent);
            }
        });

        /////Switch between tabs
        BottomNavigationView tabBar = (BottomNavigationView) findViewById(R.id.tabBar);
        disableTabBarShift(tabBar);
        tabBar.setSelectedItemId(R.id.chimesicon);
        tabBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.chimesicon : ///////Go to chimes page
                        Intent intent1 = new Intent(Chime_ArticleList.this,
                                com.example.derekjames.uiproject.Chime_Main_Tab.class);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent1);
                        return true;
                    case R.id.mapicon :
                        Intent intent2 = new Intent(Chime_ArticleList.this,
                                com.example.derekjames.uiproject.Map.class);
                        intent2.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent2);
                        return true;
                    case R.id.buildinghoursicon :
                        Intent intent3 = new Intent(Chime_ArticleList.this,
                                com.example.derekjames.uiproject.Building_Hours.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent3);
                        return true;
                    case R.id.restaurantsicon :
                        Intent intent4 = new Intent(Chime_ArticleList.this,
                                com.example.derekjames.uiproject.Restaurants_Main.class);
                        intent4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent4);
                        return true;
                }
                return true;
            }
        });
        ////////////////////////////////////////

    }




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
