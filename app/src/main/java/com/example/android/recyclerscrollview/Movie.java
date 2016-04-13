package com.example.android.recyclerscrollview;

public class Movie {
    private String title, genre, yers;

    public Movie() {
    }

    public Movie(String title, String genre, String yers) {
        this.title = title;
        this.genre = genre;
        this.yers = yers;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getYers() {
        return yers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYers(String yers) {
        this.yers = yers;
    }
}
