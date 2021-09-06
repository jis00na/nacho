package com.example.nachos;

import java.util.ArrayList;

public class SiteInfo {

    private String name;
    private String url;
    private ArrayList<String> tags;

    SiteInfo() {
        this.name = "";
        this.url = "";
        this.tags = null;
    }

    SiteInfo(String name, String url, ArrayList<String> tags) {
        this.name = name;
        this.url = url;
        this.tags = tags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}