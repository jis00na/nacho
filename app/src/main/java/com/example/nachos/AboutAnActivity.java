package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;

public class AboutAnActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_animal);

        Button hash_up, hash_ve, hash_ft, hash_do, hash_aw, hash_pf; // hashtag들
        hash_up = findViewById(R.id.hash1);
        hash_ve = findViewById(R.id.hash2);
        hash_ft = findViewById(R.id.hash3);
        hash_do = findViewById(R.id.hash4);
        hash_aw = findViewById(R.id.hash5);
        hash_pf = findViewById(R.id.hash6);

        //HashTag 키워드 클릭 시 이벤트
        hash_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutUpActivity.class);
                startActivity(intent);
            }
        });

        hash_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutVeActivity.class);
                startActivity(intent);
            }
        });

        hash_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutFtActivity.class);
                startActivity(intent);
            }
        });

        hash_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutDoActivity.class);
                startActivity(intent);
            }
        });

        hash_aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutAnActivity.class);
                startActivity(intent);
            }
        });

        hash_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, AboutPfActivity.class);
                startActivity(intent);
            }
        });

        Button ansite;
        ansite = findViewById(R.id.button_site);
        ansite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AboutAnActivity.this, SiteActivity.class);
                intent.putExtra("froman","froman");
                startActivity(intent);
            }
        });


    }

}
