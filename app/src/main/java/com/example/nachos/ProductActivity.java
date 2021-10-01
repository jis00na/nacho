package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

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

        Button title_back, title_prof; // 상단 타이틀
        Button home, cate, prod, stor; // 상단 탑뷰

        title_back = findViewById(R.id.btn_Back);
        title_prof = findViewById(R.id.btn_Profile);
        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);

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
