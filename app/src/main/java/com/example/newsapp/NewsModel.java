package com.example.newsapp;

import java.util.ArrayList;

public class NewsModel {
    private int result;
    private String status;
    private ArrayList<Articles> articles;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Articles> articles) {
        this.articles = articles;
    }

    public NewsModel(int result, String status, ArrayList<Articles> articles) {
        this.result = result;
        this.status = status;
        this.articles = articles;
    }
}
