package com.example.nachos;

import android.app.Application;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class ApplicationState extends Application {

    private HashMap<String, SiteInfo> meaningOutInfo;
    private StoreManager storeManager;
    @Override
    public void onCreate() {
        //변수 초기화
        meaningOutInfo = new HashMap<>();
        String temp = getJsonString();
        System.out.println(temp);
        storeManager = new StoreManager(temp);
        meaningOutInfo = new HashMap<>(storeManager.getMeaningOutInfo());
        System.out.println("어플리케이션 생성됨");
        super.onCreate();
    }


    // 1. local test
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

    @Override
    public void onTerminate() {
        //프로세스 소멸 시
        super.onTerminate();
    }

    public HashMap<String, SiteInfo> getMeaningOutInfo() {
        return meaningOutInfo;
    }

    public void setMeaningOutInfo() {
        this.meaningOutInfo = storeManager.getMeaningOutInfo();
    }

}