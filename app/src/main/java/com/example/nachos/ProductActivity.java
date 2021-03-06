package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ProductActivity extends AppCompatActivity{

    private ApplicationState appState;
    private int top_ve, top_up, top_ft, top_do, top_ani, top_pf;
    private Button hash_up, hash_ve, hash_ft, hash_do, hash_aw, hash_pf;

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

        RecyclerView recyclerView_up = findViewById(R.id.recyclerView_up);
        RecyclerView recyclerView_ve = findViewById(R.id.recyclerView_ve);
        RecyclerView recyclerView_ft = findViewById(R.id.recyclerView_ft);
        RecyclerView recyclerView_do = findViewById(R.id.recyclerView_do);
        RecyclerView recyclerView_pl = findViewById(R.id.recyclerView_pl);
        RecyclerView recyclerView_fr = findViewById(R.id.recyclerView_fr); //????????? ??? ????????????

        //up
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerView_up.setLayoutManager(layoutManager);

        //recyclerView_ve.setLayoutManager(layoutManager);
        //recyclerView_ft.setLayoutManager(layoutManager);
//        recyclerView_do.setLayoutManager(layoutManager);
//        recyclerView_pl.setLayoutManager(layoutManager);
        final ProductAdapter adapter = new ProductAdapter();

        //ve
        GridLayoutManager layoutManager_ve = new GridLayoutManager(this,2);
        recyclerView_ve.setLayoutManager(layoutManager_ve);
        final ProductAdapter adapter_ve = new ProductAdapter();

        //ft
        GridLayoutManager layoutManager_ft = new GridLayoutManager(this,2);
        recyclerView_ft.setLayoutManager(layoutManager_ft);
        final ProductAdapter adapter_ft = new ProductAdapter();

        //do
        GridLayoutManager layoutManager_do = new GridLayoutManager(this,2);
        recyclerView_do.setLayoutManager(layoutManager_do);
        final ProductAdapter adapter_do = new ProductAdapter();

        //pl
        GridLayoutManager layoutManager_pl = new GridLayoutManager(this,2);
        recyclerView_pl.setLayoutManager(layoutManager_pl);
        final ProductAdapter adapter_pl = new ProductAdapter();

        //fr
        GridLayoutManager layoutManager_fr = new GridLayoutManager(this,2);
        recyclerView_fr.setLayoutManager(layoutManager_fr);
        final ProductAdapter adapter_fr = new ProductAdapter();


        ScrollView sv = (ScrollView) findViewById(R.id.scrollsite);

        LinearLayout text_ve;
        text_ve = (LinearLayout) findViewById(R.id.title_ve);
        LinearLayout text_up = findViewById(R.id.title_up);
        LinearLayout text_ani = findViewById(R.id.title_ani);
        LinearLayout text_do = findViewById(R.id.title_do);
        LinearLayout text_ft = findViewById(R.id.title_fair);
        LinearLayout text_pf = findViewById(R.id.title_pla);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                top_ve = text_ve.getTop();
                top_up = text_up.getTop();
                top_ani = text_ani.getTop();
                top_do = text_do.getTop();
                top_ft = text_ft.getTop();
                top_pf = text_pf.getTop();
                System.out.println(  ", top : " + top_ve );

            }

        }, 50);

        if (fromvegan != null){
            if (fromvegan.equals("fromvegan")){
                System.out.println("vegan!!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_ve);
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
                        sv.scrollTo(0,top_ani);
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
                        sv.scrollTo(0,top_do);
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
                        sv.scrollTo(0,top_ft);
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
                        sv.scrollTo(0,top_pf);
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
                        sv.scrollTo(0,top_up);
                    }
                }, 50);
            }
        }

        Button title_back, title_prof; // ?????? ?????????
        Button home, cate, prod, stor; // ?????? ??????

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


        String baseUrl = "gs://nacho-da37d.appspot.com/";


        //up
        ArrayList<Product> items = new ArrayList<Product>();
        FirebaseStorage storage = FirebaseStorage.getInstance();


        //119?????? ???
        StorageReference gsReference_119 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("119??????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("119??????").getName(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(0).getProductUrl(),
                gsReference_119));

        StorageReference gsReference_1191 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("119??????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("119??????").getName(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("119??????").getProducts().get(1).getProductUrl(),
                gsReference_1191));

        //?????? ???
        StorageReference gsReference_nukak = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_nukak));

        StorageReference gsReference_nukak1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_nukak1));


        //???????????? ???
        StorageReference gsReference_merry = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_merry));

        StorageReference gsReference_merry1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_merry1));

        //?????????????????? ???
        StorageReference gsReference_milky = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_milky));

        StorageReference gsReference_milky1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_milky1));

        //?????? ???
        StorageReference gsReference_ulkin = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_ulkin));

        StorageReference gsReference_ulkin1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_ulkin1));

        //????????????????????? ???
        StorageReference gsReference_ecoparty = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????????????????").getName(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(0).getProductUrl(),
                gsReference_ecoparty));

        StorageReference gsReference_ecoparty1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????????????????").getName(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????????????????").getProducts().get(1).getProductUrl(),
                gsReference_ecoparty1));

        //????????? ???
        StorageReference gsReference_overlab = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_overlab));

        StorageReference gsReference_overlab1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_overlab1));

        //????????? ???
        StorageReference gsReference_ownu = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_ownu));

        StorageReference gsReference_ownu1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_ownu1));

        //??????????????? ???
        StorageReference gsReference_cut = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_cut));

        StorageReference gsReference_cut1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_cut1));


        //???????????? ???
        StorageReference gsReference_cueclyp = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_cueclyp));

        StorageReference gsReference_cueclyp1 = storage.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_cueclyp1));



        //ve
        ArrayList<Product> items_ve = new ArrayList<Product>();
        FirebaseStorage storage_ve = FirebaseStorage.getInstance();

        //????????? ???
        StorageReference gsReference_lovinghut = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_lovinghut));

        StorageReference gsReference_lovinghut1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_lovinghut1));

        //????????? ???
        StorageReference gsReference_melix = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_melix));

        StorageReference gsReference_melix1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_melix1));

        //????????? ???
        StorageReference gsReference_vegemom = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_vegemom));

        StorageReference gsReference_vegemom1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_vegemom1));

        //???????????? ???
        StorageReference gsReference_vegefood = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_vegefood));

        StorageReference gsReference_vegefood1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_vegefood1));

        //???????????? ???
        StorageReference gsReference_bonajour = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_bonajour));

        StorageReference gsReference_bonajour1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_bonajour1));

        //?????????????????? ???
        StorageReference gsReference_veganspace = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_veganspace));

        StorageReference gsReference_veganspace1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_veganspace1));

        //???????????? ???
        StorageReference gsReference_veganfood = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_veganfood));

        StorageReference gsReference_veganfood1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_veganfood1));

        //???????????? ???
        StorageReference gsReference_jinsun = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_jinsun));

        StorageReference gsReference_jinsun1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_jinsun1));

        //???????????? ???
        StorageReference gsReference_chaesik = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_chaesik));

        StorageReference gsReference_chaesik1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_chaesik1));


        //??????????????? ???
        StorageReference gsReference_hanggi = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_hanggi));

        StorageReference gsReference_hanggi1 = storage_ve.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_ve.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_hanggi1));


        //ft
        ArrayList<Product> items_ft = new ArrayList<Product>();
        FirebaseStorage storage_ft = FirebaseStorage.getInstance();

