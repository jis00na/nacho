package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AboutAnActivity extends AppCompatActivity{
    private TextView tv_count;
    private int counter;
    private Button hash_up, hash_ve, hash_ft, hash_do, hash_aw, hash_pf;
    private String score;

    private ApplicationState appState;

    @Override
    protected void onStop() {//5
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            appState.saveScoreToFirebase();
        }
        super.onStop();
    }

    @Override
    protected void onDestroy() {//6
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            appState.saveScoreToFirebase();
        }
        super.onDestroy();
    }

    private void clickCount(){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // User is signed in
            System.out.println(user.getEmail());
            appState.setScore(appState.getScore() + 1);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_animal);
        appState = (ApplicationState) getApplication();



        SharedPreferences prefs = getSharedPreferences("counter_alone", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        counter = prefs.getInt("counter", 0);



        tv_count = findViewById(R.id.tv_count);

        Button title_back, title_prof; // 상단 타이틀
        Button home, cate, prod, stor; // 상단 탑뷰
         // hashtag들

        title_back = findViewById(R.id.btn_Back);
        title_prof = findViewById(R.id.btn_Profile);
        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);
        hash_up = findViewById(R.id.hash1);
        hash_ve = findViewById(R.id.hash2);
        hash_ft = findViewById(R.id.hash3);
        hash_do = findViewById(R.id.hash4);
        hash_aw = findViewById(R.id.hash5);
        hash_pf = findViewById(R.id.hash6);

        // 상단 타이틀 버튼 클릭 시 이벤트
        title_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                onBackPressed();
                overridePendingTransition(0, 0);
            }
        });

        title_prof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    // User is signed in
                    System.out.println(user.getEmail());
                    appState.setScore(appState.getScore() + 1);
                    System.out.println(appState.getScore());
                    Intent intent = new Intent(AboutAnActivity.this, MypageActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }else{
                    // No user is signed in
                    Intent intent = new Intent(AboutAnActivity.this, AboutGoogleLogin.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }
            }
        });

        // 상단 탑뷰 클릭 시 이벤트
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, HomeActivity.class);
                int score1 =  Integer.valueOf(score);
                System.out.println("score1"+score1);
                intent.putExtra("counter",score1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        //HashTag 키워드 클릭 시 이벤트
        hash_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutUpActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        hash_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutVeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        hash_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutFtActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        hash_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutDoActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        hash_aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutAnActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        hash_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, AboutPfActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        Button ansite;
        ansite = findViewById(R.id.button_site);
        ansite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(AboutAnActivity.this, SiteActivity.class);
                intent.putExtra("froman","froman");
                startActivity(intent);
            }
        });
    }

}
