package io.spring.ajeer.movieratingsservice.model;

import java.util.List;

public class UserRatings {
    private String userId; 
    private List<MovieRating> ratings;
    public UserRatings() {}
    public List<MovieRating> getRatings() {
        return ratings;
    }
    public void setRatings(List<MovieRating> ratings) {
        this.ratings = ratings;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
}
