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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity{

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
        setContentView(R.layout.activity_product);
        appState = (ApplicationState) getApplication();

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

        String baseUrl = "gs://nacho-da37d.appspot.com/";

        ArrayList<Product> items = new ArrayList<Product>();
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference gsReference = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef());

//        adapter.addItem(new Product(
//                appState.getMeaningOutInfo().get("윙블링").getName(),
//                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getName(),
//                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getIntroduction(),
//                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef(),
//                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getProductUrl(),
//                gsReference));

        items.add(new Product(
                appState.getMeaningOutInfo().get("윙블링").getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getProductUrl(),
                gsReference));

        items.add(new Product(
                appState.getMeaningOutInfo().get("윙블링").getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getProductUrl(),
                gsReference));

        items.add(new Product(
                appState.getMeaningOutInfo().get("윙블링").getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getProductUrl(),
                gsReference));

        items.add(new Product(
                appState.getMeaningOutInfo().get("윙블링").getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("윙블링").getProducts().get(0).getProductUrl(),
                gsReference));



        recyclerView_up.setAdapter(adapter);
        adapter.setItems(items);
        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter.getItem(position);
                //Toast.makeText(getApplicationContext(), "이름 : " + item.getName() + "\n 가격 : " + item.getCost() +"\n 설명 : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });


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
                    Intent intent = new Intent(ProductActivity.this, MypageActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }else{
                    // No user is signed in
                    Intent intent = new Intent(ProductActivity.this, AboutGoogleLogin.class);
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
                Intent intent = new Intent(ProductActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(ProductActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(ProductActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(ProductActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

}
