package com.footballmania.ui.favourites;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.footballmania.R;
import com.google.android.material.tabs.TabLayout;

public class FavouritesFragment extends Fragment {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_favourites, container, false);

        tabLayout = root.findViewById(R.id.favouritesTabLayout);
        viewPager = root.findViewById(R.id.favouritesViewPager);

        FavouritesViewPagerAdapter favouritesViewPagerAdapter = new FavouritesViewPagerAdapter(getChildFragmentManager());

        tabLayout.setupWithViewPager(viewPager);

        viewPager.setAdapter(favouritesViewPagerAdapter);

        return root;
    }
 
    private class FavouritesViewPagerAdapter extends FragmentPagerAdapter{

        private String[] tabTitles = new String[]{"Teams", "Competitions"};
        private Fragment[] fragments = new Fragment[]{new FavouriteTeamsFragment(), new FavouriteCompetitionsFragment()};

        public FavouritesViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position){
            return tabTitles[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

}