package com.example.veran.supernews;

/**
 * Created by veran on 20/05/2017.
 */

public class Noticia {
    private String title;
    private String body;

    public Noticia(){
        this.title = "No title";
        this.body = "No body";
    }

    public Noticia(String title, String body){
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return title;
    }
}
