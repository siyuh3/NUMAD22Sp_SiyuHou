package com.example.numad22sp_siyuhou;

public class ItemCard{
    private final String urlName;
    private final String url;

    public ItemCard(String urlName, String url){
        this.urlName = urlName;
        this.url = url;
    }

    public String getUrlName(){
        return urlName;
    }

    public String getUrl(){
        return url;
    }
}
