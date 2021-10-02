package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.Arrays;

public class AboutAnActivity extends AppCompatActivity{
    private TextView tv_count;
    private int counter;
    private Button hash_up, hash_ve, hash_ft, hash_do, hash_aw, hash_pf;
    private String score;

    private ArrayList<String> siteList = new ArrayList<>(Arrays.asList("굿백", "녹색장터", "더클레어", "마이아일랜드", "모레상점", "슈가버블", "아렌시아", "자연상점", "톤28", "헬로네이처"));

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

//        RecyclerView recyclerView_up = findViewById(R.id.recyclerView_about_do);
//
//        String baseUrl = "gs://nacho-da37d.appspot.com/";
//
//        ArrayList<Product> items = new ArrayList<Product>();
//        FirebaseStorage storage = FirebaseStorage.getInstance();
//
//
//        recyclerView_up.setAdapter(adapter);
//        adapter.setItems(items);
//
//        adapter.setOnItemClickListener(new OnProductItemClickListener() {
//            @Override
//            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
//                clickCount();
//                Product item = adapter.getItem(position);
//                //Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +"\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
//            }
//        });

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