//        //AFN ???
//        StorageReference gsReference_AFN = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("AFN").getProducts().get(0).getStorageRef());
//        items_ft.add(new Product(
//                appState.getMeaningOutInfo().get("AFN").getName(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(0).getName(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(0).getIntroduction(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(0).getStorageRef(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(0).getProductUrl(),
//                gsReference_AFN));
//
//        //AFN ???
//        StorageReference gsReference_AFN1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("AFN").getProducts().get(1).getStorageRef());
//        items_ft.add(new Product(
//                appState.getMeaningOutInfo().get("AFN").getName(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(1).getName(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(1).getIntroduction(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(1).getStorageRef(),
//                appState.getMeaningOutInfo().get("AFN").getProducts().get(1).getProductUrl(),
//                gsReference_AFN1));

        //FairTradeKorea ???
        StorageReference gsReference_FairTradeKorea = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("FairTradeKorea").getName(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(0).getProductUrl(),
                gsReference_FairTradeKorea));

        StorageReference gsReference_FairTradeKorea1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("FairTradeKorea").getName(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getProducts().get(1).getProductUrl(),
                gsReference_FairTradeKorea1));

        //fynbo ???
        StorageReference gsReference_fynbo = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("fynbo").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("fynbo").getName(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(0).getProductUrl(),
                gsReference_fynbo));

        StorageReference gsReference_fynbo1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("fynbo").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("fynbo").getName(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("fynbo").getProducts().get(1).getProductUrl(),
                gsReference_fynbo1));


        //?????? ???
        StorageReference gsReference_gonggi = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_gonggi));

        StorageReference gsReference_gonggi1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_gonggi1));

        //?????????????????? ???
        StorageReference gsReference_beautiful = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_beautiful));

        StorageReference gsReference_beautiful1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_beautiful1));


        //????????? ???
        StorageReference gsReference_earthman = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_earthman));

        StorageReference gsReference_earthman1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_earthman1));

        //????????? ???
        StorageReference gsReference_ecomont = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_ecomont));

        StorageReference gsReference_ecomont1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_ecomont1));

        //????????? ???
        StorageReference gsReference_oxfam = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_oxfam));

        StorageReference gsReference_oxfam1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_oxfam1));

        //?????? ???
        StorageReference gsReference_ullim = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_ullim));

        StorageReference gsReference_ullim1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_ullim1));

        //????????? ???
        StorageReference gsReference_tripti = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_tripti));

        StorageReference gsReference_tripti1 = storage_ft.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_ft.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_tripti1));


        //do
        ArrayList<Product> items_do = new ArrayList<Product>();
        FirebaseStorage storage_do = FirebaseStorage.getInstance();

        //4OCEAN ???
        StorageReference gsReference_4OCEAN = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("4OCEAN").getName(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(0).getProductUrl(),
                gsReference_4OCEAN));

        StorageReference gsReference_4OCEAN1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("4OCEAN").getName(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("4OCEAN").getProducts().get(1).getProductUrl(),
                gsReference_4OCEAN1));


        //????????? ???
        StorageReference gsReference_nokcha = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_nokcha));

        StorageReference gsReference_nokcha1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_nokcha1));

        //?????????????????? ???
        StorageReference gsReference_daily = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_daily));

        StorageReference gsReference_daily1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_daily1));

        //??????????????? ???
        StorageReference gsReference_meridiani = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_meridiani));

        StorageReference gsReference_meridiani1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_meridiani1));

