package org.superbiz.moviefun.moviesapi;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class MovieInfo {

    private String director;
    private String title;
    private int year;
    private String genre;
    private int rating;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    public MovieInfo() {
    }

    public MovieInfo(String title, String director, String genre, int rating , int year) {
        this.director = director;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDirector() {
        return director;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieInfo)) return false;
        MovieInfo movieInfo = (MovieInfo) o;
        return year == movieInfo.year &&
                rating == movieInfo.rating &&
                Objects.equals(director, movieInfo.director) &&
                Objects.equals(title, movieInfo.title) &&
                Objects.equals(genre, movieInfo.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, title, year, genre, rating);
    }
}
