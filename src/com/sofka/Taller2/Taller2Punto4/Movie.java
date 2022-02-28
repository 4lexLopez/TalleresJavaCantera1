package com.sofka.Taller2.Taller2Punto4;

public class Movie {
    int movieId;
    String movieName;
    String movieNotes;
    boolean movieAvailable;

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public boolean getMovieAvailable() {
        return movieAvailable;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setMovieNotes(String movieNotes) {
        this.movieNotes = movieNotes;
    }

    public void setMovieAvailable(boolean movieAvailable) {
        this.movieAvailable = movieAvailable;
    }

    public String getMovieNotes() {
        return movieNotes;
    }
}
