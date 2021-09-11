package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.AssetManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static android.view.inputmethod.EditorInfo.*;


public class HomeActivity extends AppCompatActivity {
    private ArrayList<Integer> imageList;
    private static final int DP = 24; //수치가 높을수록 옆에 그림이 조금씩 더 많이보임
    private RecyclerView listview;
    private MyAdapter adapter;

    private FirebaseDatabase database = FirebaseDatabase.getInstance("https://nacho-da37d-default-rtdb.asia-southeast1.firebasedatabase.app");
    private DatabaseReference databaseReference = database.getReference("keyword");

    EditText keyword;
    Button add_bt;
    // meaningOut Keyword List
    private ArrayList<String> meaningOutKeywordList = new ArrayList<String>();

    // Realtime DB Event Listener
    private ChildEventListener mChild;

    // should parse to json
    private StoreManager storeManager;
    private String siteInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.initializeData();

        // first setting
        //dataSetting();
        //storeManager.init();
        //storeManager.getData();

        // initialize DB
        initDatabase();

        // load keyword data
        loadKeyword();
        init(meaningOutKeywordList);

        ViewPager viewPager = findViewById(R.id.viewPager);
        viewPager.setClipToPadding(false);

        keyword = findViewById(R.id.text71);
        add_bt = findViewById(R.id.insert_key);

        Button home, cate, prod, stor; // 상단 탑뷰
        Button aboutpf, aboutve; // 대표 키워드 두개
        Button hash_up, hash_ve, hash_ft, hash_do, hash_aw, hash_pf; // hashtag들

        home = findViewById(R.id.button_home);
        cate = findViewById(R.id.buttom_cate);
        prod = findViewById(R.id.button_prod);
        stor = findViewById(R.id.button_stor);
        aboutpf = findViewById(R.id.goto_pl);
        aboutve = findViewById(R.id.goto_ve);
        hash_up = findViewById(R.id.hash11);
        hash_ve = findViewById(R.id.hash21);
        hash_ft = findViewById(R.id.hash31);
        hash_do = findViewById(R.id.hash41);
        hash_aw = findViewById(R.id.hash51);
        hash_pf = findViewById(R.id.hash61);


        // 상단 탑뷰 클릭 시 이벤트
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, CategoryActivity.class);
                startActivity(intent);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProductActivity.class);
                startActivity(intent);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SiteActivity.class);
                startActivity(intent);
            }
        });

        //HashTag 키워드 클릭 시 이벤트
        hash_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutUpActivity.class);
                startActivity(intent);
            }
        });

        hash_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutVeActivity.class);
                startActivity(intent);
            }
        });

        hash_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutFtActivity.class);
                startActivity(intent);
            }
        });

        hash_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutDoActivity.class);
                startActivity(intent);
            }
        });

        hash_aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutAnActivity.class);
                startActivity(intent);
            }
        });

        hash_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutPfActivity.class);
                startActivity(intent);
            }
        });

        // 대표 키워드 두 개 : 플라스틱프리, 비건
        aboutpf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutPfActivity.class);
                startActivity(intent);
            }
        });

        aboutve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AboutVeActivity.class);
                startActivity(intent);
            }
        });

        // About 비건 페이지 이동
        aboutve.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(HomeActivity.this, AboutVeActivity.class);
                    startActivity(intent);
            }
        });

        float density = getResources().getDisplayMetrics().density;
        int margin = (int) (DP * density);
        viewPager.setPadding(margin, 0, margin, 0);
        viewPager.setPageMargin(margin/2);

        viewPager.setAdapter(new ViewPagerAdapter(this, imageList));
        //keyword.setImeOptions(IME_ACTION_GO);

        keyword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override public boolean onEditorAction(TextView v, int actionId, KeyEvent event)
            {
                switch (actionId) {
                    case IME_ACTION_GO:

                        insertKeyword();
                        init(meaningOutKeywordList); // 버튼 누르면 init()호출
                        hideKeyboard();
                        // 검색 동작
                        break;
                    default:
                        // 기본 엔터키 동작
                        return false;
                }
                return true;
            }
        });


        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertKeyword();
                init(meaningOutKeywordList); // 버튼 누르면 init()호출
                hideKeyboard();
            }



        });







    }




    private void init(ArrayList<String> itemList) {

        listview = findViewById(R.id.recycler1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        listview.setLayoutManager(layoutManager);

        adapter = new MyAdapter(this, itemList, onClickItem);
        listview.setAdapter(adapter);

        MyListDecoration decoration = new MyListDecoration();
        listview.addItemDecoration(decoration);
    }

    private View.OnClickListener onClickItem = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String str = (String) v.getTag();
            Toast.makeText(HomeActivity.this, str, Toast.LENGTH_SHORT).show();
        }
    };



    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(this);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        keyword.setText(null);

    }

    public void initializeData() //이미지를 저장함 배열에
    {
        imageList = new ArrayList();

        imageList.add(R.drawable.home_meaning);
        imageList.add(R.drawable.main_vegan);
        imageList.add(R.drawable.main_fairtrade);
        imageList.add(R.drawable.main_plasticfree);
        imageList.add(R.drawable.main_animal);
        imageList.add(R.drawable.main_donation);
        imageList.add(R.drawable.main_upcycling);
    }

    private void dataSetting(){
        siteInfo = getJsonString();
        storeManager = new StoreManager(siteInfo);
    }

    private void initDatabase() {
        mChild = new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Toast.makeText(HomeActivity.this, keyword.getText().toString() + "추가 완료", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };

        databaseReference.addChildEventListener(mChild);
    }


    private void loadKeyword() {
//        ArrayList<String> itemList = new ArrayList<>();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                meaningOutKeywordList.clear();
                for (DataSnapshot messageData : dataSnapshot.getChildren()) {
                    // 전체 데이터 load
                    meaningOutKeywordList.add("#" + messageData.getValue().toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        return itemList;
    }

    private void insertKeyword(){
        String word = keyword.getText().toString();
        databaseReference.child(word).setValue(word); // (key, value)
        meaningOutKeywordList.add("#" + word);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        databaseReference.removeEventListener(mChild);
    }

    private String getJsonString()
    {
        String json = "";
        try {
            InputStream is = getAssets().open("siteInfo.json");
            int fileSize = is.available();

            byte[] buffer = new byte[fileSize];
            is.read(buffer);
            is.close();

            json = new String(buffer, "UTF-8");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return json;
    }

}