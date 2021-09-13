package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.DriverManager.println;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        Intent intent_ve = getIntent();
        String fromvegan = "";
        fromvegan = intent_ve.getStringExtra("fromvegan");
        System.out.println("titleve"+R.id.title_ve);
        System.out.println("text7"+R.id.text7);

        ScrollView sv_ve = (ScrollView) findViewById(R.id.scrollsite);
        TextView text_ve = (TextView) findViewById(R.id.text7);
        LinearLayout title_ve = (LinearLayout) findViewById(R.id.title_ve);

        int getve = (int) text_ve.getY();
        int linve = (int) title_ve.getY();

        if (fromvegan != null){
            if (fromvegan.equals("fromvegan")){
                System.out.println("Y:"+linve);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv_ve.smoothScrollTo(0, 100);
                    }
                }, 200);


            }
        }


        Button title_back, title_prof; // 상단 타이틀
        Button home, cate, prod, stor; // 상단 탑뷰
        title_back = findViewById(R.id.btn_Back);
        title_prof = findViewById(R.id.btn_Profile);
        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);

        ListView listView = findViewById(R.id.SiteList1);
        ListView listView2 = findViewById(R.id.SiteList2);
        ListView listView_ani = findViewById(R.id.SiteList_ani);
        ListView listView_do = findViewById(R.id.SiteList_do);
        ListView listView_fair = findViewById(R.id.SiteList_fair);
        ListView listView_pla = findViewById(R.id.SiteList_pla);
        ListView listView_up = findViewById(R.id.SiteList_up);
        ListView listView_ve = findViewById(R.id.SiteList_ve);

        SiteAdapter adapter = new SiteAdapter();
        adapter.addItem(new SiteItem("프라이탁", "업사이클링",R.drawable.back_animal));
        listView.setAdapter(adapter);
        listView2.setAdapter(adapter);
        listView_ani.setAdapter(adapter);
        listView_do.setAdapter(adapter);
        listView_fair.setAdapter(adapter);
        listView_pla.setAdapter(adapter);
        listView_up.setAdapter(adapter);
        listView_ve.setAdapter(adapter);

        // 상단 타이틀 버튼 클릭 시 이벤트
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                overridePendingTransition(0, 0);
            }
        });

        title_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "프로필", Toast.LENGTH_SHORT).show();
            }
        });

        // 상단 탑뷰 클릭 시 이벤트
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiteActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiteActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiteActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SiteActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });


    }

    class SiteAdapter extends BaseAdapter {
        //데이터가 들어가있지 않고, 어떻게 담을지만 정의해뒀다.
        ArrayList<SiteItem> items = new ArrayList<SiteItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SiteItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        // 어댑터가 데이터를 관리하고 뷰도 만듬
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SiteItemView siteItemView = null;
            // 코드를 재사용할 수 있도록
            if(convertView == null) {
                siteItemView = new SiteItemView(getApplicationContext());
            } else {
                siteItemView = (SiteItemView)convertView;
            }
            SiteItem item = items.get(position);
            siteItemView.setSite(item.getSite());
            siteItemView.setCategory(item.getCategory());
            siteItemView.setImage(item.getResId());
            siteItemView.setButton(item.getGotosite());
            return siteItemView;
        }
    }
}