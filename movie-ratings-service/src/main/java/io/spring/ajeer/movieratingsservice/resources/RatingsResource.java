package io.spring.ajeer.movieratingsservice.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.ajeer.movieratingsservice.model.MovieRating;
import io.spring.ajeer.movieratingsservice.model.UserRatings;

@RestController
@RequestMapping("/ratings")          
public class RatingsResource {
    List<MovieRating> movieRatings = Arrays.asList(
        new MovieRating(1000, 5),
        new MovieRating(1001, 2),
        new MovieRating(1002, 5),
        new MovieRating(1003, 5),
        new MovieRating(1004, 4),
        new MovieRating(1005, 2),
        new MovieRating(1006, 3)
    );
    @RequestMapping("/movie/{movieId}")
    public MovieRating getRatings(@PathVariable("movieId") String movieId){
        List<MovieRating> filteredItems = movieRatings.stream().filter((movieRatingItem) -> movieRatingItem.getMovieId() ==   Integer.parseInt(movieId, 10)).collect(Collectors.toList());
        if(filteredItems.size()> 0)
            return  filteredItems.get(0);
        return new MovieRating(0, 0);
    }

    @RequestMapping("/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId) {
        UserRatings userRatings = new UserRatings();
        userRatings.setUserId(userId);
        userRatings.setRatings(movieRatings);
        return userRatings;
    }
}
