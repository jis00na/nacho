package com.example.nachos;

import android.content.res.AssetManager;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firestore.v1.WriteResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StoreManager {
    private FirebaseFirestore db;
    private String info;
    private ArrayList<SiteInfo> infoList = new ArrayList<SiteInfo>();
    private String[] options = {"Donation", "FairTrading", "Vegan", "ZeroWaste", "AnimalWelfare"};

    public StoreManager(String data){
        db = FirebaseFirestore.getInstance();
        this.info = data;
    }

    public void init(){
        jsonParsing(info);
        setDataToFirestore();
    }

    private void setDataToFirestore(){
        for(int i = 0; i < infoList.size(); i++){
            Map<String, Object> docData = new HashMap<>();
            docData.put("name", infoList.get(i).getName());
            docData.put("url", infoList.get(i).getUrl());
            docData.put("tags", infoList.get(i).getTags().get(0));
            for(int j = 0; j < infoList.get(i).getTags().size(); j++){
//                db.collection("encryptionVer")
//                        .document(infoList.get(i).getTags().get(j))
//                        .collection(infoList.get(i).getName())
//                        .add(docData);

                db.collection("normalVer")
                        .document(infoList.get(i).getTags().get(j))
                        .collection(infoList.get(i).getName())
                        .document(infoList.get(i).getName()) // document name 지정시 특징 keyword로 접근 가능, Or 키워드 암호화 형태로
                        .set(docData);
            }
        }
    }

    private void jsonParsing(String json)
    {
        try{
            JSONObject jsonObject = new JSONObject(json);
            for(int i = 0; i < options.length; i++) {
                JSONArray infoArray = jsonObject.getJSONArray(options[i]);
                for(int j=0; j < infoArray.length(); j++) {
                    JSONObject infoObject = infoArray.getJSONObject(j);
                    ArrayList<String> tags = new ArrayList<String>();
                    for(int k = 0; k < infoObject.getJSONArray("tags").length(); k++){
                        tags.add(infoObject.getJSONArray("tags").get(k).toString());
                    }
                    SiteInfo info = new SiteInfo(
                            infoObject.getString("name"),
                            infoObject.getString("url"),
                            tags);

                    infoList.add(info);
                }
            }
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void getData(){
        for(int i = 0; i < infoList.size(); i++){
            Log.e("info : ", infoList.get(i).getName());
            Log.e("info : ", infoList.get(i).getUrl());
            Log.e("info : ", infoList.get(i).getTags().get(0));
        }
    }
}