package com.example.nachos;
import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;
import androidx.annotation.Nullable;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.StorageReference;
import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.geo.type.Viewport;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class SiteItemView extends LinearLayout {

    //어디서든 사용할 수 있게하려면
    TextView textView, textView2;
    ImageView imageView;
    Button button;

    public SiteItemView(Context context) {
        super(context);
        init(context);//인플레이션해서 붙여주는 역
    }

    public SiteItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    // 지금 만든 객체(xml 레이아웃)를 인플레이션화(메모리 객체화)해서 붙여줌
    // LayoutInflater를 써서 시스템 서비스를 참조할 수 있음
    // 단말이 켜졌을 때 기본적으로 백그라운드에서 실행시키는 것을 시스템 서비스라고 함
    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.site_listview,this, true);

        textView = findViewById(R.id.SiteName);
        textView2 = findViewById(R.id.SiteCate);
        imageView = findViewById(R.id.SiteImage);
        button = findViewById(R.id.gotoSite);
    }

    public void setSite(String site){
        textView.setText(site);
    }
    public void setCategory(String category){
        textView2.setText(category);
    }
    /*
    public void setImage(String logo){
        imageView.setImageResource(logo);
    }*/
    public void setImage(String logo){Glide.with(this).load("").into(imageView);}
    public void setButton(OnClickListener gotosite){
        button.setOnClickListener(gotosite);
    }

}
