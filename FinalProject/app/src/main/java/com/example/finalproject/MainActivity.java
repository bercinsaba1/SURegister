package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    TabLayout tabLayout;
    //  ClassPageAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //X getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //X getSupportActionBar().setHomeAsUpIndicator(R.mipmap.news_launcher_small);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        ClassPageAdapter pageAdapter = new ClassPageAdapter(getSupportFragmentManager(),getLifecycle());
        viewPager.setAdapter(pageAdapter);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch(position){
                        case 0:
                            tab.setText("CS");
                            break;
                        case 1:
                            tab.setText("ENS");
                            break;
                        case 2:
                            tab.setText("MATH");
                            break;
                        case 3:
                            tab.setText("MGMT");
                            break;
                        case 4:
                            tab.setText("PSY");
                            break;
                    }
                }
        ).attach();
    }    // end of oncreate function

    class ClassPageAdapter extends FragmentStateAdapter {

        public ClassPageAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
           Fragment fragment = new ClassListFragment(String.valueOf(position+1),((SU_Register_Application)getApplication()).srv);

            return fragment;
        }

        @Override
        public int getItemCount() {
            return 5;
        }
    }


}// end of class

