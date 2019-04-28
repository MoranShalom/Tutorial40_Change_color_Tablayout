package com.example.tablayoutwithviewpagerandmenuitems;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;



public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    PageAdapter pageAdapter;
    TabItem tabChats;
    TabItem tabStatus;
    TabItem tabCalls;
    ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_title);
        //You need to add it so that the menu items will appear on Android Toolbar
        setSupportActionBar(toolbar);

        tabLayout = findViewById(R.id.tablayout);
        tabChats = findViewById(R.id.chatstab);
        tabStatus = findViewById(R.id.statustab);
        tabCalls = findViewById(R.id.callstab);

        viewPager = findViewById(R.id.viewPager);

        //define PageAdapter.
        //Here you pass 2 arguments: Android getSupportFragmentManager()
        // and the total number of tabs in Android Tablayout.
        pageAdapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        //Now you can use pageAdapter as the adapter for Android ViewPager.
        viewPager.setAdapter(pageAdapter);

        //ow you got the swipe function working, but the problem is Android
        // Tablayout indicator doesn’t change while you swipe to other tabs!
        //This line will fix it by attaching Android Tablayout with Viewpager,
        // so when you try to swipe it will sync with Tablayout tabs indicator.
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //In this section, you will learn how you can change Android Toolbar background
        // color every time you swipe left and right using Android ViewPager.
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition() == 1) {
                    //in order to change the color of the TOOLBAR
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorAccent));
                    //in order to change the color of the TAB_LAYOUT
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorAccent));
                    ////in order to change the color of the StatusBar (of the device)
                    getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                            R.color.color1));

                } else if (tab.getPosition() == 2) {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.color2));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.color2));

                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.color3));

                } else {
                    toolbar.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));
                    tabLayout.setBackgroundColor(ContextCompat.getColor(MainActivity.this,
                            R.color.colorPrimary));

                        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,
                                R.color.colorPrimaryDark));

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}
