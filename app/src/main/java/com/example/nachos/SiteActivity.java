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

import com.bumptech.glide.Glide;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SiteActivity extends AppCompatActivity {

    private ApplicationState appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);

        Intent intent_ve = getIntent();
        Intent intent_an = getIntent();
        Intent intent_do = getIntent();
        Intent intent_ft = getIntent();
        Intent intent_pf = getIntent();
        Intent intent_up = getIntent();

        String fromvegan = "";
        String froman = "";
        String fromdo = "";
        String fromft = "";
        String frompf = "";
        String fromup = "";


        fromvegan = intent_ve.getStringExtra("fromvegan");
        froman = intent_an.getStringExtra("froman");
        fromdo = intent_do.getStringExtra("fromdo");
        fromft = intent_ft.getStringExtra("fromft");
        frompf = intent_pf.getStringExtra("frompf");
        fromup = intent_up.getStringExtra("fromup");


        System.out.println("titleve"+R.id.title_ve);
        System.out.println("text7"+R.id.text7);

        ScrollView sv = (ScrollView) findViewById(R.id.scrollsite);


        LinearLayout text_ve;
        text_ve = (LinearLayout) findViewById(R.id.title_ve);


        /*
        int getve = (int) text_ve.getTop();
        int linve = (int) title_ve.getBottom();
        System.out.println("textve gettop: "+ getve);
        System.out.println("linve gettop: "+ linve);

        int[] loc = new int[2];
        int[] loc1 = new int[2];


        text_ve.getLocationInWindow(loc);
        System.out.println("loc in window : " + loc[0] + ", " + loc[1]);

        text_ve.getLocationOnScreen(loc1);
        System.out.println("loc on screen : " + loc1[0] + ", " + loc1[1]);

        int left = text_ve.getLeft();
        int top = text_ve.getTop();
        int right = text_ve.getRight();
        int bottom = text_ve.getBottom();
        System.out.println( "btn left : " + left + ", right : " + right + ", top : " + top + ", bottom : " + bottom);

*/

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /*
                int[] loc = new int[2];
                int[] loc1 = new int[2];

                text_ve.getLocationInWindow(loc);
                System.out.println("loc in window : " + loc[0] + ", " + loc[1]);
                text_ve.getLocationOnScreen(loc1);
                System.out.println("loc on screen : " + loc1[0] + ", " + loc1[1]);
                */

                int top = text_ve.getTop();
                System.out.println(  ", top : " + top );
            }

        }, 50);

        if (fromvegan != null){
            if (fromvegan.equals("fromvegan")){
                System.out.println("vegan!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,1579);
                    }
                }, 50);
            }
        }
        else if (froman != null){
            if (froman.equals("froman")){
                System.out.println("an!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,R.id.SiteList_ve);
                    }
                }, 50);
            }
        }
        else if (fromdo != null){
            if (fromdo.equals("fromdo")){
                System.out.println("do!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,R.id.SiteList_ve);
                    }
                }, 50);
            }
        }
        else if (fromft != null){
            if (fromft.equals("fromft")){
                System.out.println("ft!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,R.id.SiteList_ve);
                    }
                }, 50);
            }
        }
        else if (frompf != null){
            if (frompf.equals("frompf")){
                System.out.println("pf!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,R.id.SiteList_ve);
                    }
                }, 50);
            }
        }
        else if (fromup != null){
            if (fromup.equals("fromup")){
                System.out.println("up!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,R.id.SiteList_ve);
                    }
                }, 50);
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

        // 제품 추가
        appState = (ApplicationState) getApplication();

        SiteAdapter adapter = new SiteAdapter();
        adapter.addItem(new SiteItem("프라이탁", "업사이클링", R.drawable.back_animal));

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
