package com.example.tablayoutwithviewpagerandmenuitems;

/**
 * To be able to have the swipe left and right with finger gesture function,
 * you will need to create this Java file (PageAdapter) which you will use it together with Android ViewPager.
 *
 * Note: Android FragmentPagerAdapter is used when you have a limited number of tabs that want to swipe through.
 * If you have a dynamic tabs then you need to use Android FragmentStatePagerAdapter.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PageAdapter extends FragmentPagerAdapter {

    // numOfTabs variable hold the size of Android Tablayout tabs
    // and update the constructor to include that variable.
    private int numOfTabs;

    // we will use this PageAdapter constructor on the mailActivity- passing the number of tabs from the FM
    //the PageAdapter constructor is use to communicate between this class and MainActivity.java.
    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs= numOfTabs;
    }

    //getItem is where you will initialize the fragments for Android Tablayout.
    // In this Android Tablayout example you will have 3 Android Fragments (Chat, Status and Calls)
    @Override
    public Fragment getItem(int position) {
        //Now you need to define Android fragments inside getItem.

        switch (position){
            case 0:
                return new ChatFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallFragment();
            default:
                return null;
        }


    }

    //getCount Will return the number of tabs that will appear in Android Tablayout
    @Override
    public int getCount() {
        return numOfTabs;
    }
}
