package com.example.pavel.myapplication;

/**
 * Created by pavel on 4/11/2018.
 */

public class Movie {
    private String text;

    public Movie() {
    }

    public Movie(String text) {
        this.text = text;
    }

    public String getTitle() {
        return text;
    }

    public void setTitle(String name) {
        this.text = name;
    }
}