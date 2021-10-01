package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        RecyclerView recyclerView_up = findViewById(R.id.recyclerView_up);
        RecyclerView recyclerView_ve = findViewById(R.id.recyclerView_ve);
        RecyclerView recyclerView_ft = findViewById(R.id.recyclerView_ft);
        RecyclerView recyclerView_do = findViewById(R.id.recyclerView_do);
        RecyclerView recyclerView_pl = findViewById(R.id.recyclerView_pl);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView_up.setLayoutManager(layoutManager);
        //recyclerView_ve.setLayoutManager(layoutManager);
        //recyclerView_ft.setLayoutManager(layoutManager);
//        recyclerView_do.setLayoutManager(layoutManager);
//        recyclerView_pl.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        Button title_back, title_prof; // 상단 타이틀
        Button home, cate, prod, stor; // 상단 탑뷰

        title_back = findViewById(R.id.btn_Back);
        title_prof = findViewById(R.id.btn_Profile);
        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);

        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));
        adapter.addItem(new Product("사이트", "친환경주방선물세트" , "우리 가족과 지구의 건강을 주방에 선물", R.drawable.aboutve));

        recyclerView_up.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                Product item = adapter.getItem(position);
                //Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +"\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });


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
                Intent intent = new Intent(ProductActivity.this, AboutGoogleLogin.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        // 상단 탑뷰 클릭 시 이벤트
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }


}
