package org.androidtown.sampletabreal;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> Items;
    private ArrayList<String> Itext = new ArrayList<String>();
    public VPAdapter(FragmentManager fm){
        super(fm);
        Items = new ArrayList<Fragment>();
        Items.add(new Fragment1());
        Items.add(new Fragment2());
        Items.add(new Fragment3());

        Itext.add("1번 탭");
        Itext.add("2번 탭");
        Itext.add("3번 탭");
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position){
        return Itext.get(position);
    }


    @Override
    public Fragment getItem(int position){
        return Items.get(position);
    }

    @Override
    public int getCount(){
        return Items.size();
    }
}