//        //???????????? ???
//        StorageReference gsReference_more = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
//        items_do.add(new Product(
//                appState.getMeaningOutInfo().get("????????????").getName(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
//                gsReference_more));
//
//        StorageReference gsReference_more1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
//        items_do.add(new Product(
//                appState.getMeaningOutInfo().get("????????????").getName(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
//                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
//                gsReference_more1));


        //?????? ???
        StorageReference gsReference_bcoe = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_bcoe));

        StorageReference gsReference_bcoe1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_bcoe1));

        //?????????????????? ???
        StorageReference gsReference_bfirend = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_bfirend));

        StorageReference gsReference_bfirend1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_bfirend1));

        //?????????????????? ???
        StorageReference gsReference_atelierlykke = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_atelierlykke));

        StorageReference gsReference_atelierlykke1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_atelierlykke1));

        //????????? ???
        StorageReference gsReference_wingbling = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_wingbling));

        StorageReference gsReference_wingbling1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_wingbling1));

        //????????? ???
        StorageReference gsReference_tingklu = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_tingklu));

        StorageReference gsReference_tingklu1 = storage_do.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_do.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_tingklu1));

        //pl
        ArrayList<Product> items_pl = new ArrayList<Product>();
        FirebaseStorage storage_pl = FirebaseStorage.getInstance();

        //??????????????? ???
        StorageReference gsReference_naturaltips = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_naturaltips));

        StorageReference gsReference_naturaltips1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_naturaltips1));

        //????????? ???
        StorageReference gsReference_thepicker = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_thepicker));

        StorageReference gsReference_thepicker1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_thepicker1));

        //????????? ???
        StorageReference gsReference_thehumble = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_thehumble));

        StorageReference gsReference_thehumble1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_thehumble1));

        //????????? ???
        StorageReference gsReference_thanksto = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_thanksto));

        StorageReference gsReference_thanksto1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_thanksto1));

        //????????? ???
        StorageReference gsReference_lunacup = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(0).getProductUrl(),
                gsReference_lunacup));

        StorageReference gsReference_lunacup1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("?????????").getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("?????????").getProducts().get(1).getProductUrl(),
                gsReference_lunacup1));

        //??????????????? ???
        StorageReference gsReference_savvy = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_savvy));

        StorageReference gsReference_savvy1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_savvy1));

        //??????????????? ??? aroma
        StorageReference gsReference_aroma = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_aroma));

        StorageReference gsReference_aroma1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_aroma1));

        //?????????????????? ??? iamgreen
        StorageReference gsReference_iamgreen = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_iamgreen));

        StorageReference gsReference_iamgreen1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_iamgreen1));

        //?????? ??? oren
        StorageReference gsReference_oren = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_oren));

        StorageReference gsReference_oren1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_oren1));


        //?????????????????? ??? plasticzero
        StorageReference gsReference_plasticzero = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_plasticzero));

        StorageReference gsReference_plasticzero1 = storage_pl.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_pl.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_plasticzero1));

        //fr ????????? ??? ????????????
        ArrayList<Product> items_fr = new ArrayList<Product>();
        FirebaseStorage storage_fr = FirebaseStorage.getInstance();

        //?????? ??? goodbag
        StorageReference gsReference_goodbag = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(0).getProductUrl(),
                gsReference_goodbag));

        StorageReference gsReference_goodbag1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("??????").getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????").getProducts().get(1).getProductUrl(),
                gsReference_goodbag1));


        //???????????? ??? greenproduct
        StorageReference gsReference_greenproduct = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_greenproduct));

        StorageReference gsReference_greenproduct1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_greenproduct1));

        //???????????? ??? theklair
        StorageReference gsReference_theklair = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_theklair));

        StorageReference gsReference_theklair1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_theklair1));

        //?????????????????? ??? myisland
        StorageReference gsReference_myisland = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(0).getProductUrl(),
                gsReference_myisland));

        StorageReference gsReference_myisland1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("??????????????????").getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("??????????????????").getProducts().get(1).getProductUrl(),
                gsReference_myisland1));

        //???????????? ??? more
        StorageReference gsReference_more= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_more));

        StorageReference gsReference_more1= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_more1));

        //???????????? ??? sugarbubble
        StorageReference gsReference_sugarbubble= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_sugarbubble));

        StorageReference gsReference_sugarbubble1= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_sugarbubble1));

        //???????????? ??? arencia
        StorageReference gsReference_arencia= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_arencia));

        StorageReference gsReference_arencia1= storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_arencia1));

        //???????????? ??? onlyeco
        StorageReference gsReference_onlyeco = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(0).getProductUrl(),
                gsReference_onlyeco));

        StorageReference gsReference_onlyeco1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("????????????").getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("????????????").getProducts().get(1).getProductUrl(),
                gsReference_onlyeco1));

        //???28 ??? tone28
        StorageReference gsReference_tone28 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???28").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("???28").getName(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(0).getProductUrl(),
                gsReference_tone28));

        StorageReference gsReference_tone281 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???28").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("???28").getName(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???28").getProducts().get(1).getProductUrl(),
                gsReference_tone281));

        //??????????????? ??? hellonature
        StorageReference gsReference_hellonature = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(0).getProductUrl(),
                gsReference_hellonature));

        StorageReference gsReference_hellonature1 = storage_fr.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef());
        items_fr.add(new Product(
                appState.getMeaningOutInfo().get("???????????????").getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getName(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getIntroduction(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getStorageRef(),
                appState.getMeaningOutInfo().get("???????????????").getProducts().get(1).getProductUrl(),
                gsReference_hellonature1));


        recyclerView_up.setAdapter(adapter);
        adapter.setItems(items);

        adapter.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView_ve.setAdapter(adapter_ve);
        adapter_ve.setItems(items_ve);
        adapter_ve.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter_ve.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView_ft.setAdapter(adapter_ft);
        adapter_ft.setItems(items_ft);
        adapter_ft.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter_ft.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView_do.setAdapter(adapter_do);
        adapter_do.setItems(items_do);
        adapter_do.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter_do.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView_pl.setAdapter(adapter_pl);
        adapter_pl.setItems(items_pl);
        adapter_pl.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter_pl.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView_fr.setAdapter(adapter_fr);
        adapter_fr.setItems(items_fr);
        adapter_fr.setOnItemClickListener(new OnProductItemClickListener() {
            @Override
            public void onItemClick(ProductAdapter.ViewHolder holder, View view, int position) {
                clickCount();
                Product item = adapter_fr.getItem(position);
                //Toast.makeText(getApplicationContext(), "?????? : " + item.getName() + "\n ?????? : " + item.getCost() +"\n ?????? : " + item.getNotification(),Toast.LENGTH_LONG).show();
            }
        });


        // ?????? ????????? ?????? ?????? ??? ?????????
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
        });//HashTag ????????? ?????? ??? ?????????
        hash_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_up);
                    }
                }, 50);
            }
        });

        hash_ve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_ve);
                    }
                }, 50);
            }
        });

        hash_ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_ft);
                    }
                }, 50);
            }
        });

        hash_do.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_do);
                    }
                }, 50);
            }
        });

        hash_aw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_ani);
                    }
                }, 50);
            }
        });

        hash_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        sv.scrollTo(0,top_pf);
                    }
                }, 50);
            }
        });
        // ?????? ?????? ?????? ??? ?????????
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
