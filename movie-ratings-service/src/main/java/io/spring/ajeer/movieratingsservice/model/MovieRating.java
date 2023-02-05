package io.spring.ajeer.movieratingsservice.model;

public class MovieRating {
    private int movieId;
    private int movieRating;
    public MovieRating(int movieId, int movieRating){
        this.movieId = movieId;
        this.movieRating = movieRating;
    }

    public int getMovieId() {
        return movieId;
    }
    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRatings() {
        return movieRating;
    }

    public void setRatings(int movieRating) {
        this.movieRating = movieRating;
    }
    

}
