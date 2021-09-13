package com.example.nachos;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    TabLayout tablayout;
    LinearLayout home_page, cate_page, prod_page, stor_page;
    Context context;

    Adapter adapter;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.view);
        adapter = new Adapter(this);
        //viewPager.setAdapter(adapter);

        tablayout = findViewById(R.id.tablayout);
        tablayout.addOnTabSelectedListener(onTabSelectedListener);

        home_page = findViewById(R.id.tab_home);
        cate_page = findViewById(R.id.tab_cate);
        prod_page = findViewById(R.id.tab_prod);
        stor_page = findViewById(R.id.tab_stor);


        context = this;
    }

    TabLayout.OnTabSelectedListener onTabSelectedListener = new TabLayout.OnTabSelectedListener() {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            int pos = tab.getPosition();
            changeView(pos);
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {
        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {
        }
    };

    private void changeView(int index) {
        switch (index) {
            case 0:
                home_page.setVisibility(View.VISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 1:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.VISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 2:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.VISIBLE);
                stor_page.setVisibility(View.INVISIBLE);
                break;
            case 3:
                home_page.setVisibility(View.INVISIBLE);
                cate_page.setVisibility(View.INVISIBLE);
                prod_page.setVisibility(View.INVISIBLE);
                stor_page.setVisibility(View.VISIBLE);
                break;

        }

    }
}