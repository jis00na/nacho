package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Button;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity{
    private int counter_cate;
    private String score_cate;
    private int score_cate1;

    @Override
    protected void onStop() {//5
        //Toast.makeText(getApplicationContext(),"onStop 호출됨",Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {//6
        //Toast.makeText(getApplicationContext(),"onDestroy 호출됨",Toast.LENGTH_SHORT).show();
        savescore();
        super.onDestroy();
    }

    @Override
    protected void onPause() {//4
        //Toast.makeText(getApplicationContext(),"onPause 호출됨",Toast.LENGTH_SHORT).show();
        savescore(); //앱이 도중에 잘못되어도 저장됨
        super.onPause();
    }

    //데이터 저장
//SharedPreferences는 해당 프로세스(어플리케이션)내에 File 형태로 Data를 저장해
//해당 어플리케이션이 삭제되기 전까지 Data를 보관해 주는 기능
//SharedPreferences 사용한 어플리케이션을 지우면 내용이 모두 삭제 됩니다. File이 삭제되는 것이지요.
    private void savescore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE); //"gostop"은 SharedPreferences 이름. 여러개가 있을 수 있음
        SharedPreferences.Editor edit = pref.edit(); //만들어서 저장
        edit.putString("score_cate", String.valueOf(counter_cate)); //종료해도 저장됨
        edit.commit(); //저장은 필수
    }

    @Override
    protected void onResume() {//3
        //Toast.makeText(getApplicationContext(),"onResume 호출됨",Toast.LENGTH_SHORT).show();
        loadscore();
        super.onResume();
    }

    //데이터 호출
    private void loadscore(){
        SharedPreferences pref = getSharedPreferences("gostop", Activity.MODE_PRIVATE); //불러올때 설정한 이름을 불러와야해
        score_cate = pref.getString("score_cate","0"); //값이 없을 때 0을 기본값으로 넣겠다.(기본값)
        Toast.makeText(getApplicationContext(),"점수 : "+score_cate ,Toast.LENGTH_SHORT).show();
        //tv_count.setText(String.valueOf(score) +"도");
        System.out.println(score_cate+"");
        savescore();
    }

    @Override
    protected void onStart() {//2
        //Toast.makeText(getApplicationContext(),"onStart 호출됨",Toast.LENGTH_SHORT).show();
        savescore();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        SharedPreferences prefs = getSharedPreferences("counter_alone", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        counter_cate = prefs.getInt("counter_cate", 0);

        Button title_back, title_prof; // 상단 타이틀
        Button home, cate, prod, stor; // 상단 탑뷰

        title_back = findViewById(R.id.btn_Back);
        title_prof = findViewById(R.id.btn_Profile);
        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);

        //카테고리 연결
        ImageButton can, cdo, cft, cpf, cup, cve;
        can = findViewById(R.id.cate_ani);
        cdo = findViewById(R.id.cate_do);
        cft = findViewById(R.id.cate_ft);
        cpf = findViewById(R.id.cate_pf);
        cup = findViewById(R.id.cate_up);
        cve = findViewById(R.id.cate_ve);

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutAnActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        cdo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutDoActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        cft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutFtActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        cpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutPfActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        cve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutVeActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutAnActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
        cup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter_cate++;
                editor.putInt("counter_cate", counter_cate);
                editor.apply();

                Intent intent = new Intent(CategoryActivity.this, AboutUpActivity.class);
                score_cate1 =  Integer.valueOf(score_cate);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
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
                Toast.makeText(getApplicationContext(), "프로필", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CategoryActivity.this, CountActivity.class);
                score_cate1 =  Integer.valueOf(score_cate1);
                System.out.println("score_cate1"+score_cate1);
                intent.putExtra("counter_cate",score_cate1);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        // 상단 탑뷰 클릭 시 이벤트
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CategoryActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }
}