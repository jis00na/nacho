package com.example.nachos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.DriverManager.println;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class SiteActivity extends AppCompatActivity {

    private ApplicationState appState;
    private WebView webView;

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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // 뒤로가기 키를 누를 때 & 웹뷰가 뒤로 갈 수 있는 상태일 때 뒤로 가라는 명령
        if((keyCode == KeyEvent.KEYCODE_BACK) && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_site);
        appState = (ApplicationState) getApplication();
        webView = findViewById(R.id.webView);

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

        ListView listView_ani = findViewById(R.id.SiteList_ani); // 친환경
        ListView listView_do = findViewById(R.id.SiteList_do); // 기부, 후원 (donation)
        ListView listView_fair = findViewById(R.id.SiteList_fair); // 공정무역
        ListView listView_pla = findViewById(R.id.SiteList_pla); // 플라스틱 프리
        ListView listView_up = findViewById(R.id.SiteList_up); // 업사이클링
        ListView listView_ve = findViewById(R.id.SiteList_ve); // 비건

        // 제품 추가
        appState = (ApplicationState) getApplication();
        String baseUrl = "gs://nacho-da37d.appspot.com/";

        // ---------------------------------------------------------------------------------------
        // 친환경
        // ---------------------------------------------------------------------------------------

        // 여기 해야합니다




        // ---------------------------------------------------------------------------------------
        // 기부, 후원
        // ---------------------------------------------------------------------------------------
        SiteAdapter adapter_do = new SiteAdapter();

        // 4OCEAN
        FirebaseStorage storage_4OCEAN = FirebaseStorage.getInstance();
        StorageReference gsReference_4OCEAN = storage_4OCEAN.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("4OCEAN").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("4OCEAN").getName(),
                appState.getMeaningOutInfo().get("4OCEAN").getTags().get(0),
                appState.getMeaningOutInfo().get("4OCEAN").getLogoRef(),
                appState.getMeaningOutInfo().get("4OCEAN").getUrl(),
                gsReference_4OCEAN));

        // 녹챠방
        FirebaseStorage storage_nokchabang = FirebaseStorage.getInstance();
        StorageReference gsReference_nokchabang = storage_nokchabang.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("녹챠방").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("녹챠방").getName(),
                appState.getMeaningOutInfo().get("녹챠방").getTags().get(0),
                appState.getMeaningOutInfo().get("녹챠방").getLogoRef(),
                appState.getMeaningOutInfo().get("녹챠방").getUrl(),
                gsReference_nokchabang));

        // 데일리유니크
        FirebaseStorage storage_dailyUnique = FirebaseStorage.getInstance();
        StorageReference gsReference_dailyUnique = storage_dailyUnique.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("데일리유니크").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("데일리유니크").getName(),
                appState.getMeaningOutInfo().get("데일리유니크").getTags().get(0),
                appState.getMeaningOutInfo().get("데일리유니크").getLogoRef(),
                appState.getMeaningOutInfo().get("데일리유니크").getUrl(),
                gsReference_dailyUnique));

        // 메리디아니
        FirebaseStorage storage_meridiani = FirebaseStorage.getInstance();
        StorageReference gsReference_meridiani = storage_meridiani.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("메리디아니").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("메리디아니").getName(),
                appState.getMeaningOutInfo().get("메리디아니").getTags().get(0),
                appState.getMeaningOutInfo().get("메리디아니").getLogoRef(),
                appState.getMeaningOutInfo().get("메리디아니").getUrl(),
                gsReference_meridiani));

        // 모레상점
        FirebaseStorage storage_morestore = FirebaseStorage.getInstance();
        StorageReference gsReference_morestore = storage_morestore.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("모레상점").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("모레상점").getName(),
                appState.getMeaningOutInfo().get("모레상점").getTags().get(0),
                appState.getMeaningOutInfo().get("모레상점").getLogoRef(),
                appState.getMeaningOutInfo().get("모레상점").getUrl(),
                gsReference_morestore));

        // 비코
        FirebaseStorage storage_bcoe = FirebaseStorage.getInstance();
        StorageReference gsReference_bcoe = storage_bcoe.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("비코").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("비코").getName(),
                appState.getMeaningOutInfo().get("비코").getTags().get(0),
                appState.getMeaningOutInfo().get("비코").getLogoRef(),
                appState.getMeaningOutInfo().get("비코").getUrl(),
                gsReference_bcoe));

        // 비프렌드마켓
        FirebaseStorage storage_befriendmarket = FirebaseStorage.getInstance();
        StorageReference gsReference_befriendmarket = storage_befriendmarket.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("비프렌드마켓").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("비프렌드마켓").getName(),
                appState.getMeaningOutInfo().get("비프렌드마켓").getTags().get(0),
                appState.getMeaningOutInfo().get("비프렌드마켓").getLogoRef(),
                appState.getMeaningOutInfo().get("비프렌드마켓").getUrl(),
                gsReference_befriendmarket));

        // 아틀리에리케
        FirebaseStorage storage_atelierlykke = FirebaseStorage.getInstance();
        StorageReference gsReference_atelierlykke = storage_atelierlykke.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("아틀리에리케").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("아틀리에리케").getName(),
                appState.getMeaningOutInfo().get("아틀리에리케").getTags().get(0),
                appState.getMeaningOutInfo().get("아틀리에리케").getLogoRef(),
                appState.getMeaningOutInfo().get("아틀리에리케").getUrl(),
                gsReference_atelierlykke));

        // 윙블링
        FirebaseStorage storage_wingbling = FirebaseStorage.getInstance();
        StorageReference gsReference_wingbling = storage_wingbling.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("윙블링").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("윙블링").getName(),
                appState.getMeaningOutInfo().get("윙블링").getTags().get(0),
                appState.getMeaningOutInfo().get("윙블링").getLogoRef(),
                appState.getMeaningOutInfo().get("윙블링").getUrl(),
                gsReference_wingbling));

        // 팅클유
        FirebaseStorage storage_tingklu = FirebaseStorage.getInstance();
        StorageReference gsReference_tingklu = storage_tingklu.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("팅클유").getLogoRef());
        adapter_do.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("팅클유").getName(),
                appState.getMeaningOutInfo().get("팅클유").getTags().get(0),
                appState.getMeaningOutInfo().get("팅클유").getLogoRef(),
                appState.getMeaningOutInfo().get("팅클유").getUrl(),
                gsReference_tingklu));





        // ---------------------------------------------------------------------------------------
        // 공정무역
        // ---------------------------------------------------------------------------------------
        SiteAdapter adapter_fair = new SiteAdapter();

        // FairTradeKorea
        FirebaseStorage storage_FairTradeKorea = FirebaseStorage.getInstance();
        StorageReference gsReference_FairTradeKorea = storage_FairTradeKorea.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("FairTradeKorea").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("FairTradeKorea").getName(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getTags().get(0),
                appState.getMeaningOutInfo().get("FairTradeKorea").getLogoRef(),
                appState.getMeaningOutInfo().get("FairTradeKorea").getUrl(),
                gsReference_FairTradeKorea));

        // fynbo
        FirebaseStorage storage_fynbo = FirebaseStorage.getInstance();
        StorageReference gsReference_fynbo = storage_fynbo.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("fynbo").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("fynbo").getName(),
                appState.getMeaningOutInfo().get("fynbo").getTags().get(0),
                appState.getMeaningOutInfo().get("fynbo").getLogoRef(),
                appState.getMeaningOutInfo().get("fynbo").getUrl(),
                gsReference_fynbo));

        // 공기
        FirebaseStorage storage_gonggi = FirebaseStorage.getInstance();
        StorageReference gsReference_gonggi = storage_gonggi.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("공기").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("공기").getName(),
                appState.getMeaningOutInfo().get("공기").getTags().get(0),
                appState.getMeaningOutInfo().get("공기").getLogoRef(),
                appState.getMeaningOutInfo().get("공기").getUrl(),
                gsReference_gonggi));

        // 아름다운커피
        FirebaseStorage storage_beautifulcoffee = FirebaseStorage.getInstance();
        StorageReference gsReference_beautifulcoffee = storage_beautifulcoffee.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("아름다운커피").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("아름다운커피").getName(),
                appState.getMeaningOutInfo().get("아름다운커피").getTags().get(0),
                appState.getMeaningOutInfo().get("아름다운커피").getLogoRef(),
                appState.getMeaningOutInfo().get("아름다운커피").getUrl(),
                gsReference_beautifulcoffee));

        // 어스맨
        FirebaseStorage storage_earthman = FirebaseStorage.getInstance();
        StorageReference gsReference_earthman = storage_earthman.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("어스맨").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("어스맨").getName(),
                appState.getMeaningOutInfo().get("어스맨").getTags().get(0),
                appState.getMeaningOutInfo().get("어스맨").getLogoRef(),
                appState.getMeaningOutInfo().get("어스맨").getUrl(),
                gsReference_earthman));

        // 에코몽
        FirebaseStorage storage_ecomont = FirebaseStorage.getInstance();
        StorageReference gsReference_ecomont = storage_ecomont.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("에코몽").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("에코몽").getName(),
                appState.getMeaningOutInfo().get("에코몽").getTags().get(0),
                appState.getMeaningOutInfo().get("에코몽").getLogoRef(),
                appState.getMeaningOutInfo().get("에코몽").getUrl(),
                gsReference_ecomont));

        // 옥스팜
        FirebaseStorage storage_oxfam = FirebaseStorage.getInstance();
        StorageReference gsReference_oxfam = storage_oxfam.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("옥스팜").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("옥스팜").getName(),
                appState.getMeaningOutInfo().get("옥스팜").getTags().get(0),
                appState.getMeaningOutInfo().get("옥스팜").getLogoRef(),
                appState.getMeaningOutInfo().get("옥스팜").getUrl(),
                gsReference_oxfam));

        // 울림
        FirebaseStorage storage_ullim = FirebaseStorage.getInstance();
        StorageReference gsReference_ullim = storage_ullim.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("울림").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("울림").getName(),
                appState.getMeaningOutInfo().get("울림").getTags().get(0),
                appState.getMeaningOutInfo().get("울림").getLogoRef(),
                appState.getMeaningOutInfo().get("울림").getUrl(),
                gsReference_ullim));

        // 트립티
        FirebaseStorage storage_tripti = FirebaseStorage.getInstance();
        StorageReference gsReference_tripti = storage_tripti.getReferenceFromUrl(baseUrl + appState.getMeaningOutInfo().get("트립티").getLogoRef());
        adapter_fair.addItem(new SiteItem(
                appState.getMeaningOutInfo().get("트립티").getName(),
                appState.getMeaningOutInfo().get("트립티").getTags().get(0),
                appState.getMeaningOutInfo().get("트립티").getLogoRef(),
                appState.getMeaningOutInfo().get("트립티").getUrl(),
                gsReference_tripti));





        listView_ani.setAdapter(adapter_do);
        listView_do.setAdapter(adapter_do);
        listView_fair.setAdapter(adapter_fair);
        listView_pla.setAdapter(adapter_do);
        listView_up.setAdapter(adapter_do);
        listView_ve.setAdapter(adapter_do);

        setListViewHeight(listView_ani);
        setListViewHeight(listView_do);
        setListViewHeight(listView_fair);
        setListViewHeight(listView_pla);
        setListViewHeight(listView_up);
        setListViewHeight(listView_ve);



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
                    Intent intent = new Intent(SiteActivity.this, MypageActivity.class);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                }else{
                    // No user is signed in
                    Intent intent = new Intent(SiteActivity.this, AboutGoogleLogin.class);
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
                Intent intent = new Intent(SiteActivity.this, HomeActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        cate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(SiteActivity.this, CategoryActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(SiteActivity.this, ProductActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });

        stor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount();
                Intent intent = new Intent(SiteActivity.this, SiteActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }
        });
    }

    public void setListViewHeight(ListView listView){
        ListAdapter listAdapter = listView.getAdapter();

        int totalHeight = 0;

        for (int i = 0; i < listAdapter.getCount(); i++){
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
        return;
    }

    class SiteAdapter extends BaseAdapter {
        //데이터가 들어가있지 않고, 어떻게 담을지만 정의해뒀다.
        ArrayList<SiteItem> items = new ArrayList<SiteItem>();
        private WebView webView;

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
            siteItemView.setImage(item.getRef());
            View.OnClickListener gotosite;

            gotosite = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(SiteActivity.this, Webview.class);
                    intent.putExtra("url", item.getUrl());
                    startActivity(intent);
                }
            };

            siteItemView.setButton(gotosite);
            return siteItemView;
        }
    }
}
