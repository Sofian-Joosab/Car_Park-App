package com.example.rock_boy69.car_parking;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Rock_boy69 on 08-Nov-17.
 */

class SectionPagerAdapter extends FragmentPagerAdapter {
    public SectionPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 1:
                RequestFragment requestFragment = new RequestFragment();
                return requestFragment;

            case 2:
                FriendsFragment friendsFragment = new FriendsFragment();
                return  friendsFragment;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){

        switch (position){
            case 0:
                return "CARROS";

            case 1:
                return "REGISTRAR";

            case 2:
                return "HISTORICO";

            default:
                return null;
        }
    }
}
